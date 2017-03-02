package staticfactory;

import java.util.Comparator;

// This comparator is "in the wrong place", it should be in the
// Student class
public class BadStudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getEnthusiasm() - o2.getEnthusiasm();
    }
}
