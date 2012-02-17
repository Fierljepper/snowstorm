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

    public static final String PACKAGE_DOMAIN = "net.snowstorm";
    
    public static final String RETURN_LINEFEED = "\n";

    public static final String TAB = "\t";

    private static final List<String> blackListedMethods = new ArrayList<String>();
    
    private String indent = "";
    
    static {
        blackListedMethods.add("getClass");
        blackListedMethods.add("getBytes");
        blackListedMethods.add("isEmpty");
        blackListedMethods.add("isNaN");
    }

    public String reflectMethodState(Object object){
        return reflectMethodState(object, null);
    }
    
    @SuppressWarnings("all")
    private String reflectMethodState(Object object, Object parent){
        String reflected = "";

        if (object != null){
            Class type = object.getClass();
            String fullClassQName = type.getName();
            if (!fullClassQName.startsWith(PACKAGE_DOMAIN)){
                return "";
            }

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
                        reflected +=  indent + methodName + " = " + method.invoke(object, null) + RETURN_LINEFEED;
                        Object returnTypeIterable = method.invoke(object, null);
                        if (returnTypeIterable != null && !returnTypeIterable.getClass().isPrimitive()){
                            if (returnTypeIterable instanceof Collection){
                                for (Object returnType: (Collection)returnTypeIterable){
                                    indent += TAB;
                                    reflected += RETURN_LINEFEED + reflectMethodState(returnType, type);
                                }
                                // Primitive types return false for instanceof Object[]
                            } else if (returnTypeIterable.getClass().isArray()){
                                indent += TAB;
                                for (int i = 0; i < Array.getLength(returnTypeIterable); i++){
                                    Object returnType = Array.get(returnTypeIterable, i);
                                    reflected += indent + returnType + RETURN_LINEFEED;
                                }
                            }
                            else {
                                if(returnTypeIterable.getClass().getName().startsWith(PACKAGE_DOMAIN))
                                {
                                    indent += TAB;
                                    reflected += reflectMethodState(returnTypeIterable, type);
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
        indent = indent.replaceFirst("\t", "");
        return reflected;
    }

}
