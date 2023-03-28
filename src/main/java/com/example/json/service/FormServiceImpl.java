package com.example.json.service;
import com.example.json.dao.InfoRepository;
import com.example.json.dto.ParentFormDto;
import com.example.json.entity.ParentForm;
import com.example.json.exception.ResourceNotFoundException;
import com.example.json.mapper.FormMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Transactional

public class FormServiceImpl implements FormService {
@Autowired
private  FormService formService;
    @Autowired
private  InfoRepository inforepository;
    @Autowired
private  FormMapper formMapper;

    @Override
    public List<ParentFormDto> getAllInfos() {
        List<ParentForm> parentForms = inforepository.findAll();
        return formMapper.parentToparentAllDtos(parentForms);
    }
    @Override
    public ParentFormDto getInfoById(Long id) {
        ParentForm entityinfo = inforepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("info not exist with id :" + id));
        return formMapper.parentToDto(entityinfo);
    }
    @Override
    public ParentFormDto createInfo(ParentFormDto parentFormDto) {
           ParentForm parentForm=inforepository.save(formMapper.dtoToParent(parentFormDto));
           //  return inforepository.save(parentFormDto);
            return formMapper.parentToDto(parentForm);
    }
    @Override
    public  String deleteInfo(Long id) {
        ParentForm parentForm = inforepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("info not exist with id :" + id));
        inforepository.delete(parentForm);
        return "deleted";
    }
    @Override
    public ParentFormDto updateInfo(Long id, ParentFormDto parentFormDto) {
        Optional<ParentForm> optionalForm = inforepository.findById(id);
        if (!optionalForm.isPresent()){
        }
        ParentForm existingForm = optionalForm.get();
        formMapper.INSTANCE.updateFromDto(parentFormDto, existingForm);
        existingForm = inforepository.save(existingForm);
        return formMapper.parentToDto(existingForm);
    }
}
