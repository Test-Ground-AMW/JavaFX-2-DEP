import com.sun.java.accessibility.util.EventID;

import java.sql.DriverManager;
import java.util.ArrayList;

public class ClassLoadersDemo {
    public static void main(String[] args) {
        // Application class loader
        ClassLoader loader1 = ClassLoadersDemo.class.getClassLoader();
        System.out.println(loader1);
        System.out.println(MyClass.class.getClassLoader());

        // Bootstrap class loader(parent) -> loading Java SE classes
        ClassLoader loader2 = ArrayList.class.getClassLoader();
        System.out.println(loader2);
        ClassLoader loader3 = System.class.getClassLoader();
        System.out.println(loader3);

        // Utility/Extension/Platform class loader -> Java SE ext classes
        ClassLoader loader4 = DriverManager.class.getClassLoader();
        System.out.println(loader4);
        ClassLoader loader5 = EventID.class.getClassLoader();
        System.out.println(loader5);
        }
}
