package main;

public class Person {
    public String name;
    public String surname;
    public int age;



    public Person() {
        System.out.println("Men default/susmaya gore yaradildim");
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    //
    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
