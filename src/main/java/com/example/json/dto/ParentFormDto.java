package com.example.json.dto;

import com.example.json.entity.ChildrenForm;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ParentFormDto {
    private String title;
    private String  description ;
    private List<ChildrenFormDto> childrenForms;
}
