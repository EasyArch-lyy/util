package generics.test1;

public class Test1 extends Apple<String> {

    public String getInfo(){
        return "子类" + super.getInfo();
    }

    public static void main(String[] args) {
        Test1 t = new Test1();
        System.out.println(t.getInfo());
    }
}
