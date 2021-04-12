package aoptest.game;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBeanUtil implements InvocationHandler {

    // 被代理对象
    private Object obj;

    // 拦截器
    private Interceptor interceptor = null;

    /**
     * 获取动态代理对象
     * @param obj 被代理对象
     * @param interceptor 拦截器
     * @return 动态代理对象
     */
    public static Object getBean(Object obj, Interceptor interceptor){
        // 使用当前类作为代理方法，被代理对象执行方法的时候，会进入当前invoke方法
        ProxyBeanUtil _this = new ProxyBeanUtil();
        // 保存被代理对象
        _this.obj = obj;
        // 保存拦截器
        _this.interceptor = interceptor;
        // 生成代理对象并绑定代理方法
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), _this);
    }

    /**
     * 代理方法
     * @param proxy 代理对象
     * @param method 当前调度方法
     * @param args 参数
     * @return 方法返回
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object retObj = null;
        // 是否产生异常
        boolean exceotionFlag = false;
        // before方法
        interceptor.before(obj);
        try {
            retObj = method.invoke(obj, args);
        } catch (Exception ex){
            exceotionFlag = true;
        }finally {
            // after方法
            interceptor.after(obj);
        }
        if(exceotionFlag){
            // afterThrowing方法
            interceptor.afterThrowing(obj);
        }
        return retObj;
    }
}
