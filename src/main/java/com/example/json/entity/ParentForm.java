package com.example.json.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ParentForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String  description ;
    @OneToMany( cascade = { CascadeType.ALL },orphanRemoval = true,fetch = FetchType.EAGER,mappedBy = "parentForm")
    private List<ChildrenForm> childrenForms;

}
