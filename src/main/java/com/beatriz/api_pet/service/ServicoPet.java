package com.beatriz.api_pet.service;

import com.beatriz.api_pet.exception.EntityNotFoundException;
import com.beatriz.api_pet.model.Pet;
import com.beatriz.api_pet.model.Tutor;
import com.beatriz.api_pet.model.dto.PetDto;
import com.beatriz.api_pet.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoPet {

    private final PetRepository repository;

    private final ServicoTutor servicoTutor;

    public ServicoPet(PetRepository repository, ServicoTutor servicoTutor) {
        this.repository = repository;
        this.servicoTutor = servicoTutor;
    }

    public List<Pet> getPets(){
        return repository.findAll();
    }

    public Pet savePet(PetDto petDto){
        Tutor tutor = servicoTutor.getTutorById(petDto.getTutorId());

        Pet pet = new Pet();
        pet.setNome(petDto.getNome());
        pet.setCor(petDto.getCor());
        pet.setIdade(petDto.getIdade());
        pet.setRaca(petDto.getRaca());
        pet.setTutor(tutor);

        return repository.save(pet);
    }

    public Pet updatePet(PetDto petDto, Long id){
        Pet petToUpdate = getPetsById(id);

        petToUpdate.setNome(petDto.getNome());
        petToUpdate.setRaca(petDto.getRaca());
        petToUpdate.setIdade(petDto.getIdade());
        petToUpdate.setCor(petToUpdate.getCor());

        return repository.save(petToUpdate);
    }


    public List<Pet> getPetsByTutorId(Long tutorId){
        return repository.findByTutorId(tutorId);
    }

    public Pet getPetsById(Long petId){
        Optional<Pet> optionalPet = repository.findById(petId);

        if(optionalPet.isEmpty()){
            throw new EntityNotFoundException("Nao existe pet com este id");
        }

        return optionalPet.get();
    }
    public void deletePet(Long id) {
        Pet pet = getPetsById(id);
        repository.delete(pet);
    }
}
