package sg.com.petpal.petpal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sg.com.petpal.petpal.model.PetData;

@Repository
public interface PetDataRepository extends JpaRepository<PetData, Long> {

}