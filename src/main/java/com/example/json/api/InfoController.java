package com.example.json.api;
import com.example.json.dao.InfoRepository;
import com.example.json.dto.ParentFormDto;
import com.example.json.entity.ParentForm;
import com.example.json.exception.ResourceNotFoundException;
import com.example.json.service.FormService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api")
public class InfoController {

    //i made a change
    @Autowired
    private    FormService formService;
    @Autowired
    private   Environment env;
    @Autowired
    private  InfoRepository inforepository;
    // pour tester load balancing
    @GetMapping("/testload")
    public String getInfos(){
        return env.getProperty("local.server.port");
    }
    @GetMapping("/get")
    public List<ParentFormDto> getAllInfos(){
        return
                formService.getAllInfos();
    }
    @PostMapping("/info")
    public ParentFormDto CreateInfo(@RequestBody ParentFormDto info) {

        return formService.createInfo(info);
    }
    @GetMapping("/get/{id}")
    public  ParentFormDto getInfoById(@PathVariable Long id) {

        return formService.getInfoById(id);
    }
    @DeleteMapping("/delete/{id}")
     public void deleteClient(@PathVariable Long id){

        formService.deleteInfo(id);
    }

   @PutMapping("/update/{id}")
    public ParentFormDto updateInfo(@PathVariable Long id, @RequestBody ParentFormDto infoDetails) {
        return formService.updateInfo(id,infoDetails);
    }

}
