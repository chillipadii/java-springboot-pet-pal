package sg.com.petpal.petpal.service;

import java.util.ArrayList;

import sg.com.petpal.petpal.model.Owner;


public interface OwnerService {

    Owner createOwner(Owner owner);

    Owner getOwner (Long id);

    ArrayList<Owner> getAllOwners (Owner owner);

    Owner updateOwner (Owner owner);
}
