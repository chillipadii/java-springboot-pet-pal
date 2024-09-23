package sg.com.petpal.petpal;


import sg.com.petpal.petpal.Pet;
import sg.com.petpal.petpal.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    // Get all pets
    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        List<Pet> pets = petService.findAll();
        return ResponseEntity.ok(pets);
    }

    // Get a pet by id
    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        Optional<Pet> pet = petService.findById(id);
        return pet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new pet
    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
        Pet createdPet = petService.save(pet);
        return ResponseEntity.ok(createdPet);
    }

    // Update a pet
    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id, @RequestBody Pet pet) {
        Pet updatedPet = petService.update(id, pet);
        return ResponseEntity.ok(updatedPet);
    }

    // Delete a pet
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

