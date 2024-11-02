package oop;

import java.util.Objects;

public class SuperPerson {
    public static void main(String[] args) {
        Person hong = new Person("Hong", 33);
        System.out.println("hong = " + hong);
        Person kim = new Person("Kim", 30);
        System.out.println("kim = " + kim);
        System.out.println("age=" + kim.getAge());
    }
}

class Person {
    private final String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        System.out.println("age=" + age);
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{"
                + "name='" + name + '\'' + ", age=" + age + '}';
    }
}