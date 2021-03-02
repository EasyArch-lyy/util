package polymorphism.extendTest;
/**
 * 类的继承：子可以从基类上继承方法，不需显式定义，视为对类的复用，也可子类自行定义方法
 * 父类声明子类对象为向上转型
 * Cleanser c = new Detergent();
 * 父类不能调用子类变量
 *
 *
 * super()表示使用父类方法，this()表示使用本类方法
 * 子类加载时先加载父类对象，再加载子类对象
 */
class Cleanser {

    private String s = "Cleanser";

    public void append(String a){
        s += a;
    }

    public void dilute(){
        append("dilute()");
    }

    public void apply(){
        append("apply()");
    }

    public void scrub(){
        append("scrub()");
    }

    public String toString(){
        return s;
    }

    public static void main(String[] args) {
        Cleanser cleanser = new Cleanser();
        cleanser.dilute();
        cleanser.apply();
        cleanser.scrub();
        System.out.println(cleanser);
    }

}

public class Detergent extends Cleanser{
    public void scrub(){
        append("Deterget.scrub()");
        super.scrub();
    }

    public void foam(){
        append("foam()");
    }

    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.scrub();
        x.apply();
        x.dilute();
        x.foam();
        System.out.println(x);
        System.out.println("Testing base class:");
        Cleanser.main(args);
    }
}
