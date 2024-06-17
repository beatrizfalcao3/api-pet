package com.beatriz.api_pet.controller;

import com.beatriz.api_pet.model.Pet;
import com.beatriz.api_pet.model.Tutor;
import com.beatriz.api_pet.model.dto.PetDto;
import com.beatriz.api_pet.model.dto.TutorDTO;
import com.beatriz.api_pet.service.ServicoPet;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
@Tag(name = "Pets", description = "Pets APIs")
public class PetController {

    private final ServicoPet servicoPet;

    public PetController(ServicoPet servicoPet) {
        this.servicoPet = servicoPet;
    }

    @GetMapping()
    public List<Pet> getAll(){
        return servicoPet.getPets();
    }

    @PostMapping
    public ResponseEntity<Pet> savePet(@RequestBody PetDto petDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(servicoPet.savePet(petDto));
    }

    @GetMapping(value = "{tutorId}")
    public ResponseEntity<List<Pet>> getPetsByTutorId(@PathVariable(name = "tutorId") Long tutorId){
        return ResponseEntity.ok(servicoPet.getPetsByTutorId(tutorId));
    }
    @GetMapping("/pet/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(servicoPet.getPetsById(id));
    }

    @PutMapping("/pet/{id}")
    public ResponseEntity<Pet> updatePet(@RequestBody PetDto petDto, @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(servicoPet.updatePet(petDto, id));
    }
    @DeleteMapping("/pet/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable(name = "id") Long id) {
        servicoPet.deletePet(id);
        return ResponseEntity.noContent().build();
    }



//    @GetMapping(value = "/{id}")
//    public Tutor getTutorById(@PathVariable(name = "id") Long id){
//        return servicoTutor.getTutorById(id);
//    }
//
//    @PostMapping
//    public ResponseEntity<Tutor> saveTutor(@RequestBody TutorDTO tutorDTO){
//        return ResponseEntity.status(HttpStatus.CREATED).body(servicoTutor.saveTutor(tutorDTO));
//    }
//
//    @PutMapping(value = "/{id}")
//    public ResponseEntity<Tutor> updateTutor(@RequestBody TutorDTO tutorDTO, @PathVariable(name = "id") Long id){
//        return ResponseEntity.ok(servicoTutor.updateTutor(tutorDTO, id));
//    }
}
