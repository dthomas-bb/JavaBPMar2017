package constant;

public class ConstantStuff {

    final String fred; // MUST be assigned exactly once prior to completion of initialization

    public ConstantStuff() {
        fred = "";
    }

    public ConstantStuff(int x) {
        try {
//            fred = ""; // insufficient initialization because might be skipped due to exception!
        } finally {
//            fred = "banana"; // potential second assignment not allowed!!
        }
        fred = ""; // Must be assigned before completion of initializer
    }

    public static void main(String[] args) {
//        final String s = "hello";
//        s += " world"; cannot change a final after initialization
//        System.out.println(s);
    }
}
