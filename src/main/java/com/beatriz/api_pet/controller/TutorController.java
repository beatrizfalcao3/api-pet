package com.beatriz.api_pet.controller;

import com.beatriz.api_pet.model.Tutor;
import com.beatriz.api_pet.model.dto.TutorDTO;
import com.beatriz.api_pet.service.ServicoTutor;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutores")
@Tag(name = "Tutores", description = "Tutores APIs")
public class TutorController {

    private final ServicoTutor servicoTutor;

    public TutorController(ServicoTutor servicoTutor) {
        this.servicoTutor = servicoTutor;
    }

    @GetMapping()
    public List<Tutor> getAll(){
        return servicoTutor.getTutores();
    }


    @GetMapping(value = "/{id}")
    public Tutor getTutorById(@PathVariable(name = "id") Long id){
        return servicoTutor.getTutorById(id);
    }

    @PostMapping
    public ResponseEntity<Tutor> saveTutor(@RequestBody TutorDTO tutorDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(servicoTutor.saveTutor(tutorDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Tutor> updateTutor(@RequestBody TutorDTO tutorDTO, @PathVariable(name = "id") Long id){
        return ResponseEntity.ok(servicoTutor.updateTutor(tutorDTO, id));
    }
}
