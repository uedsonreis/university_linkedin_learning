package com.example.university.dao;

import com.example.university.business.UniversityService;
import com.example.university.domain.Staff;
import com.example.university.repo.StaffRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test Paging and Sorting Query
 */
@SpringBootTest
class PagingTest {

    @Autowired
    private StaffRepo staffRepo;

    @Autowired
    private UniversityService universityService;

    @Test
    void findPage() {
        UniversityFactory.fillUniversity(universityService);
        List<Staff> allStaff = universityService.findAllStaff();
        Staff firstStaff = allStaff.get(0);

        Page<Staff> staffPage = this.staffRepo.findAll(PageRequest.of(0, 5, Sort.by("member.lastName")));
        final List<Staff> staffList = staffPage.getContent();

        assertTrue(staffList.get(0).getMember().getLastName().compareTo(staffList.get(1).getMember().getLastName()) < 0);
        assertTrue(staffList.get(1).getMember().getLastName().compareTo(staffList.get(2).getMember().getLastName()) < 0);
        assertTrue(staffList.get(2).getMember().getLastName().compareTo(staffList.get(3).getMember().getLastName()) < 0);
        assertTrue(staffList.get(3).getMember().getLastName().compareTo(staffList.get(4).getMember().getLastName()) < 0);
    }
}