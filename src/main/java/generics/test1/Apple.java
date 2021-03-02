package generics.test1;

// 定义Apple类时使用了泛型声明
public class Apple<T> {

    /**
     * 静态变量和静态方法中不能使用形参
     * static T info;
     * public static void bar(T msg){}
     */

    private T info;

    public Apple(){}

    public Apple(T info){
        this.info = info;
    }

    public void setInfo(T info){
        this.info = info;
    }

    public T getInfo(){
        return this.info;
    }

    public static void main(String[] args) {
        Apple<String> a1 = new Apple<>("aaa");
        System.out.println(a1.getInfo());
        Apple<Double> a2 = new Apple<>(5.67);
        System.out.println(a2.getInfo());
    }
}
