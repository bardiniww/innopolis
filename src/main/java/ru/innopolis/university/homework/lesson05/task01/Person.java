package ru.innopolis.university.homework.lesson05.task01;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Person implements Comparable<Person> {

    private String name;

    private int age;

    private String sex;

    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex.toString();
    }

    @Override
    public int compareTo(Person o) {
        int i = this.getName().compareTo(o.getName());
        if (i != 0) {
            return i;
        }

        i = Integer.compare(this.getAge(), o.getAge());
        if (i != 0) {
            return i;
        }

        return this.getSex().compareTo(o.getSex());
    }

    public enum Sex {
        MAN {
            @Override
            public String toString() {
                return "Man";
            }
        },
        WOMAN {
            @Override
            public String toString() {
                return "Woman";
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return new EqualsBuilder()
                .append(age, person.age)
                .append(name, person.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(age)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
