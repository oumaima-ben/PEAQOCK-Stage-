package com.example.json.dto.payload;

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
    //private QuestionDto question;
    private String optionText;
}
