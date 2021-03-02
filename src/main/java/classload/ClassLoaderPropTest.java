package classload;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderPropTest {

    public static void main(String[] args) throws IOException {

        /**
         * 获取系统类加载器
         * 获取系统类加载器的加载路径通常由CLADDPATH环境变量决定，默认环境变量路径作为系统类加载器加载路径
         */
        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器:" + systemLoader);
        Enumeration<URL> em = systemLoader.getResources("");
        while (em.hasMoreElements()) {
            System.out.println(em.nextElement());
        }

        // 获取系统类加载器的父类加载器：得到扩展类加载器
        ClassLoader exensionLader = systemLoader.getParent();
        System.out.println("扩展类加载器：" + exensionLader);
        System.out.println("扩展类加载器的路径:" + System.getProperty("java.ext.dirs"));
        System.out.println("扩展类加载器的parent:" + exensionLader.getParent());


        System.out.println("================");
        try {
            ClassLoader classLoader = Class.forName("classload.ClassLoaderPropTest").getClassLoader();
            System.out.println(classLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
