package sg.com.petpal.petpal.service;

import java.util.ArrayList;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import sg.com.petpal.petpal.model.PetData;
import sg.com.petpal.petpal.repository.PetDataRepository;

@Primary
@Service
public class PetDataServiceImpl implements PetDataService {

    private PetDataRepository petDataRepository;

    public PetDataServiceImpl(PetDataRepository petDataRepository) {
        this.petDataRepository = petDataRepository;
    }

    @Override
    public PetData createPetData(PetData petData) {
        return petDataRepository.save(petData);
    }

    @Override
    public PetData getPetData(Long id) {
        return petDataRepository.findById(id).get();
    }

    @Override
    public ArrayList<PetData> getAllPetData() {
        return (ArrayList<PetData>) petDataRepository.findAll();
    }

    @Override
    public PetData updatePetData(PetData petData) {
        return petDataRepository.save(petData);
    }

    @Override
    public void deletePetData(Long id) {
        petDataRepository.deleteById(id);
    }
}
