package proxy.cglib;

import java.lang.reflect.InvocationTargetException;

public class ReflectServiceImpl2 {

    private String name;

    public ReflectServiceImpl2(String name) {
        this.name = name;
    }

    public void sayHellpo() {
        System.err.println("hello" + name);
    }

    public ReflectServiceImpl2 getInstance(){
        ReflectServiceImpl2 obj = null;
        try {
            // 通过
            obj = (ReflectServiceImpl2) Class.forName("proxy.cglib.ReflectServiceImpl2").getConstructor(String.class).newInstance("张三");
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
