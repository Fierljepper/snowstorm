package net.snowstorm.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
            reflected = indent + type.getSimpleName() + "\n";
            Method[] methods = type.getMethods();
            String methodName = "";
            for (Method method: methods){
                methodName = method.getName();
                if (methodName.startsWith("get") && method.getParameterTypes().length <= 0 && !blackListedMethods
                        .contains(methodName)){
                    try {
                        reflected += indent + methodName + " = " + method.invoke(object, null) + "\n";
                        Object returnTypeList = method.invoke(object, null);
                        if (returnTypeList != null && returnTypeList instanceof Collection){
                            indent += "\t";
                            reflected += "\n";
                            for (Object returnType: (Collection)returnTypeList){
                                reflected += reflectMethodState(returnType);
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
        return reflected + "\n";
    }
}
