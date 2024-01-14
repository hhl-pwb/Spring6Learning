package com.atguigu.spring6.autowired.util;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

@Component
public class ReflectionUtils {
    private static ApplicationContext applicationContext;

    @Autowired
    private void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }

    public static void function() {

        // 获取传递过来的接口类路径
        String interfacePath = "com.atguigu.spring6.autowired.service.TranService";
        String methodName = "function(1111,22222,333333)";
        Reflections reflections = new Reflections("com.atguigu.spring6.autowired.service");

        // 获取实现接口的类
        Set<Class<?>> classes = reflections.getSubTypesOf((Class<Object>) loadClass(interfacePath));
        // 如果有实现类，则实例化并调用接口方法
        if (!classes.isEmpty()) {
            Class<?> implementationClass = classes.iterator().next();
            Object serviceBean = applicationContext.getBean(implementationClass);
            applicationContext.getAutowireCapableBeanFactory().autowireBean(serviceBean);

            try {
                // 实例化并转换为 Object 类型
                Object instance = instantiateAndCast(implementationClass);

                // 解析方法名和参数
                String[] methodInfo = parseMethodName(methodName);
                String methodNameOnly = methodInfo[0];
                String[] methodParams = methodInfo[1].split(",");

                // 获取方法
                Method method = findMethod(implementationClass, methodNameOnly, methodParams.length);
                if (method != null) {
                    // 输出方法名
                    System.out.println("Method: " + method.getName());

                    // 获取方法参数类型
                    Class<?>[] parameterTypes = method.getParameterTypes();

                    // 获取方法参数值
                    Object[] parameters = extractMethodParameters(methodParams, parameterTypes);

                    // 调用方法
                    method.invoke(instance, parameters);
                } else {
                    System.out.println("Method not found: " + methodNameOnly);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No implementation found.");
        }
    }

    // 泛型方法：实例化并强制类型转换为 Object 类型
    private static Object instantiateAndCast(Class<?> implementationClass)
            throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        return implementationClass.getDeclaredConstructor().newInstance();
    }

    // 加载类
    private static Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class not found: " + className, e);
        }
    }

    // 查找方法
    private static Method findMethod(Class<?> implementationClass, String methodName, int paramCount) {
        for (Method method : implementationClass.getDeclaredMethods()) {
            if (method.getName().equals(methodName) && method.getParameterCount() == paramCount) {
                return method;
            }
        }
        return null;
    }

    // 解析方法名和参数
    private static String[] parseMethodName(String methodName) {
        int openParenIndex = methodName.indexOf('(');
        int closeParenIndex = methodName.indexOf(')');
        //有参数
        if (openParenIndex != -1 && closeParenIndex != -1 && closeParenIndex > openParenIndex + 1) {
            String methodNameOnly = methodName.substring(0, openParenIndex);
            String methodParams = methodName.substring(openParenIndex + 1, closeParenIndex);
            return new String[]{methodNameOnly, methodParams};
        } else {//无参数
            return new String[]{methodName, ""};
        }
    }

    // 获取方法参数值
    private static Object[] extractMethodParameters(String[] methodParams, Class<?>[] parameterTypes) {
        Object[] parameters = new Object[methodParams.length];
        for (int i = 0; i < methodParams.length; i++) {
            parameters[i] = convertToType(methodParams[i], parameterTypes[i]);
        }
        return parameters;
    }

    // 将参数字符串转换为实际类型
    private static Object convertToType(String param, Class<?> type) {
        if (type == int.class || type == Integer.class) {
            return Integer.parseInt(param);
        } else if (type == double.class || type == Double.class) {
            return Double.parseDouble(param);
        } else if (type == float.class || type == Float.class) {
            return Float.parseFloat(param);
        } else if (type == long.class || type == Long.class) {
            return Long.parseLong(param);
        } else if (type == short.class || type == Short.class) {
            return Short.parseShort(param);
        } else if (type == byte.class || type == Byte.class) {
            return Byte.parseByte(param);
        } else if (type == char.class || type == Character.class) {
            return param.charAt(0);
        } else if (type == boolean.class || type == Boolean.class) {
            return Boolean.parseBoolean(param);
        } else {
            return param; // 默认为字符串
        }
    }
}
