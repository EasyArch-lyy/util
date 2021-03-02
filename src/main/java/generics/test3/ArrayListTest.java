package generics.test3;

import java.util.ArrayList;
import java.util.List;

interface Obj{
    void run();
}

class Person implements Obj{

    @Override
    public void run() {
        System.out.println("Person");
    }
}

class Car implements Obj{

    @Override
    public void run() {
        System.out.println("Car");
    }
}

public class ArrayListTest {

    public static void doOpt(List<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            Person p = list.get(i);
            p.run();
        }
    }

    public static void main(String[] args) {
        Person p = new Person();
        Car c = new Car();
        ArrayList<Person> list = new ArrayList<>();
        list.add(p);
        doOpt(list);
    }
}
