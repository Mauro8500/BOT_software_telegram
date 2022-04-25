package bo.edu.ucb.ingsoft.movies.dto;

import java.util.List;

public class customerDto
{


    private Integer customerId;
    private addressDto address;
    private String name;
    private String lastname;
    private Integer phone;
    private String mail;
    private Boolean status;
    private String usarname;
    private String password;

    //Contructores

    public customerDto(Integer customerId, addressDto address, String name, String lastname, Integer phone, String mail, Boolean status, String usarname, String password) {
        this.customerId = customerId;
        this.address = address;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.mail = mail;
        this.status = status;
        this.usarname = usarname;
        this.password = password;
    }

    public customerDto()
    {
        this.customerId = 0;

        this.name = "";
        this.lastname = "";
        this.phone = 0;
        this.mail = "";
        this.status = true;
        this.usarname = "";
        this.password = "";
    }


    //Getters and Setters

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public addressDto getAddress() {
        return address;
    }

    public void setAddress(addressDto address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getUsarname() {
        return usarname;
    }

    public void setUsarname(String usarname) {
        this.usarname = usarname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //Metodo para mostrar lo objetos de tipo Customer

    @Override
    public String toString()
    {
        return "Cliente " +
                "\n{"+
                "\n Codigo =" + customerId +
                "\n---------------------------" +
                "\n Direccion = " + address.toString() +
                "\n---------------------------"+
                "\n Nombre ='" + name + '\'' +
                "\n Apellido ='" + lastname + '\'' +
                "\n NumeroCelular =" + phone +
                "\n Correo ='" + mail + '\'' +
                "\n status =" + status +
                "\n Usuario ='" + usarname + '\'' +
                "\n Contrasenia ='" + password + '\'' +
                "\n}\n";
    }



    /*
    @Override
    public String toString() {
        return "Datos Cliente" +
                "\n {" +
                "\n Nombre = " +name+ " Apellido = " +lastname+
                "\n Telefono= " + phone +
                "\n CorreoElectronico = " +mail+
                "\n status= " + status + ", usarname = " + usarname+
                "\n password= " + password + "\n}\n";
    }
    */

}
