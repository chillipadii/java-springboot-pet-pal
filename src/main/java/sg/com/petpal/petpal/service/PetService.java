
package sg.com.petpal.petpal.service;

import sg.com.petpal.petpal.model.Pet;
import sg.com.petpal.petpal.repository.PetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    // Find all pets
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    // Find pet by id
    public Optional<Pet> findById(Long id) {
        return petRepository.findById(id);
    }

    // Create new pet
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    // Update existing pet
    public Pet update(Long id, Pet updatedPet) {
        return petRepository.findById(id).map(pet -> {
            pet.setName(updatedPet.getName());
            pet.setGender(updatedPet.getGender());
            pet.setAge(updatedPet.getAge());
            pet.setNeutered(updatedPet.isNeutered());
            pet.setPictures(updatedPet.getPictures());
            pet.setDescription(updatedPet.getDescription());
            pet.setOwner(updatedPet.getOwner());
            pet.setPetData(updatedPet.getPetData());
            return petRepository.save(pet);
        }).orElseGet(() -> {
            updatedPet.setId(id);
            return petRepository.save(updatedPet);
        });
    }

    // Delete pet by id
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
