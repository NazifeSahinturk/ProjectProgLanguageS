package programmingLanguage.webApi;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import programmingLanguage.business.abstracts.LanguageService;
import programmingLanguage.business.request.CreateLanguageRequest;
import programmingLanguage.business.request.UpdateLanguageRequest;
import programmingLanguage.business.response.GetAllLanguagesResponse;
import programmingLanguage.business.response.GetByIdLanguageResponse;
import programmingLanguage.entities.Language;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/languages")
public class languageControllers {
    private LanguageService languageService;

    @GetMapping
    public List<GetAllLanguagesResponse> getAll(){
        return languageService.getAll();
    }
    @GetMapping
public GetByIdLanguageResponse getByIdLanguageResponse(@PathVariable int id){
        return  languageService.getById(id);
}

@PostMapping
@ResponseStatus(code = HttpStatus.CREATED)
public void add(@RequestBody CreateLanguageRequest createLanguageRequest){
        this.languageService.add(createLanguageRequest);
}
@PutMapping
public void update(@RequestBody UpdateLanguageRequest updateLanguageRequest){
        this.languageService.update(updateLanguageRequest);
}
@DeleteMapping("/{id}")
public void delete(@PathVariable int id){
        this.languageService.delete(id);
}
}
