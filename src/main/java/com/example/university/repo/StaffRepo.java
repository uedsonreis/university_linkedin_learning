package com.example.university.repo;

import com.example.university.domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "staff", collectionResourceRel = "staff")
public interface StaffRepo extends JpaRepository<Staff, Integer> {

    public List<Staff> findByMemberLastName(String lastName);

}
