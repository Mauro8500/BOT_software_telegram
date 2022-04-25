package bo.edu.ucb.ingsoft.movies.bl;


import bo.edu.ucb.ingsoft.movies.dto.cityDto;

import java.util.ArrayList;
import java.util.List;

public class cityBl
{
    public List<cityDto> findcityByChatId(Long chatId) {
        List<cityDto> result = new ArrayList<>();
        result.add(new cityDto(1, "La Paz"));
        result.add(new cityDto(2, "Cochabamba"));
        result.add(new cityDto(3, "Beni"));
        result.add(new cityDto(4, "Santa Cruz"));
        result.add(new cityDto(5, "Pando"));
        result.add(new cityDto(6, "Potosi"));
        result.add(new cityDto(7, "Sucre"));
        result.add(new cityDto(8, "Oruro"));
        result.add(new cityDto(9, "Tarija"));
        result.add(new cityDto(10, "El Alto"));
        return result;
    }
    public cityDto busquedaNombre(List<cityDto> lista, String nombre){
        cityDto result=new cityDto();
        for(cityDto pets: lista) {
            if(pets.getCity().contentEquals(nombre)){
                return pets;
            }
        }
        return result;
    }
}
