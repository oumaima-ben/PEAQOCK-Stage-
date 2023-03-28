package com.example.json.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString

@Entity
public class Extras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_extras;
    @ManyToOne
    @JoinColumn(name="question_id")
    @JsonIgnore
    private Question question;
    private String optionText;
}
