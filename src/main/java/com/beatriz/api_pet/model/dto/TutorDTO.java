package com.beatriz.api_pet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutorDTO {

    private String nome;
    private String cpf;
    private String telefone;
}
