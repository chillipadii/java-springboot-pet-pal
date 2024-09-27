package sg.com.petpal.petpal.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pet_data")
public class PetData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "breed", nullable = false)
    private String breed;

    @Column(name = "animal_group", nullable = false)
    private String animalGroup;

    @OneToMany(mappedBy = "petData", cascade = CascadeType.ALL)
    private List<Pet> pets;
}
