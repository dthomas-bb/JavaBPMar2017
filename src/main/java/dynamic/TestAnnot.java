package dynamic;

//@DoStuff
public class TestAnnot {
//    @DoStuff
    private int value = 99;
    
    @DoStuff
    public void aMethod() {
        System.out.println("This is aMethod");
    }
    
    @DoStuff
    private void anotherMethod() {
        System.out.println("A private method");
    }

    @Override
    public String toString() {
        return "TestAnnot{" + "value=" + value + '}';
    }
    
}
