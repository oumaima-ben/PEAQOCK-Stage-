package com.example.json.service;

import com.example.json.dto.ParentFormDto;
import com.example.json.entity.ParentForm;

import java.util.List;

public interface FormService {
    public List<ParentFormDto> getAllInfos();
    public ParentFormDto getInfoById(Long id);
    public ParentFormDto createForm(ParentFormDto parentFormDto);
    public void  deleteForm(Long id);
    ParentFormDto updateForm(Long id, ParentFormDto parentFormDto);
}
