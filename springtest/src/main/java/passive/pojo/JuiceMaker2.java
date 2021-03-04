package passive.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 果汁制造机2
 * <p>
 * 被动创建橙汁
 */
public class JuiceMaker2 implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    // 饮料店
    private String beverageShop = null;
    private Source source = null;

    public String makeJuice() {
        return "这是一杯由:" + beverageShop + "饮料店提供的" + source.getSize() + source.getSugar() + source.getFruit();
    }

    public String getBeverageShop() {
        return beverageShop;
    }

    public void setBeverageShop(String beverageShop) {
        this.beverageShop = beverageShop;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("[" + this.getClass().getSimpleName() + "]调用BeanFactoryAware接口的setBeanFactory方法");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("[" + this.getClass().getSimpleName() + "]调用BeanNameAware接口的setBeanName方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【" + this.getClass().getSimpleName() + "】执行自定义销毁方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用InitializingBean接口的afterPropertiesSet方法");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(
                "【" + this.getClass().getSimpleName() + "】调用ApplicationContextAware接口的setApplicationContext方法");

    }
}
