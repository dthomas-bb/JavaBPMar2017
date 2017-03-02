package staticfactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class School {

    public static void main(String[] args) {
        List<Student> school = new ArrayList<>(Arrays.asList(
                Student.ofNameCourses("Fred", "Math", "Physics"),
                Student.ofNameCourses("Jim", "Journalism"),
                Student.ofNameCourses("Sheila", "Engineering", "Tribology", "Astro Physics")
        ));
        school.forEach(s -> System.out.println("- " + s));
        school.sort(Student.getEnthusiamComparator());
        System.out.println("------------------------------");
        school.forEach(s -> System.out.println("- " + s));
    }

}
