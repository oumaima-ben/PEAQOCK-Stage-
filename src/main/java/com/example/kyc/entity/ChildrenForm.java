package com.example.kyc.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentDescription() {
        return documentDescription;
    }

    public void setDocumentDescription(String documentDescription) {
        this.documentDescription = documentDescription;
    }

    public ParentForm getParentForm() {
        return parentForm;
    }

    public void setParentForm(ParentForm parentForm) {
        this.parentForm = parentForm;
    }

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }
}
