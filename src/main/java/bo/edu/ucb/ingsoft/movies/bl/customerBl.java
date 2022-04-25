package bo.edu.ucb.ingsoft.movies.bl;

import bo.edu.ucb.ingsoft.movies.dto.addressDto;
import bo.edu.ucb.ingsoft.movies.dto.cityDto;
import bo.edu.ucb.ingsoft.movies.dto.customerDto;
import java.util.ArrayList;
import java.util.List;


public class customerBl
{
    public List<customerDto> findcustomerByChatId(Long chatId)
    {
        List<customerDto> result = new ArrayList<>();

        addressDto address = new addressDto(1,new cityDto(1),"Obrajes 456","Achumani 345");
        result.add(new customerDto(1,address,"Sergio","Prudencio",60667049,"sergio@gmail.com",true,"Sergex","superf"));

        result.add(new customerDto(2,address,"Fernando","Torrez",76463459,"fernando@gmail.com",true,"Fercho","asfafas"));

        result.add(new customerDto(3,address,"Ernesto","Villaroel",7466749,"ernesto@gmail.com",true,"Emc2","jtggssf"));

        result.add(new customerDto(4,address,"Rene","Gomez",60667049,"rene@gmail.com",true,"LocoGenio","dfgsasa"));

        result.add(new customerDto(5,address,"Waskar","Gomez",6056745,"waskar@gmail.com",true,"wask","tedhjd"));

        result.add(new customerDto(6,address,"Joel","Rojas",65556649,"joel@gmail.com",true,"rojitas","123"));

        /*
        result.add(new customerDto(2,1,2,"Alberto","Fernandez", 60507049,"albin@gmail.com",true,"Albin","123"));
        result.add(new customerDto(3,1,3,"Adriana","Vallejos", 62367049,"loquita@gmail.com",true,"Adri","456"));
        result.add(new customerDto(4,2,4,"Margo","Rodriguez", 70667049,"margoRo@gmail.com",true,"Margo","789"));
        result.add(new customerDto(5,2,5,"Pedro","Lopez", 78667049,"pedrod@gmail.com",true,"PedroF","000"));

         */
        return result;
    }
    public customerDto busquedaNombre(List<customerDto> lista, String nombre){
        customerDto result=new customerDto();
        for(customerDto customer: lista) {
            if(customer.getName().contentEquals(nombre)){
                return customer;
            }
        }
        return result;
    }

}
