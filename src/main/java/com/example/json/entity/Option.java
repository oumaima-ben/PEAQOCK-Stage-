
package com.example.json.entity;
import com.fasterxml.jackson.annotation.*;
import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @ManyToOne
     @JoinColumn(name="question_id")
     @JsonIgnore
     private Question question;
    private String optionText;
}


