package net.snowstorm.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA. User: developer Date: 2/13/12 Time: 11:34 PM To change this template use File | Settings |
 * File Templates.
 */
public class ReflectionHelper {

    private static final Logger LOG = LoggerFactory.getLogger(ReflectionHelper.class);

    public static final String RETURN_LINEFEED = "\n";

    public static final String TAB = "\t";

    private static final List<String> blackListedMethods = new ArrayList<String>();
    
    static {
        blackListedMethods.add("getClass");
    }
    
    private String indent = "";
    
    @SuppressWarnings("all")
    public String reflectMethodState(Object object){
        String reflected = "";
        if (object != null){
            Class type = object.getClass();
            reflected = indent + type.getSimpleName() + RETURN_LINEFEED;
            Method[] methods = type.getMethods();
            String methodName = "";
            for (Method method: methods){
                methodName = method.getName();
                if (methodName.length() > 0 && (methodName.startsWith("get") || methodName.startsWith("is")) && method
                        .getParameterTypes().length <=
                        0 &&
                        !blackListedMethods
                        .contains(methodName)){
                    try {
                        reflected += indent + methodName + " = " + method.invoke(object, null) + RETURN_LINEFEED;
                        Object returnTypeIterable = method.invoke(object, null);
                        if (returnTypeIterable != null){
                            if (returnTypeIterable instanceof Collection){
                                indent += TAB;
                                reflected += RETURN_LINEFEED;
                                for (Object returnType: (Collection)returnTypeIterable){
                                    reflected += reflectMethodState(returnType);
                                }
                                // Primitive types return false for instanceof Object[]
                            } else if (returnTypeIterable.getClass().isArray()){
                                indent += TAB;
                                reflected += RETURN_LINEFEED;
                                for (int i = 0; i < Array.getLength(returnTypeIterable); i++){
                                    Object returnType = Array.get(returnTypeIterable, i);
                                    reflected += indent + returnType + RETURN_LINEFEED;
//                                    reflected += reflectMethodState(returnType);
                                }
                            }
                        }
                    } catch (IllegalAccessException e) {
                        LOG.error("Do not access " + methodName + " through reflection", e);
                    } catch (InvocationTargetException e) {
                        LOG.error("Do not invoke " + methodName + " through reflection", e);
                    }
                }
            }
        }
        return reflected + RETURN_LINEFEED;
    }
}
