package sg.com.petpal.petpal;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import sg.com.petpal.petpal.model.Gender;
import sg.com.petpal.petpal.model.Pet;
import sg.com.petpal.petpal.repository.PetRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DataLoader implements CommandLineRunner {

    //@Autowired
    //private OwnerRepository ownerRepository;

    @Autowired
    private PetRepository petRepository;

    @Override
    public void run(String... args) throws Exception {
        
        // Create the fist Pet (Buddy)
        Pet pet1 = new Pet();
        pet1.setName("Buddy");
        pet1.setGender(Gender.MALE);
        pet1.setAge(2);
        pet1.setNeutered(true);
        //pet.setOwner(owner);

        // Save Owner and Pet
        //ownerRepository.save(owner);
        petRepository.save(pet1);
        
        
        // Create the second Pet (Happy)
        Pet pet2 = new Pet();
        pet2.setName("Happy");
        pet2.setGender(Gender.FEMALE);
        pet2.setAge(3);
        pet2.setNeutered(false);
        //pet.setOwner(owner);

        // Save Owner and Pet
        //ownerRepository.save(owner);
        petRepository.save(pet2);
        
        // Create the third Pet (Charlie)
        Pet pet3 = new Pet();
        pet3.setName("Charlie");
        pet3.setGender(Gender.MALE);
        pet3.setAge(2);
        pet3.setNeutered(false);
        //pet.setOwner(owner);

        // Save Owner and Pet
        //ownerRepository.save(owner);
        petRepository.save(pet3);

    }
}
