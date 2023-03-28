
package com.example.json.entity;
//import com.example.json.entity.Option;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

//@JsonInclude(JsonInclude.Include.NON_NULL)
/*@JsonPropertyOrder({
        "id",
        "options",
        "questionText",
        "questionType",
        "required"
})*/
@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString

@Entity

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String questionText;
    private String questionType;
    private Boolean required;
    @ManyToOne
    @JoinColumn(name="children_id")
    @JsonIgnore
    private ChildrenForm childrenForm;
    @OneToMany( cascade = { CascadeType.ALL },orphanRemoval = true,fetch = FetchType.EAGER, mappedBy = "question")

    private List<Option> options;
    @OneToMany( cascade = { CascadeType.ALL },orphanRemoval = true ,fetch = FetchType.EAGER, mappedBy = "question")

    private List<Extras> extras;
}


