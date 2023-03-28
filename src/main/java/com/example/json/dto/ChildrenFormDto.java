package com.example.json.dto;
import com.example.json.entity.ParentForm;
import com.example.json.entity.Question;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ChildrenFormDto {
    private String documentName;
    private String documentDescription;

    //@JsonIgnore
    private ParentFormDto parentForm;
    private List<QuestionDto> question;

}
