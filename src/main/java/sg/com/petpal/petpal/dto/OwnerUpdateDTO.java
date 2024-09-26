package sg.com.petpal.petpal.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sg.com.petpal.petpal.annotations.NotBlankIfPresentValidaton;

@Getter
@Setter
public class OwnerUpdateDTO {

    @NotBlankIfPresentValidaton
    private String name;

    @Valid
    private List<ValidOwnerMatches> ownerMatches;

    @NotBlankIfPresentValidaton
    private String areaLocation;

    @Email(message = "Email should be valid.")
    @NotBlankIfPresentValidaton
    private String email;

    @NotBlankIfPresentValidaton
    private String password;
    // Should be asking for old password, new password and confirm new password, keep it in mind

}

@Getter
@Setter
@AllArgsConstructor
class ValidOwnerMatches {

    @NotNull(message = "Value cannot be null.")
    @Min(value = 1, message = "Value must be greater than or equal to 1.")
    private Long value;
}