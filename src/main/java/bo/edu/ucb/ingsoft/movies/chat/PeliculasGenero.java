package bo.edu.ucb.ingsoft.movies.chat;

import bo.edu.ucb.ingsoft.movies.chat.widgets.AbstractWidget;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class PeliculasGenero extends AbstractProcess {

    public PeliculasGenero() {
        this.setName("Genero de peliculas");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        //this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }


    // Retornar un Widget Solicitando Fecha Inicio
//    @Override
//    public AbstractWidget onInit() {
//        return null;
//    }

    @Override
    public AbstractProcess handle(Update update, MoviesLongPollingBot bot) {
        AbstractProcess result = this; // sigo en el mismo proceso.
        Long chatId = update.getMessage().getChatId();
        //StringBuffer sb = new StringBuffer();
        if (this.getStatus().equals("STARTED")) {

            PeliculasG(bot, chatId);
        } else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
            // Estamos esperando por un numero 1 o 2
            Message message = update.getMessage();
            if ( message.hasText() ) {
                // Intentamos transformar en número
                String text = message.getText(); // El texto contiene asdasdas
                try {
                    int opcion = Integer.parseInt(text);
                    switch (opcion){
                        case 1 : result = new Accion();
                        break;
                        case 2 : result = new Ficcion();
                        break;
                        case 5 : result = new MenuProcessImpl();
                        break;
                        default: PeliculasG(bot, chatId);
                    }
                } catch (NumberFormatException ex) {
                    PeliculasG(bot, chatId);
                }
                // continuar con el proceso seleccionado
            } else { // Si me enviaron algo diferente de un texto.
                PeliculasG(bot, chatId);
            }
        }
        return result;
    }


    private void PeliculasG(MoviesLongPollingBot bot, Long chatId) {
        StringBuffer sb = new StringBuffer();
        sb.append("Genero de peliculas - Movies\r\n");
        sb.append("1. Accion\r\n");
        sb.append("2. Ficcion\r\n");
        sb.append("5. Volver\r\n");
        sb.append("Elija una opción:\r\n");
        sendStringBuffer(bot, chatId, sb);

        String nombre = "Juan";
        String apellido = "Perez";
        String nombreCompleto = nombre + " " + apellido;
        this.setStatus("AWAITING_USER_RESPONSE");
    }

    @Override
    public AbstractProcess onError() {
        return null;
    }

    @Override
    public AbstractProcess onSuccess() {
        return null;
    }

    @Override
    public AbstractProcess onTimeout() {
        return null;
    }
}