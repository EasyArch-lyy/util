package interceptortest.dutyChain;

import interceptortest.InterceptorJdkProxy;
import proxy.jdkProxy.HelloWorld;
import proxy.jdkProxy.HelloWorldImpl;
/**
 * 责任链模式
 * 优点：可以在传递链上增加新的拦截器和拦截逻辑
 * 缺点：增加反射和代理性能下降
 */
public class Test {

    public static void main(String[] args) {

        HelloWorld proxy1 = (HelloWorld) InterceptorJdkProxy.bind(
                new HelloWorldImpl(),
                "interceptortest.dutyChain.Interceptor1");

        HelloWorld proxy2 = (HelloWorld) InterceptorJdkProxy.bind(
                proxy1,
                "interceptortest.dutyChain.Interceptor2");

        HelloWorld proxy3 = (HelloWorld) InterceptorJdkProxy.bind(
                proxy2,
                "interceptortest.dutyChain.Interceptor3");

        proxy3.sayHelloWorld();
    }
}
