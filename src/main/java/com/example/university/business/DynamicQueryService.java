package com.example.university.business;

import com.example.university.domain.Course;
import com.example.university.repo.CourseQueryDslRepo;
import com.example.university.repo.CourseRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DynamicQueryService {

    private final CourseRepo courseRepo;
    private final CourseQueryDslRepo courseQueryDslRepo;

    public DynamicQueryService(CourseRepo courseRepo, CourseQueryDslRepo courseQueryDslRepo) {
        this.courseRepo = courseRepo;
        this.courseQueryDslRepo = courseQueryDslRepo;
    }

    public List<Course> filterBySpecification(CourseFilter filter) {
        return this.courseRepo.findAll(filter.getSpecification());
    }

    public List<Course> filterByQueryDsl(CourseFilter filter) {
        final List<Course> courses = new ArrayList<>();
        this.courseQueryDslRepo.findAll(filter.getQueryDslPredicate()).forEach(courses::add);
        return courses;
    }

    public List<Course> filterBy(CourseFilter filter) {
        return this.courseRepo.findAll(filter.getExampleProbe());
    }

}
