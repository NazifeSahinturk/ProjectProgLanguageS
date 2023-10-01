package programmingLanguage.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import programmingLanguage.entities.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
