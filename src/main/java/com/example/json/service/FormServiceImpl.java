package com.example.json.service;
import com.example.json.dao.InfoRepository;
import com.example.json.dto.payload.ParentFormDto;
import com.example.json.entity.ParentForm;
import com.example.json.exception.ResourceNotFoundException;
import com.example.json.mapper.FormMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FormServiceImpl implements FormService {

    private final InfoRepository inforepository;

    private final FormMapper formMapper;

    @Override
    public List<ParentFormDto> getAllInfos() {
        return formMapper.parentToparentAllDtos(inforepository.findAll());
    }
    @Override
    public ParentFormDto getInfoById(Long id) {
        return inforepository.findById(id)
                .map(parentForm -> formMapper.parentToDto(parentForm))
                .orElseThrow(() -> new ResourceNotFoundException("info not exist with id :" + id));
    }
    @Override
    public ParentFormDto createForm(ParentFormDto parentFormDto) {
        return formMapper.parentToDto(inforepository.save(formMapper.dtoToParent(parentFormDto)));
    }
    @Override
    public  void deleteForm(Long id) {
        ParentForm parentForm = inforepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("This object with the given id: "+ id+" does not exist"));
        inforepository.delete(parentForm);
    }
    @Override
    public ParentFormDto updateForm(Long id, ParentFormDto parentFormDto) {
        return formMapper.parentToDto(
                inforepository.findById(id)
                                .map(existingForm -> inforepository.save(formMapper.updateFromDto(parentFormDto,existingForm)))
                                .orElseThrow(()->new ResourceNotFoundException("This object doesn't exist!"))
        );
    }
}
