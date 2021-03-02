package generics.test1;

public class Test2 extends Apple{

    public String getInfo(){

        // super.getInfo()方法返回值为object类型,
        return super.getInfo().toString();
    }
}
