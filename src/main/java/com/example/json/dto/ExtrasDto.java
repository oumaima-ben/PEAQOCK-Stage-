package com.example.json.dto;

import com.example.json.entity.Question;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ExtrasDto {
    private Long id_extras;
    //private QuestionDto question;
    private String optionText;
}
