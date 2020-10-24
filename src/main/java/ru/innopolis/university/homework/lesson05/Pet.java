package ru.innopolis.university.homework.lesson05;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

public class Pet {

    private final long id;

    private String name;

    private BigDecimal weight;

    private Person owner;

    private static final AtomicLong sequenceId = new AtomicLong();

    public Pet(String name, BigDecimal weight, Person owner) {
        id = sequenceId.incrementAndGet();
        this.name = name;
        this.weight = weight;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        return new EqualsBuilder()
                .append(id, pet.id)
                .append(name, pet.name)
                .append(weight, pet.weight)
                .append(owner, pet.owner)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(weight)
                .append(owner)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", owner=" + owner +
                '}';
    }
}
