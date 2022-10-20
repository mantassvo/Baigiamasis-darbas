package Vigi19.Baigiamasis_darbas.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter

public class GetRegistrationFormsOfPersonsResponseDTO {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
}
