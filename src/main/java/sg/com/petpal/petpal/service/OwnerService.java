package sg.com.petpal.petpal.service;

import java.util.List;

import sg.com.petpal.petpal.dto.owner.OwnerCreateDTO;
import sg.com.petpal.petpal.dto.owner.OwnerBasicDTO;
import sg.com.petpal.petpal.dto.owner.OwnerUpdateDTO;

public interface OwnerService {

    OwnerBasicDTO createOwner(OwnerCreateDTO dto);

    OwnerBasicDTO getOwner(Long id);

    List<OwnerBasicDTO> getAllOwners();

    OwnerBasicDTO updateOwner(Long id, OwnerUpdateDTO dto);

    void deleteOwner(Long id);
    // Authentication should ideally be in the headers, with JWT right? 
    // Unless looking for an admin route delete other owners
}
