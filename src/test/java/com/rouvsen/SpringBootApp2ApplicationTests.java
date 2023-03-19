package com.rouvsen;

import com.rouvsen.data.entity.EmployeeEntity;
import com.rouvsen.data.repository.EmployeeRepository;
import com.rouvsen.test.TestCRUD;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringBootApp2ApplicationTests { //implements TestCRUD

//    @Autowired
//    EmployeeRepository employeeRepository;
//
//    //CREATE
//    @Test
//    @Override
//    public void testCreate() {
//        EmployeeEntity employeeEntity = EmployeeEntity
//                .builder()
//                .firstName("Rovshan")
//                .lastName("Maharramov")
//                .emailId("rouvsen@gmail.com")
//                .build();
//        employeeRepository.save(employeeEntity);
//
//        //nesne null ise assertionError hatasi gondersin
//        assertNotNull(employeeRepository.findById(1L).get());
//    }
//
//    //LIST
//    @Test
//    @Override
//    public void testList() {
//        List<EmployeeEntity> list = employeeRepository.findAll();
//
//        //Eger Sifirdan buyukse liste vardir
//        assertThat(list).size().isGreaterThan(0);
//    }
//
//    //FINDBYID
//    @Test
//    @Override
//    public void testFindById() {
//        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();
//
//        //Rovshan adinda record var mi yok mu
//        assertEquals("r", employeeEntity.getFirstName());
//    }
//
//    //UPDATE
//    @Test
//    @Override
//    public void testUpdate() {
//        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();
//        employeeEntity.setFirstName("Rovshan 9");
//        employeeRepository.save(employeeEntity);
//
//        //beraber deyilse bir problem olmayacaq, amma beraberdirse Exception atacaq
//        assertNotEquals("Rovshan", employeeRepository.findById(1L).get().getFirstName());
//    }
//
//    //DELETE
//    @Test
//    @Override
//    public void testDelete() {
//        employeeRepository.deleteById(1L);
//
//        //isFalse
//        assertThat(employeeRepository.existsById(1L)).isFalse();
//    }
}
