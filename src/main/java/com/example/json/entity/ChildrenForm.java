package com.example.json.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString
@Transactional
@Entity
public class ChildrenForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String documentName;
    private String documentDescription;
    @ManyToOne
    @JoinColumn(name="parent_id")
    @JsonIgnore
    private ParentForm parentForm;
    @OneToMany( cascade = { CascadeType.ALL },orphanRemoval = true,fetch = FetchType.EAGER,mappedBy = "childrenForm")
    private List<Question> question;
}
