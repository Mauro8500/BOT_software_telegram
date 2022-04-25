package bo.edu.ucb.ingsoft.movies.dto;

public class filmDto
{
  private Integer filId;
  private languageDto language;
  private String title;
  private String description;
  private Integer realeseYear;
  private Integer realeseDuration;
  private Double rentalAmount;
  private Integer duration;
  private Integer rating;

    //Contructor 1


    public filmDto(Integer filId, languageDto language, String title, String description, Integer realeseYear, Integer realeseDuration, Double rentalAmount, Integer duration, Integer rating)
    {
        this.filId = filId;
        this.language = language;
        this.title = title;
        this.description = description;
        this.realeseYear = realeseYear;
        this.realeseDuration = realeseDuration;
        this.rentalAmount = rentalAmount;
        this.duration = duration;
        this.rating = rating;
    }

    public filmDto()
    {
        this.filId = 0;
        this.title = "";
        this.description = "";
        this.realeseYear = 0;
        this.realeseDuration = 0;
        this.rentalAmount = 0.0;
        this.duration = 0;
        this.rating = 0;
    }
    //getters and Setters

    public Integer getFilId() {
        return filId;
    }

    public void setFilId(Integer filId) {
        this.filId = filId;
    }

    public languageDto getLanguage() {
        return language;
    }

    public void setLanguage(languageDto language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRealeseYear() {
        return realeseYear;
    }

    public void setRealeseYear(Integer realeseYear) {
        this.realeseYear = realeseYear;
    }

    public Integer getRealeseDuration() {
        return realeseDuration;
    }

    public void setRealeseDuration(Integer realeseDuration) {
        this.realeseDuration = realeseDuration;
    }

    public Double getRentalAmount() {
        return rentalAmount;
    }

    public void setRentalAmount(Double rentalAmount) {
        this.rentalAmount = rentalAmount;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    //Metodo toString para estructura las salidas
    @Override
    public String toString() {
        return " Pelicula" +
                "\n {" +
                "\n CodigoPelicula = " + filId +
                "\n --- Titulo= " + title +
                "\n Descripcion = " + description  + " --- Anio Estreno = " + realeseYear +
                "\n Periodo de Renta =" + realeseDuration + " --- Costo de Renta= " + rentalAmount +
                "\n Duracion = " + duration + " --- Puntuacion = " + rating+
                "\n } \n";
    }
}
