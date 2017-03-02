package immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Immut {
    private String name;
    // returning a final modified courses does *not* create an immutable list
    private final List<String> courses;

    public Immut(String name, List<String> courses) {
        this.name = name;
        this.courses = new ArrayList(courses);
    }

    public String getName() {
        return name;
    }

    // "Obviously" must not have setters...
//    public void setName(String name) {
//        this.name = name;
//    }

    public List<String> getCourses() {
        return Collections.unmodifiableList(courses);
    }

//    public void setCourses(List<String> courses) {
//        this.courses = courses;
//    }
    
    
}
