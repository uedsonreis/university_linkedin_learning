package com.example.university.repo;

import com.example.university.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CourseRepo extends JpaRepository<Course, Integer>, JpaSpecificationExecutor<Course> {

    public Optional<Course> findByName(String name);

    public List<Course> findByDepartmentChairMemberLastName(String lastName);

    @Query("Select c from Course c join c.prerequisites p where p.id = :idPrerequisite")
    public List<Course> findCourseByPrerequisite(int idPrerequisite);

    List<Course> findByCredits(int credits);

}
