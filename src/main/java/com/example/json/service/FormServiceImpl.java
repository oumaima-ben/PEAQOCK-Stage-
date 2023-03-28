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
         //  ParentForm parentForm=inforepository.save(formMapper.dtoToParent(parentFormDto));
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
       /* Optional<ParentForm> optionalForm = inforepository.findById(id);
        if (!optionalForm.isPresent()){
        }
        ParentForm existingForm = optionalForm.get();
        formMapper.INSTANCE.updateFromDto(parentFormDto, existingForm);
        existingForm = inforepository.save(existingForm);
        return formMapper.parentToDto(existingForm);*/

        //ParentForm existingForm = inforepository.findById(id)

        return formMapper.parentToDto(
                inforepository.findById(id)
                                .map(existingForm -> inforepository.save(formMapper.updateFromDto(parentFormDto,existingForm)))
                                .orElseThrow(()->new ResourceNotFoundException("This object doesn't exist!"))
        );
    }
}
