
package sg.com.petpal.petpal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.com.petpal.petpal.model.Pet;


    public interface PetRepository extends JpaRepository<Pet, Long> {}

