package bo.edu.ucb.ingsoft.movies.dto;

public class cityDto
{
    private Integer cityId;
    private String city;
    //Contructor 1
    public cityDto(Integer cityId, String city) {
        this.cityId = cityId;
        this.city = city;
    }
    public cityDto(Integer cityId) {
        this.cityId = cityId;
        if(cityId == 1)
        {
            this.city= "La Paz";
        }
        if(cityId == 2)
        {
            this.city= "Cochabamba";
        }
        if(cityId == 3)
        {
            this.city= "Oruro";
        }
        if(cityId == 4)
        {
            this.city= "Sucre";
        }
        if(cityId == 5)
        {
            this.city= "Tarija";
        }
        if(cityId == 6)
        {
            this.city= "Potosi";
        }
        if(cityId == 7)
        {
            this.city= "Pando";
        }
        if(cityId == 8)
        {
            this.city= "Beni";
        }
        if(cityId == 9)
        {
            this.city= "Santa Cruz";
        }
    }
    //getters and setters

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //Constructor Vacio
    public cityDto() {
        this.cityId = 0;
        this.city = "Vacio";
    }
    //Metodo para mostrar el objeto cityDto
    @Override
    public String toString() {
        return "Ciudad " +
                "\n{" +
                "\n Numero= ' " + cityId +" ' " +
                "\n Ciudad= ' " + city+" ' " +
                "\n}\n";
    }
}

