package com.example.json.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ChildrenForm> getChildrenForms() {
        return childrenForms;
    }

    public void setChildrenForms(List<ChildrenForm> childrenForms) {
        this.childrenForms = childrenForms;
    }
}
