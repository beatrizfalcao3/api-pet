package com.beatriz.api_pet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDto {

    private String nome;
    private String raca;
    private String idade;
    private String cor;
    private Long tutorId;
}
