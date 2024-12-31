package com.example.sourcebase.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Table(name = "department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;



    @Column(nullable = false)
    boolean deleted = false;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    Set<DepartmentCriterias> departmentCriterias;

    @OneToMany(mappedBy = "department")
    Set<Project> projects;
}
