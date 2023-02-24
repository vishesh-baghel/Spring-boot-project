package com.example.springboot.tutorial.controller;

import com.example.springboot.tutorial.entity.Department;
import com.example.springboot.tutorial.error.DepartmentNotFoundException;
import com.example.springboot.tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.RequestEntity.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;



    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Pune")
                .departmentCode("IT-01")
                .departmentId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentName("IT")
                .departmentAddress("Pune")
                .departmentCode("IT-01")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

//        mockMvc.perform((RequestBuilder) post("/departments"))
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\n" +
//                        "    \"departmentName\": \"IT\",\n" +
//                        "    \"departmentAddress\": \"Pune\",\n" +
//                        "    \"departmentCode\": \"IT-01\"\n" +
//                        "}")
//                .andExpect(MockMvcResultMatchers.status().isOk()); 3.59
    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L)).thenReturn(department);

//        mockMvc.perform((RequestBuilder) get("/departments/1"))
//                .contentType(MediaType.APPLICATION_JSON)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value(department.getDepartmentName()));
    }
}















