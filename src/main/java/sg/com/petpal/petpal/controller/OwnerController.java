package sg.com.petpal.petpal.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import sg.com.petpal.petpal.dto.OwnerCreateDTO;
import sg.com.petpal.petpal.dto.OwnerUpdateDTO;
import sg.com.petpal.petpal.model.Owner;
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
    public ResponseEntity<ArrayList<Owner>> getOwners() {
        ArrayList<Owner> allOwners = ownerService.getAllOwners();
        return ResponseEntity.status(HttpStatus.OK).body(allOwners);

    }

    // Get owner by id
    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwner(@PathVariable Long id) {
        Owner owner = ownerService.getOwner(id);
        return ResponseEntity.status(HttpStatus.OK).body(owner);
    }

    // Create owner
    @PostMapping({ "/", "" })
    public ResponseEntity<Owner> createOwner(@Valid @RequestBody OwnerCreateDTO dto) {
        Owner owner = ownerService.createOwner(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(owner);
    }

    // Delete owner
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    // Update owner
    @PatchMapping("/{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable Long id, @RequestBody OwnerUpdateDTO dto) {
        Owner owner = ownerService.updateOwner(dto);
        return ResponseEntity.status(HttpStatus.OK).body(owner);
    }

}
