package com.example.json.dto.payload;

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
 //   private ChildrenFormDto childrenForm;
    private List<ExtrasDto> extras;
}
