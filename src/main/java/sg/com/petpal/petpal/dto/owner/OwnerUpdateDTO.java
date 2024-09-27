package sg.com.petpal.petpal.dto.owner;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import sg.com.petpal.petpal.annotations.NotBlankIfPresentValidaton;

@Getter
public class OwnerUpdateDTO {

    @NotBlankIfPresentValidaton
    private String name;

    @NotBlankIfPresentValidaton
    private String areaLocation;

    @Email(message = "Email should be valid.")
    @NotBlankIfPresentValidaton
    private String email;

    @NotBlankIfPresentValidaton
    private String oldPassword;

    @NotBlankIfPresentValidaton
    private String newPassword;

    @NotBlankIfPresentValidaton
    private String confirmPassword;
}