package generics.test4;

import java.util.ArrayList;
import java.util.List;

abstract class Shape{
    public abstract void draw(Canvas canvas);
}

class Circle extends Shape{
    public void draw(Canvas canvas) {
        System.out.println("在画布"+canvas+"上画一个圆");
    }
}

class Rectangle extends Shape{
    public void draw(Canvas canvas){
        System.out.println("把矩形上画在画布"+canvas+"上");
    }
}

public class Canvas {

    // 同时在画布上绘制多个形状，使用被限制的泛型通配符
    public void drawAll(List<? extends Shape> shapes) {
        for (Shape s : shapes) {
            s.draw(this);
        }
    }

    public static void main(String[] args) {
        List<Circle> circleList = new ArrayList<>();
        Canvas c = new Canvas();
        circleList.add(new Circle());

        c.drawAll(circleList);

        List<Rectangle> rectangleList = new ArrayList<>();
        Canvas c1 = new Canvas();
        rectangleList.add(new Rectangle());
        c1.drawAll(rectangleList);
    }
}
