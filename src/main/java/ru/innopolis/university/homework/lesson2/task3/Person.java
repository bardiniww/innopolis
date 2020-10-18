package ru.innopolis.university.homework.lesson2.task3;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Comparator;

class Person implements Comparable<Person> {

    private int age;

    private Sex sex;

    private String name;

    public enum Sex {
        MAN,
        WOMAN
    }

    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person person) {

        if (this.getName().equalsIgnoreCase(person.getName()) && this.getAge() == person.getAge()) {
            throw new RuntimeException();
        }

        return Comparator.comparing(Person::getSex)
                .thenComparing(Person::getAge, Comparator.reverseOrder())
                .thenComparing(Person::getName)
                .compare(this, person);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return new EqualsBuilder()
                .append(age, person.age)
                .append(sex, person.sex)
                .append(name, person.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(age)
                .append(sex)
                .append(name)
                .toHashCode();
    }

    @Override
    public String toString() {

        return "Person{" +
                "age=" + age +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                '}';
    }
}
