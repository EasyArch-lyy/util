#java基础知识复习

---
####annotation  注解部分     
DeprecatedTest       --- @Deprecated过时的方法或类注解 \
SuppressWarningsTest --- @SuppressWarnings关闭整个类中的编译器警告 \
InheritableTest      --- @Retention: 定义注解的保留策略 \
                     --- @Inherited：说明子类可以继承父类中的该注解 \
                     --- @Target：定义注解的作用目标 \
MyTest               --- 使用自定义注解修饰方法                    
pkg                  --- 定义在包上的注解   
---

####polymorphism  多态部分   

---

####代理
proxy            代理        
interceptortest  拦截器  -->责任链模式(一个对象在一条链上被多个拦截器处理) \
dutyChain      ---责任链模式

---

#spring部分学习
initiative  主动创建对象
passive     被动创建对象(使用spring)
injection   注入（构造器注入，接口注入，setter注入）
assembly    bean装配(xml装配。命名空间装配。注解装配。)  
      xmltest      xml装配
      annotation   注解装配
        anto       自动装配
aoptest     spring AOP
Aspect切面        
Advice通知：切面开启后切面的方法，根据代理对象真实方法调用前、后顺序
before前置通知：动态代理反射原对象方法或执行环绕通知前执行的通知功能
after动态代理反射原有对象或方法后通知执行
afterReturing动态代理反射原有对象方法或
Induction引入
Pointcut切点
join point连接点
Weaving织入        
        
        




