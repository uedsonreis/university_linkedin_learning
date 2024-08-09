package com.example.university.repo;

import com.example.university.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Integer> {

    public List<Student> findByAttendeeFirstNameAndAttendeeLastName(String firstName, String lastName);

    public List<Student> findByAgeLessThan(Integer age);

    public List<Student> findByFullTime(boolean fullTime);

    public List<Student> findByAge(Integer age);

    public List<Student> findByAttendeeLastName(String lastName);

    public List<Student> findByAttendeeLastNameLike(String lastName);

    public List<Student> findTop3ByOrderByAgeDesc();

    public Optional<Student> findFirstByOrderByAttendeeLastNameAsc();

    public Optional<Student> findFirstByOrderByAgeDesc();

}
