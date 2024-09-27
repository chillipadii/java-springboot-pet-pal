package sg.com.petpal.petpal.serviceImpls;

import java.util.ArrayList;

import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import sg.com.petpal.petpal.dto.OwnerCreateDTO;
import sg.com.petpal.petpal.dto.OwnerUpdateDTO;
import sg.com.petpal.petpal.model.Owner;
import sg.com.petpal.petpal.model.OwnerAuth;
import sg.com.petpal.petpal.repository.OwnerRepository;
import sg.com.petpal.petpal.service.OwnerService;

@Primary
@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PasswordEncoder passwordEncoder;

    public OwnerServiceImpl(OwnerRepository ownerRepository,
            PasswordEncoder passwordEncoder) {
        this.ownerRepository = ownerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Owner createOwner(OwnerCreateDTO ownerCreateDTO) {
        // Map DTO to Owner entity
        Owner owner = Owner.builder()
                .name(ownerCreateDTO.getName())
                .areaLocation(ownerCreateDTO.getAreaLocation())
                .build();

        // Map DTO to OwnerAuth entity
        OwnerAuth ownerAuth = OwnerAuth.builder()
                .email(ownerCreateDTO.getEmail())
                .password(passwordEncoder.encode(ownerCreateDTO.getPassword()))
                .build();

        // Set bi-directional relationship
        owner.setOwnerAuth(ownerAuth);
        ownerAuth.setOwner(owner);

        // Save owner (OwnerAuth will be cascaded and saved automatically)
        return ownerRepository.save(owner);
    }

    @Override
    public Owner getOwner(Long id) {
        return null;
    };

    @Override
    public ArrayList<Owner> getAllOwners() {
        return null;
    };

    @Override
    public Owner updateOwner(OwnerUpdateDTO dto) {
        return null;
    };

    @Override
    public void deleteOwner(Long id) {
    };
}
