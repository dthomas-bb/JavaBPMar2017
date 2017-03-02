package staticfactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Student {

    private String name;
    private List<String> courses;

    // private constructor avoids others being able to use it
    private Student() {
    }

    // static factory can return new or old object, this type
    // or any assignment-compatible type, and allows different
    // behavior names, avoiding need for overloading with different
    // argument type lists
    public static Student ofNameCourses(String name, String... courses) {
        if (name == null) {
            throw new IllegalArgumentException("Requires non null name");
        }
        Student self = new Student();
        self.name = name;
        self.courses = Arrays.asList(courses); // structurally immutable list...
//        self.courses = new ArrayList(Arrays.asList(courses)); // mutable option

        return self;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", courses=" + courses + '}';
    }

    public int getEnthusiasm() {
        return courses.size();
    }
    
    public static Comparator<Student> getEnthusiamComparator() {
        return enthusiamComp;
    }
    
    private static Comparator<Student> enthusiamComp = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getEnthusiasm() - o2.getEnthusiasm();
        }
    };

}
