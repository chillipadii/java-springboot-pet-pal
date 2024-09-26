package sg.com.petpal.petpal.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;;

@RestController
@RequestMapping("/petData")
public class PetDataController {

    @GetMapping("")
    public String getAll() {
        return "Testing";
    }

}
