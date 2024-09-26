package sg.com.petpal.petpal;


import sg.com.petpal.petpal.model.Pet;
import sg.com.petpal.petpal.repository.PetRepository;
import sg.com.petpal.petpal.service.PetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;



@RestController
@RequestMapping("/pets")
public class PetController {

    private static final String UPLOAD_DIR = "uploads/";
    
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetService petService;

    // Upload a picture for a pet
    @PostMapping("/{petId}/picture")
    public ResponseEntity<String> uploadPicture(@PathVariable Long petId, @RequestParam("file") MultipartFile file) {
        try {
        // Ensure that the pet exists
        Pet pet = petRepository.findById(petId).orElseThrow(() -> new RuntimeException("Pet not found"));

        // Ensure the uploads directory exists
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();  // Create the directory if it doesn't exist
        }

        // Save the file
        String fileName = file.getOriginalFilename();
        Path path = Paths.get(UPLOAD_DIR + fileName);
        Files.write(path, file.getBytes());

        // Add the path to the pet's pictures list
        if (pet.getPictures() == null) {
            pet.setPictures(new ArrayList<>());
        }
        pet.getPictures().add(path.toString());

        petRepository.save(pet);

        return ResponseEntity.ok("Picture uploaded successfully");
        } catch (IOException e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading picture");
        }
    }



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

