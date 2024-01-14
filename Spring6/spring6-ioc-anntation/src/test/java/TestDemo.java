import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

@Component
@ComponentScan(basePackages = "com.atguigu.spring6")
public class TestDemo {

//    @Autowired
//    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        testDemo.function();

    }

    public  void function() {

        // 获取传递过来的接口类路径
        String interfacePath = "com.atguigu.spring6.autowired.service.TranService";
        String methodName = "function(1111,22222,333333)";
        // 使用 Reflections 扫描整个类路径
        //Reflections reflections = new Reflections("");
        //reflections 对象将扫描 com.atguigu.spring6.autowired.service 包下的所有类。
        //如果你想要同时扫描多个包，你可以将它们用逗号分隔：Reflections reflections = new Reflections("com.example,another");
        Reflections reflections = new Reflections("com.atguigu.spring6.autowired.service");
        /**
         * getSubTypesOf 方法是 Reflections 库中的一个功能，它用于获取某个类或接口的所有子类或实现类。这个方法的作用在于帮助你动态地发现类的继承关系，而不需要在编码时硬编码这些关系。
         * 假设你有一个接口 MyInterface 和两个实现类 ClassA 和 ClassB：
         * public interface MyInterface {
         * }
         *
         * public class ClassA implements MyInterface {
         * }
         *
         * public class ClassB implements MyInterface {
         * }
         * 你可以使用 Reflections 来动态地获取 MyInterface 的所有子类：
         * Reflections reflections = new Reflections("com.example"); // 指定包路径
         * Set<Class<? extends MyInterface>> subTypes = reflections.getSubTypesOf(MyInterface.class);
         *
         * for (Class<? extends MyInterface> subType : subTypes) {
         *     System.out.println(subType.getName());
         * }
         * 上述代码中，getSubTypesOf 方法将返回一个 Set，其中包含所有继承自 MyInterface 的子类。在这个例子中，它将包含 ClassA 和 ClassB。
         */
        // 获取实现接口的类
        Set<Class<?>> classes = reflections.getSubTypesOf((Class<Object>) loadClass(interfacePath));
//        Iterator it = classes.iterator();
//        Class<?> clazz = null;
//        while (it.hasNext()) {
//            clazz = (Class<?>) it.next();
//        }
//        Object serviceBean = applicationContext.getBean(clazz);
//        // 手动触发依赖注入
//        applicationContext.getAutowireCapableBeanFactory().autowireBean(serviceBean);
        // 如果有实现类，则实例化并调用接口方法
        if (!classes.isEmpty()) {
            Class<?> implementationClass = classes.iterator().next();
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
    private Object instantiateAndCast(Class<?> implementationClass)
            throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        return implementationClass.getDeclaredConstructor().newInstance();
    }

    // 加载类
    private Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class not found: " + className, e);
        }
    }

    // 查找方法
    private Method findMethod(Class<?> implementationClass, String methodName, int paramCount) {
        for (Method method : implementationClass.getDeclaredMethods()) {
            if (method.getName().equals(methodName) && method.getParameterCount() == paramCount) {
                return method;
            }
        }
        return null;
    }

    // 解析方法名和参数
    private String[] parseMethodName(String methodName) {
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
    private Object[] extractMethodParameters(String[] methodParams, Class<?>[] parameterTypes) {
        Object[] parameters = new Object[methodParams.length];
        for (int i = 0; i < methodParams.length; i++) {
            parameters[i] = convertToType(methodParams[i], parameterTypes[i]);
        }
        return parameters;
    }

    // 将参数字符串转换为实际类型
    private Object convertToType(String param, Class<?> type) {
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