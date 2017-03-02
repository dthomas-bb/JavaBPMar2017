package dynamic;

//@DoStuff
public class TestAnnot {
    @SetStuff(value = "A textual value...")
    private String value = "unset";
    @SetStuff
    private int intVal = 0;
    
    @DoStuff
    public void aMethod() {
        System.out.println("This is aMethod");
    }
    
    @DoStuff
    private void anotherMethod() {
        System.out.println("A private method");
    }

    @DoStuff
    public void show() {
        System.out.println("Object has: " + toString());
    }

    @Override
    public String toString() {
        return "TestAnnot{" + "value=" + value + ", intVal=" + intVal + '}';
    }
    
    
}
