package bo.edu.ucb.ingsoft.movies.bl;

import bo.edu.ucb.ingsoft.movies.dto.addressDto;
import bo.edu.ucb.ingsoft.movies.dto.cityDto;

import java.util.ArrayList;
import java.util.List;

public class addressBl
{
    public List<addressDto> findaddressByChatId(Long chatId) {
        List<addressDto> result = new ArrayList<>();
        cityDto city = new cityDto();
        result.add(new addressDto(1 ,city ,"Direccion 1","Direccion 2"));
        /*
        result.add(new addressDto(2,1,"Calle 7 de Achumani ","alternativa"));
        result.add(new addressDto(3,2,"Calle 9 de Heroias ","alternativa"));
        result.add(new addressDto(4,3,"Calle 12 de 14 de septiempre ","alternativa"));
        result.add(new addressDto(5,2,"Calle 5 de Ciudadela ","alternativa"));
        result.add(new addressDto(6,1,"Calle 2 de Obrajes ","alternativa"));

         */

        return result;
    }
}
