package interceptortest;

import java.lang.reflect.Method;

public interface Interceptor {

    /**
     * 真实对象前调用，返回为true时返回真实对象，返回false时调用around方法
     * @param proxy 代理对象
     * @param target 真实对象
     * @param method 方法
     * @param args 运行方法参数
     */
    public boolean before(Object proxy, Object target, Method method, Object[] args);

    public void around(Object proxy, Object target, Method method, Object[] args);
    /**
     * 调用真实对象方法或around()执行后调用
     */
    public void after(Object proxy, Object target, Method method, Object[] args);
}
