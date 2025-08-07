package com.springboot.mongoapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springboot.mongoapi.entity.Department;
import com.springboot.mongoapi.repository.DepartmentRepository;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @InjectMocks
    private DepartmentService departmentService;

    @Mock
    private DepartmentRepository departmentRepository;

    @Test
    void getDepartments_returnsDepartmentList() {
        Department dep1 = Department.builder().id("1").departmentName("Math").location("A").build();
        Department dep2 = Department.builder().id("2").departmentName("Physics").location("B").build();
        List<Department> expected = Arrays.asList(dep1, dep2);
        when(departmentRepository.findAll()).thenReturn(expected);

        List<Department> result = departmentService.getDepartments();

        assertEquals(expected, result);
        verify(departmentRepository, times(1)).findAll();
    }

    @Test
    void getDepartments_returnsEmptyListWhenNoDepartments() {
        when(departmentRepository.findAll()).thenReturn(Arrays.asList());

        List<Department> result = departmentService.getDepartments();

        assertEquals(Arrays.asList(), result);
        verify(departmentRepository, times(1)).findAll();
    }
}