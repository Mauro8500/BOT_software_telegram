package bo.edu.ucb.ingsoft.movies.bl;

import bo.edu.ucb.ingsoft.movies.dto.cityDto;
import bo.edu.ucb.ingsoft.movies.dto.customerDto;
import bo.edu.ucb.ingsoft.movies.dto.filmDto;
import bo.edu.ucb.ingsoft.movies.dto.languageDto;

import java.util.ArrayList;
import java.util.List;

public class filmBl
{
    public List<filmDto> findfilmByChatId(Long chatId)
    {
        List<filmDto> result = new ArrayList<>();
        languageDto language = new languageDto(1);

        result.add(new filmDto(1,language,"Vengadores","Se juntan los superheroes mas poderosos de marvel",2022,0,50.0,60,5));
        result.add(new filmDto(2,language,"Batman","Nueva version con robert pattinson",2022,0,50.0,60,5));
        result.add(new filmDto(3, language,"Spiderman No way home","La historia de uno de los vengadores",2022,0,50.0,60,5));
        result.add(new filmDto(4,language ,"Locos de ira","Habla sobre como un paciente lleva el control de la ira",2020,0,50.0,60,5));
        result.add(new filmDto(5, language,"Todo poderoso","Pelicula de comedia interpretada por jim carrey",2015,0,50.0,60,5));
        result.add(new filmDto(6, language,"ACE VENTURA","Pelicula de comedia con la participacion de Jim Carrey",2014,0,50.0,60,5));
        result.add(new filmDto(7, language,"Soy leyenda","Nominada a la peor pelicula",2014,0,50.0,60,5));
        result.add(new filmDto(8, language,"The Avengers","Pelicula de Marvel",2019,0,50.0,60,5));
        result.add(new filmDto(9,language,"The Avengers","Pelicula de Marvel",2019,0,50.0,60,5));
        return result;
    }

    public filmDto busquedaNombre(List<filmDto> lista, String title){
        filmDto result=new filmDto();
        for(filmDto film: lista) {
            if(film.getTitle().contentEquals(title))
            {
                return film;
            }
        }
        return result;
    }


}
