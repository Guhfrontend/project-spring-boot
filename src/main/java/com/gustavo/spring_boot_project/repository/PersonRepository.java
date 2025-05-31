package com.gustavo.spring_boot_project.repository;

import com.gustavo.spring_boot_project.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
