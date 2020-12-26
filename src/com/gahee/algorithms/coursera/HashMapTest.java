package com.gahee.algorithms.coursera;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapTest {

    public static void main(String[] args) {
        Person person = new Person("asdf", 23);
        Person person1 = new Person("asdf1", 23);
        Person person2 = new Person("asdf2", 23);
        Person person3 = new Person("asdf3", 23);
        Person person4 = new Person("asdf4", 23);

        HashMap<Person, ArrayList<Person>> map = new HashMap<>();
        ArrayList<Person> list = new ArrayList<>();

        list.add(person1);
        list.add(person2);
        map.put(person, list);

        list.clear();
        list.add(person3);
        list.add(person4);
        map.put(person2, list);

        for (Map.Entry<Person, ArrayList<Person>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "/ " + entry.getValue());
        }

        ArrayList<Person> p = map.get(new Person("asdf", 23));
        System.out.println("getting person asdf, age 23");
        System.out.println(p);
    }

}

class Person{
    String name;
    int age;
    Person leader;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
