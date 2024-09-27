package sg.com.petpal.petpal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.com.petpal.petpal.model.PetData;

public interface PetDataRepository extends JpaRepository<PetData, Long> {

}