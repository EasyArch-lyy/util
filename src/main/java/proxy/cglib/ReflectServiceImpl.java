package proxy.cglib;

public class ReflectServiceImpl {
    public void sayHello(String name) {
        System.err.println("Hello World" + name);
    }

    public ReflectServiceImpl getInstance() {
        ReflectServiceImpl obj = null;
        try {
            // 给类加载器注册一个类ReflectServiceImpl的全限定名，然后通过newInstance()初始化一个对象
            obj = (ReflectServiceImpl) Class.forName("proxy.cglib.ReflectServiceImpl").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
