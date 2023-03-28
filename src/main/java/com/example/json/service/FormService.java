package com.example.json.service;

import com.example.json.dto.ParentFormDto;
import com.example.json.entity.ParentForm;

import java.util.List;

public interface FormService {
    public List<ParentFormDto> getAllInfos();
    public ParentFormDto getInfoById(Long id);
    public ParentFormDto createInfo(ParentFormDto parentFormDto);
    public String  deleteInfo(Long id);
    ParentFormDto updateInfo(Long id, ParentFormDto parentFormDto);
}
