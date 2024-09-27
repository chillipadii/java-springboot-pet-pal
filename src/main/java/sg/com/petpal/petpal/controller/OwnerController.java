package sg.com.petpal.petpal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import sg.com.petpal.petpal.dto.owner.OwnerCreateDTO;
import sg.com.petpal.petpal.dto.owner.OwnerBasicDTO;
import sg.com.petpal.petpal.dto.owner.OwnerUpdateDTO;
import sg.com.petpal.petpal.service.OwnerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    // Get all owners
    @GetMapping({ "/", "" })
    public ResponseEntity<List<OwnerBasicDTO>> getOwners() {
        List<OwnerBasicDTO> allOwners = ownerService.getAllOwners();
        return ResponseEntity.status(HttpStatus.OK).body(allOwners);

    }

    // Get owner by id
    @GetMapping("/{id}")
    public ResponseEntity<OwnerBasicDTO> getOwner(@PathVariable Long id) {
        OwnerBasicDTO owner = ownerService.getOwner(id);
        return ResponseEntity.status(HttpStatus.OK).body(owner);
    }

    // Create owner
    @PostMapping("/new")
    public ResponseEntity<OwnerBasicDTO> createOwner(@Valid @RequestBody OwnerCreateDTO dto) {
        System.out.println("Engaged createOwner POST API");
        OwnerBasicDTO response = ownerService.createOwner(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Delete owner
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    // Update owner
    @PatchMapping("/{id}")
    public ResponseEntity<OwnerBasicDTO> updateOwner(@PathVariable Long id, @RequestBody OwnerUpdateDTO dto) {
        OwnerBasicDTO owner = ownerService.updateOwner(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(owner);
    }

}
