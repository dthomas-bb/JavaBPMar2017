package staticfactory;

import java.util.Comparator;

public class BadStudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getEnthusiasm() - o2.getEnthusiasm();
    }
}
