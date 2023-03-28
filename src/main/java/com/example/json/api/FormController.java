package com.example.json.api;
import com.example.json.dto.payload.ParentFormDto;
import com.example.json.service.FormService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/kyc")
public class FormController {

    private  final  FormService formService;
    private  final Environment env;
    @GetMapping("/server-port")
    public String getInfos(){
        return env.getProperty("local.server.port");
    }
    @GetMapping("/getAllForms")
    public List<ParentFormDto> getAllInfos(){
        return formService.getAllInfos();
    }
    @PostMapping("/createForm")
    public ParentFormDto CreateInfo(@RequestBody ParentFormDto info) {
        return formService.createForm(info);
    }
    @GetMapping("/getFormById/{id}")
    public  ParentFormDto getInfoById(@PathVariable Long id) {

        return formService.getInfoById(id);
    }
    @DeleteMapping("/deleteForm/{id}")
     public void deleteClient(@PathVariable Long id){
        formService.deleteForm(id);
    }

   @PutMapping("/updateForm/{id}")
    public ParentFormDto updateInfo(@PathVariable Long id, @RequestBody ParentFormDto infoDetails) {
        return formService.updateForm(id,infoDetails);
    }

}
