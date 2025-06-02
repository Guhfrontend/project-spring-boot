package com.gustavo.spring_boot_project.controller;

import com.gustavo.spring_boot_project.DTO.v1.PersonDTO;
import com.gustavo.spring_boot_project.DTO.v2.PersonDTOV2;
import com.gustavo.spring_boot_project.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<PersonDTO> findAll(){
        return personService.findAll();
    }

    @GetMapping(value ="/{id}")
    public PersonDTO findById(@PathVariable("id") Long id){
        return  personService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO create(@RequestBody PersonDTO person){
        return personService.create(person);
    }

    @PutMapping(value = "/{id}")
    public PersonDTO update(@PathVariable String id, @RequestBody PersonDTO person){
        return personService.update(person);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id){
        personService.delete(id);
    }

    @PostMapping(value = "/v2", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTOV2 create(@RequestBody PersonDTOV2 person){
        return personService.createV2(person);
    }
}


