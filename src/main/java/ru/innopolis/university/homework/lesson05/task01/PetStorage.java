package ru.innopolis.university.homework.lesson05.task01;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetStorage {

    /**
     * @key long is id of pet.
     * @value Pet which is associated with key id.
     */
    private static final Map<Long, Pet> pets =
            new HashMap<>();

    public PetStorage(List<Pet> input) {
        input.forEach(PetStorage::accept);
    }

    /**
     * Provides to add new pet to storage.
     *
     * @throws IllegalArgumentException if input pet is null.
     * @throws IllegalArgumentException if pet already exist in storage.
     * @param pet to add in storage.
     */
    public void add(Pet pet) {
        if (null != pet) {
            if (pets.containsKey(pet.getId())) {
                throw new IllegalArgumentException("not allowed to add pet with same id " + pet.getId());
            }
            accept(pet);
            return;
        }

        throw new IllegalArgumentException("not allowed to add null value");
    }

    /**
     * Provides to find pet with specified name.
     *
     * @throws IllegalArgumentException if input name is null.
     * @param name of pet to find in storage.
     * @return found pet if exist or null if not.
     */
    public Pet findByName(String name) {
        if (null != name) {
            return pets.values().stream()
                    .filter(pet -> pet.getName().equalsIgnoreCase(name))
                    .findFirst()
                    .orElse(null);
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
        if (null != pets.get(id)) {
            if (null == pet) {
                throw new IllegalArgumentException("not allowed null value for pet");
            }
            Pet current = pets.get(id);
            current.setName(pet.getName());
            current.setOwner(pet.getOwner());
            current.setWeight(pet.getWeight());
            return true;
        }

        return false;
    }

    /**
     * Print all pets presented in storage sorted by owner, name and weight.
     */
    public void printSort() {
        pets.values().stream()
                .sorted(Comparator.comparing(Pet::getOwner)
                        .thenComparing(Pet::getName)
                        .thenComparing(Pet::getWeight))
                .forEach(System.out::println);

    }

    private static void accept(Pet pet) {
        if (pet != null) {
            pets.put(pet.getId(), pet);
            return;
        }

        throw new IllegalArgumentException("not allowed null value");
    }
}
