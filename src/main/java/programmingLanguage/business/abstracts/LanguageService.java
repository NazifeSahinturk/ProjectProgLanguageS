package programmingLanguage.business.abstracts;

import programmingLanguage.business.request.CreateLanguageRequest;
import programmingLanguage.business.request.UpdateLanguageRequest;
import programmingLanguage.business.response.GetAllLanguagesResponse;
import programmingLanguage.business.response.GetByIdLanguageResponse;

import java.util.List;

public interface LanguageService {
    List<GetAllLanguagesResponse> getAll();
    GetByIdLanguageResponse getById(int id);
    void add(CreateLanguageRequest createLanguageRequest);
    void update(UpdateLanguageRequest updateLanguageRequest);
    void delete(int id);



}
