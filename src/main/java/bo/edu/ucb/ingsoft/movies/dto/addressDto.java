package bo.edu.ucb.ingsoft.movies.dto;

public class addressDto
{
    private Integer addressId;
    private cityDto city;
    private String firtsAddress;
    private String secondAddress;

    //Constructor

    public addressDto(Integer addressId, cityDto city, String firtsAddress, String secondAddress)
    {
        this.addressId = addressId;
        this.city = city;
        this.firtsAddress = firtsAddress;
        this.secondAddress = secondAddress;
    }
    public addressDto()
    {
        this.addressId = 0;
        this.city = city;
        this.firtsAddress = "";
        this.secondAddress = "secondAddress";
    }

    //getters and setters


    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public cityDto getCity() {
        return city;
    }

    public void setCity(cityDto city) {
        this.city = city;
    }

    public String getFirtsAddress() {
        return firtsAddress;
    }

    public void setFirtsAddress(String firtsAddress) {
        this.firtsAddress = firtsAddress;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public void setSecondAddress(String secondAddress) {
        this.secondAddress = secondAddress;
    }

    @Override
    public String toString() {
        return "Direccion " +
                "\n{" +
                "\n Ciudad = '" + city + " ' "+
                "\n PrimeraDireccion = '" + firtsAddress + " ' " +
                "\n SegundaDireccion = '" + secondAddress + " ' " +
                "\n}\n";
    }

    //metodo para Mostrar los objetos de tipo Adress
    /*

    @Override
    public String toString() {
        return "addressDto{" + "addressId=" + addressId + ", firtsAddress='" + firtsAddress + '\''
                + ", secondAddress='" + secondAddress + '\'' + '}';
    }
    */
}
