package programmingLanguage.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import programmingLanguage.business.abstracts.LanguageService;
import programmingLanguage.business.request.CreateLanguageRequest;
import programmingLanguage.business.request.UpdateLanguageRequest;
import programmingLanguage.business.response.GetAllLanguagesResponse;
import programmingLanguage.business.response.GetByIdLanguageResponse;
import programmingLanguage.core.utilities.mappers.ModelMapperService;
import programmingLanguage.dataAccess.abstracts.LanguageRepository;
import programmingLanguage.entities.Language;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService {

    private LanguageRepository languageRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllLanguagesResponse> getAll() {
        List<Language> languages = languageRepository.findAll();
        List<GetAllLanguagesResponse> languagesResponses = languages.stream()
                .map(language -> this.modelMapperService.forResponse()
                        .map(language, GetAllLanguagesResponse.class)).collect(Collectors.toList());
        return languagesResponses;

    }

    @Override
    public GetByIdLanguageResponse getById(int id) {
        Language language = this.languageRepository.findById(id).orElseThrow();
        GetByIdLanguageResponse response = this.modelMapperService.forResponse()
                .map(language, GetByIdLanguageResponse.class);
        return response;
    }

    @Override
    public void add(CreateLanguageRequest createLanguageRequest) {
        Language language = this.modelMapperService.forRequest()
                .map(createLanguageRequest,Language.class);
        this.languageRepository.save(language);

    }

    @Override
    public void update(UpdateLanguageRequest updateLanguageRequest) {
        Language language = this.modelMapperService.forRequest()
                .map(updateLanguageRequest,Language.class);
        this.languageRepository.save(language);

    }

    @Override
    public void delete(int id) {
        this.languageRepository.deleteById(id);

    }
}
