package ru.innopolis.university.homework.lesson05.task01;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PetStorage {

    private static final Set<Pet> pets =
            new TreeSet<>(Comparator.comparing(Pet::getOwner)
                    .thenComparing(Pet::getName)
                    .thenComparing(Pet::getWeight));

    /**
     * Provides to add new pet to storage.
     *
     * @throws IllegalArgumentException if input pet is null.
     * @throws IllegalArgumentException if pet already exist in storage.
     * @param pet to add in storage.
     */
    public void add(Pet pet) {
        if (null != pet) {
            if (pets.contains(pet)) {
                throw new IllegalArgumentException("not allowed to add pet with same id " + pet.getId());
            }
            pets.add(pet);
            return;
        }

        throw new IllegalArgumentException("not allowed to add null value");
    }

    /**
     * Provides to find pet with specified name.
     *
     * @throws IllegalArgumentException if input name is null.
     * @param name of pet to find in storage.
     * @return list of found pets if exist or empty list if not.
     */
    public List<Pet> findByName(String name) {
        if (null != name) {
            return pets.stream()
                    .filter(pet -> pet.getName().equalsIgnoreCase(name))
                    .collect(Collectors.toList());
        }

        throw new IllegalArgumentException("not allowed to find by null value");
    }

    /**
     * Provides to edit pet with specified id by incoming layout.
     *
     * @throws IllegalArgumentException if dummy per is null.
     * @param id of pet to edit in storage.
     * @param pet is a dummy for editing pet in storage.
     * @return true if the change occurred, false if not.
     */
    public boolean edit(long id, Pet pet) {
        if (null == pet) {
            throw new IllegalArgumentException("not allowed null value for pet");
        }

        Pet petToEdit = pets.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        if (null != petToEdit) {
            petToEdit.setName(pet.getName());
            petToEdit.setOwner(pet.getOwner());
            petToEdit.setWeight(pet.getWeight());
            return true;
        }

        return false;
    }

    /**
     * Print all pets presented in storage sorted by owner, name and weight.
     */
    public void printSort() {
        pets.forEach(System.out::println);
    }
}
