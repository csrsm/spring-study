package com.cm.proxy;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ProxyUtils {

    /**
     * 1 .java
     * 2 .class
     * 3 .new 反射
     * @Param 目标对象
     * @return
     * 模拟简易jdk动态代理的过程，使用字符串模拟生成目标对象的类，并加入代理逻辑，返回代理对象的过程。
     */
    public static Object newIntance(Object target, CmInvocationHandlerImpl h) {
        //最终返回的代理对象
        Object proxy = null;
        //最终需要的代理类的字符串
        String content = "";
        //获取目标对象实现的接口
        Class targetInterface = target.getClass().getInterfaces()[0];
        //获取目标对象接口的所有方法
        Method methods[] =  targetInterface.getMethods();
        //换行符
        String line = "\n";
        //缩进符
        String tab = "\t";
        //获取接口名称
        String inferfaceName = targetInterface.getSimpleName();
        //临时代理类所在包
        String packageContent = "package com.cm;" + line;
        //目标接口导入路径
        String importContent = "import " + targetInterface.getName() + ";" + line
                +"import java.lang.reflect.Method;" + line
                +"import java.lang.Exception;" + line
                +"import com.cm.proxy.CmInvocationHandlerImpl;" + line;
        String clazzFirstLineContent = "public class $Proxy implements "+ inferfaceName + " {" + line;
        //代理类中的属性
        //String fileContent = tab + "private "+ inferfaceName + " target;" + line;
        String fileContent = tab + "private CmInvocationHandlerImpl h; " + line;
        //代理类构造方法
        String constructorContent = tab + "public $Proxy ( CmInvocationHandlerImpl h) {" + line
                + tab + tab +"this.h = h;" + line
                + tab +"}" + line;
        /*String constructorContent = tab + "public $Proxy (" + inferfaceName + " target) {" + line
                + tab + tab +"this.target = target;" + line
                + tab +"}" + line;*/
        //拼接目标类中多有的方法
        String methodContent = "";
        for(Method method : methods) {
            //返回值类型
            String returnType = method.getReturnType().getSimpleName();
            //方法名
            String methodName = method.getName();
            //参数
            Class args[] = method.getParameterTypes();
            String argsContent = "";
            String paramsContent = "";
            for (int i = 0; i < args.length; i++) {
                String temp = args[i].getSimpleName();
                if(i == args.length -1) {
                    argsContent += temp + " p" + i ;
                    paramsContent += "p" + i;
                }else {
                    argsContent += temp + " p" + i + ",";
                    paramsContent += "p" + i + ",";
                }
            }
            //动态代理要执行的方法
            methodContent += tab + "public " + returnType + " " + methodName +"(" + argsContent + ") throws Exception {" + line
                        + tab + tab + "Method method = Class.forName(\"" +targetInterface.getName()+ "\").getDeclaredMethod(\""+ methodName + "\");" +line
                        + tab + tab + "return (" +returnType+")h.invoke(method);" + line
                        + tab + "}" + line;

            //判断是否有返回值
            /*if("void".equals(returnType)) {
                methodContent += tab + "public " + returnType + " " + methodName +"(" + argsContent + ") {" + line
                        + tab + tab + " System.out.println(\"__________log 动态代理___________\");" + line
                        + tab + tab + "h.invoke(" + method + ");" + line
                        + tab + tab + "target." + methodName + "(" + paramsContent + ");" + line
                        + tab + "}" + line;
            }else {
                methodContent += tab + "public " + returnType + " " + methodName +"(" + argsContent + ") {" + line
                        + tab + tab + " System.out.println(\"__________log 动态代理___________\");" + line
                        + tab + tab + "h.invoke(" + method + ");" + line
                        + tab + tab + "return target." + methodName + "(" + paramsContent + ");" + line
                        + tab + "}" + line;
            }*/

        }
        //拼接代理类字符串
        //content = packageContent + importContent + clazzFirstLineContent + fileContent + constructorContent + methodContent + "}";
        content = packageContent + importContent + clazzFirstLineContent + fileContent + constructorContent + methodContent + "}";
        //生成代理类java文件
        File file = new File("/Users/cm/Project/学习课程/java/jdk-proxy/src/main/java/com/cm/$Proxy.java");

        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.flush();
            fileWriter.close();
            //借助jdk第三方工具来将文件编译成class文件 略
            //通过代理类文件反射java对象
            URL urls[] = new URL[]{new URL("file:/Users/cm/Project/学习课程/java/jdk-proxy/src/main/java/")};
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            Class clazz = urlClassLoader.loadClass("com.cm.$Proxy");

            //通过构造方法返回代理对象
            Constructor constructor = clazz.getConstructor(CmInvocationHandlerImpl.class);
            proxy = constructor.newInstance(h);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return proxy;
    }

}
