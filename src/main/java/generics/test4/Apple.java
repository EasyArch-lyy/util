package generics.test4;

public class Apple<T extends Number> {
    T col;

    public static void main(String[] args) {
        Apple apple = new Apple();
        Apple<Integer> ai = new Apple<>();
        Apple<Double> ad = new Apple<>();
        Apple<Long> a = new Apple<>();
    }
}
