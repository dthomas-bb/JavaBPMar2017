package dynamic;

import java.io.FileReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Properties;

public class MyFramework {

    public static void main(String[] args) throws Throwable {
        Properties prop = new Properties();
        // File opening defaults to the project directory in most IDEs
        prop.load(new FileReader("properties.properties"));
        String classToLoad = prop.getProperty("classToLoad");
        System.out.println("Loading class " + classToLoad);
        // java.lang.Class object describes a class:
        Class cl = Class.forName(classToLoad);
        // instantiation that invokes the zero arg constructor
        // other constructors are available, but must have semantic 
        // agreement on how to provide necessary arguments
        Object obj = cl.newInstance();

//        System.setSecurityManager(new SecurityManager());

        System.out.println("Loaded: " + obj);
        // getMethods does not see private, but does see inherited
//        Method [] methods = cl.getMethods();
        // getDeclaredMethods sees all "my" methods, but not inherted stuff
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("> " + m);
            DoStuff annot = m.getAnnotation(DoStuff.class);
            if (annot != null) {
                System.out.println("**** Annotation found!!!");
                m.setAccessible(true);
                m.invoke(obj);
            }
        }
    }
}
