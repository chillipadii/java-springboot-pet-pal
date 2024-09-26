package sg.com.petpal.petpal.service;

import java.util.ArrayList;

import sg.com.petpal.petpal.dto.OwnerCreateDTO;
import sg.com.petpal.petpal.dto.OwnerUpdateDTO;
import sg.com.petpal.petpal.model.Owner;

public interface OwnerService {

    Owner createOwner(OwnerCreateDTO dto);

    Owner getOwner(Long id);

    ArrayList<Owner> getAllOwners();

    Owner updateOwner(OwnerUpdateDTO dto);

    void deleteOwner(Long id);
    // Authentication should ideally be in the headers, with JWT right? 
    // Unless looking for an admin route delete other owners
}
