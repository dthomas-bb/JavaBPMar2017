package dynamic;

import java.io.FileReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Properties;

public class MyFramework {
    public static void main(String[] args) throws Throwable {
        Properties prop = new Properties();
        prop.load(new FileReader("properties.properties"));
        String classToLoad = prop.getProperty("classToLoad");
        System.out.println("Loading class " + classToLoad);
        Class cl = Class.forName(classToLoad);
        Object obj = cl.newInstance();
        System.out.println("Loaded: " + obj);
        Method [] methods = cl.getMethods();
        for (Method m : methods) {
            System.out.println("> " + m);
            DoStuff annot = m.getAnnotation(DoStuff.class);
            if (annot != null) {
                System.out.println("**** Annotation found!!!");
            }
        }
    }
}
