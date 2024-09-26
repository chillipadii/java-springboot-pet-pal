package sg.com.petpal.petpal.model;

import akarta.persisten

import lombok.Getter;
import lombok.NoArgsConstructor;
import 


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
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

    @ElementCollection
    @Column(name = "pet")
    private List<Long> pet;
}

    