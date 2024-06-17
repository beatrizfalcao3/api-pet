package com.beatriz.api_pet.service;


import com.beatriz.api_pet.exception.EntityNotFoundException;
import com.beatriz.api_pet.model.Tutor;
import com.beatriz.api_pet.model.dto.TutorDTO;
import com.beatriz.api_pet.repository.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoTutor {

    private final TutorRepository repository;

    public ServicoTutor(TutorRepository repository) {
        this.repository = repository;
    }

    public List<Tutor> getTutores(){
        return repository.findAll();
    }

    public Tutor getTutorById(Long id){
        Optional<Tutor> optionalTutor = repository.findById(id);

        if(optionalTutor.isEmpty()){
            throw new EntityNotFoundException("Tutor para o seguinte ID: " + id + " nao existe");
        }

        return optionalTutor.get();
    }

    public Tutor saveTutor(TutorDTO tutorDTO){

        Tutor tutor = new Tutor();
        tutor.setCpf(tutorDTO.getCpf());
        tutor.setNome(tutorDTO.getNome());
        tutor.setTelefone(tutorDTO.getTelefone());

        return repository.save(tutor);
    }

    public Tutor updateTutor(TutorDTO tutorDTO, Long idTutor){
        Tutor tutorToUpdate = getTutorById(idTutor);

        tutorToUpdate.setTelefone(tutorDTO.getTelefone());
        tutorToUpdate.setNome(tutorDTO.getNome());
        tutorToUpdate.setCpf(tutorDTO.getCpf());

        return repository.save(tutorToUpdate);
    }

    public void deleteTutor(Long id){

    }

}
