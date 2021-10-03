package com.academiccourseregistration.core.web;

import com.academiccourseregistration.core.api.model.StudentDto;
import com.academiccourseregistration.core.service.CourseService;
import com.academiccourseregistration.core.service.ProfessorService;
import com.academiccourseregistration.core.service.StudentService;
import com.academiccourseregistration.core.web.controller.AcademicCourseRegistrationController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = AcademicCourseRegistrationController.class)
@MockBean({ProfessorService.class, CourseService.class})
public class AcademicCourseRegistrationControllerTest {

    @MockBean
    private StudentService studentService;
    @Autowired
    private WebTestClient webClient;

    @Test
    public void addStudentTest()
    {
        StudentDto student = new StudentDto();

        student.setId(1);
        student.setFirstName("FirstName");
        student.setLastName("LastName");

        Mockito.when(studentService.save(student)).thenReturn(Mono.just(student));

        webClient.post()
                .uri("/api/students")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(student))
                .exchange()
                .expectStatus().isCreated();

        Mockito.verify(studentService, times(1)).save(student);
    }
}