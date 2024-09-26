package sg.com.petpal.petpal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerCreateDTO {

    @NotBlank(message = "Name cannot be blank.")
    private String name;

    @NotBlank(message = "Area location cannot be blank.")
    private String areaLocation;

    @Email(message = "Email should be valid.")
    @NotBlank(message = "Email cannot be blank.")
    private String email;

    @NotBlank(message = "Password cannot be blank.")
    private String password;
}
