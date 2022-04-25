package bo.edu.ucb.ingsoft.movies.bl;

import bo.edu.ucb.ingsoft.movies.dto.cityDto;
import bo.edu.ucb.ingsoft.movies.dto.languageDto;

import java.util.ArrayList;
import java.util.List;

public class languageBl
{
    public List<languageDto> findlanguageByChatId(Long chatId) {
        List<languageDto> result = new ArrayList<>();
        result.add(new languageDto(1, "Espanol"));
        result.add(new languageDto(2, "Espanol Latino"));
        result.add(new languageDto(3, "Ingles"));
        result.add(new languageDto(4, "Ruso"));
        result.add(new languageDto(5, "Chino Mandarin"));
        return result;
    }
}
