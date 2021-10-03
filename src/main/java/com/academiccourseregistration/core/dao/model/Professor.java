package com.academiccourseregistration.core.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()
@Table(name = "professors")
public class Professor {

    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private int courseId;
}