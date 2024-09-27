package sg.com.petpal.petpal.dto.owner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OwnerBasicDTO {

    private Long id;

    private String name;

    private String areaLocation;
    
    private String email;

}
