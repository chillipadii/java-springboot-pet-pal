
package sg.com.petpal.petpal;

import org.springframework.data.jpa.repository.JpaRepository;


    public interface PetRepository extends JpaRepository<Pet, Long> {}

