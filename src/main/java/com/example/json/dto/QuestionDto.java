package com.example.json.dto;

import com.example.json.entity.ChildrenForm;
import com.example.json.entity.Extras;
import com.example.json.entity.Option;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class QuestionDto {

   // private ChildrenFormDto childrenForm;

    private String questionText;
    private String questionType;
    private Boolean required;
    private List<OptionDto> options;
    //private ChildrenFormDto childrenForm;
    private List<ExtrasDto> extras;
}
