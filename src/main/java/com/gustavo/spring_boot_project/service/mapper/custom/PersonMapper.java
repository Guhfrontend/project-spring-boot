package com.gustavo.spring_boot_project.service.mapper.custom;

import com.gustavo.spring_boot_project.DTO.v2.PersonDTOV2;
import com.gustavo.spring_boot_project.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonDTOV2 convertEntityToDTO(Person person){
        PersonDTOV2 entity = new PersonDTOV2();
        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setBirthDate(new Date());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return entity;
    }

    public Person convertDtoToEntity(PersonDTOV2 person){
        Person entity = new Person();
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        //entity.setBirthDate(new Date());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return entity;
    }
}
