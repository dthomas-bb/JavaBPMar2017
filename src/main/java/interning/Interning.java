package interning;

public class Interning {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        System.out.println("s1 == s2 " + (s1 == s2));
        String s3 = "He";
        String s4 = "llo";
        String s5 = s3 + s4;
        System.out.println("s2 == s5 " + (s2 == s5));
        // find / put this into the constant pool
        s5 = s5.intern();
        System.out.println("s2 == s5 " + (s2 == s5));
    }
}
