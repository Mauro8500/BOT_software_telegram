package bo.edu.ucb.ingsoft.movies.chat;

import bo.edu.ucb.ingsoft.movies.bl.ShowActors;
import bo.edu.ucb.ingsoft.movies.chat.widgets.AbstractWidget;
import bo.edu.ucb.ingsoft.movies.chat.widgets.MenuWidgetImpl;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuS extends AbstractProcess {

    public MenuS() {
        this.setName("Menú principal");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    // Retornar un Widget de tipo menu
//    @Override
//    public AbstractWidget onInit() {
//        MenuWidgetImpl menuWidget = new MenuWidgetImpl(messages);
//        return menuWidget;
//    }


    @Override
    public AbstractProcess handle(Update update, MoviesLongPollingBot bot) {
        AbstractProcess result = this; // sigo en el mismo proceso.
        Long chatId = update.getMessage().getChatId();

        if (this.getStatus().equals("STARTED")) {

            showMainMenu(bot, chatId);
        } else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
            // Estamos esperando por un numero 1 o 2
            Message message = update.getMessage();
            if ( message.hasText() ) {
                // Intentamos transformar en número
                String text = message.getText(); // El texto contiene asdasdas
                try {
                    int opcion = Integer.parseInt(text);
                    switch (opcion){
                        case 1 : result = new ObtenerPeliculas4();
                        break;
                        case 2 : result = new QueryPastRequestsProcessImpl();
                        break;
                        case 3 : result = new PeliculasGenero();
                        break;
                        case 4 : result = new MenuProcessImpl();
                        break;
                        case 5 : result = new Slist();
                        break;
                        default: showMainMenu(bot, chatId);
                    }
                } catch (NumberFormatException ex) {
                    showMainMenu(bot, chatId);
                }
                // continuar con el proceso seleccionado
            } else { // Si me enviaron algo diferente de un texto.
                showMainMenu(bot, chatId);
            }
        }
        return result;
    }

    private void showMainMenu(MoviesLongPollingBot bot, Long chatId) {
        StringBuffer sb = new StringBuffer();
        sb.append("MENU PRINCIPAL - Movies\r\n");
        sb.append("1. Ver lista de peliculas disponibles\r\n");
        sb.append("2. Ver lista de actores\r\n");
        sb.append("3. Reservar pelicula segun el genero\r\n");
        sb.append("4. Reiniciar\r\n");
        sb.append("5. Mis peliculas\r\n");
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
