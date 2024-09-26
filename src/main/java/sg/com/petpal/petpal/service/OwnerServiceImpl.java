package sg.com.petpal.petpal.service;

import java.util.ArrayList;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import sg.com.petpal.petpal.dto.OwnerCreateDTO;
import sg.com.petpal.petpal.dto.OwnerUpdateDTO;
import sg.com.petpal.petpal.model.Owner;

@Primary
@Service
public class OwnerServiceImpl implements OwnerService {

    public Owner createOwner(OwnerCreateDTO dto) {
        return null;
    };

    public Owner getOwner(Long id) {
        return null;
    };

    public ArrayList<Owner> getAllOwners() {
        return null;
    };

    public Owner updateOwner(OwnerUpdateDTO dto) {
        return null;
    };

    public void deleteOwner(Long id) {
    };
}
