package interceptortest;

import proxy.jdkProxy.HelloWorld;
import proxy.jdkProxy.HelloWorldImpl;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用拦截器实现代理逻辑
 */
public class InterceptorJdkProxy implements InvocationHandler {

    // 真实对象
    private Object target;
    // 拦截器全名
    private String interceptorClass = null;

    public InterceptorJdkProxy(Object target, String interceptorClass) {
        this.interceptorClass = interceptorClass;
        this.target = target;
    }

    /**
     * 绑定委托对象并返回一个代理占位
     *
     * @param target
     * @return 代理对象占位
     */
    public static Object bind(Object target, String interceptorClass) {
        // 获取代理对象
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InterceptorJdkProxy(target, interceptorClass));
    }

    /**
     * 通过代理对象调用方法，首先进入这个方法
     * @param proxy 代理方法
     * @param method 被调用方法
     * @param args 方法的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (interceptorClass == null) {
            // 没有设置拦截器则直接反射原有方法
            return method.invoke(target, args);
        }
        Object result = null;
        //
        Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).newInstance();
        // 调用前置方法
        if (interceptor.before(proxy, target, method, args)) {
            // 反射原有对象方法
            result = method.invoke(target, args);
        } else {
            // 返回false后执行around方法
            interceptor.around(proxy, target, method, args);
        }
        // 调用后置方法
        interceptor.after(proxy, target, method, args);
        return result;
    }

    public static void main(String[] args) {
        HelloWorld proxy = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(),"interceptortest.MyInterceptor");
        proxy.sayHelloWorld();
    }
}
