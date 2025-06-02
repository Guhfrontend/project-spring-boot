package com.gustavo.spring_boot_project.service;

import com.gustavo.spring_boot_project.DTO.v1.PersonDTO;
import com.gustavo.spring_boot_project.DTO.v2.PersonDTOV2;
import com.gustavo.spring_boot_project.exception.ResourceNotFoundException;
import com.gustavo.spring_boot_project.model.Person;
import com.gustavo.spring_boot_project.service.mapper.ObjectMapper;
import com.gustavo.spring_boot_project.service.mapper.custom.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gustavo.spring_boot_project.repository.PersonRepository;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonMapper personMapper;

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<PersonDTO> findAll(){
        logger.info("Finding all Person");
        return ObjectMapper.parseListObjects(personRepository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id){
        logger.info("Finding one Person");
        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Recordes found for this ID"));
        return ObjectMapper.parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person){
        logger.info("Creating one Person");
        return ObjectMapper.parseObject(personRepository.save(ObjectMapper.parseObject(person, Person.class)), PersonDTO.class);
    }

    public PersonDTOV2 createV2(PersonDTOV2 person){
        logger.info("Creating one Person V2!!!!");
        var entity = personMapper.convertDtoToEntity(person);
        return personMapper.convertEntityToDTO(personRepository.save(entity));
    }

    public PersonDTO update(PersonDTO person){
        logger.info("Update one Person");
        Person entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No Recordes found for this ID"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return ObjectMapper.parseObject(personRepository.save(entity), PersonDTO.class);
    }

    public void delete(Long id){
        logger.info("Delete one Person");
        Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Recordes found for this ID"));
        personRepository.delete(entity);
    }
}