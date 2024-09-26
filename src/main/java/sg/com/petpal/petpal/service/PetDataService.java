package sg.com.petpal.petpal.service;

import java.util.ArrayList;

import sg.com.petpal.petpal.model.PetData;

public interface PetDataService {

    PetData createPetData(PetData petData);

    PetData getOwner(Long id);

    ArrayList<PetData> getAllOwners();

    PetData updateOwner(PetData petData);

    void deletePetData(Long id);
}
