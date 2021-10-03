package com.academiccourseregistration.core.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

  /*  @ManyToMany
    private Set<Student> students;*/

   /* @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "proffesor_id")
    private Professor professor;*/
}