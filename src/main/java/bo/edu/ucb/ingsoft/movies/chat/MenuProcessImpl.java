package bo.edu.ucb.ingsoft.movies.chat;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;

public class MenuProcessImpl extends AbstractProcess {

    public MenuProcessImpl() {
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
                        case 1 : result = new ObtenerPeliculas();
                        break;
                        case 2 : result = new QueryPastRequestsProcessImpl();
                        break;
                        case 3 : result = new PeliculasGenero();
                        break;
                        case 5 : result = new QueryCity();
                        break;
                        case 6 : result = new MenuCartelera();
                        break;
                        case 7 : result = new MenuAdministracionCliente();
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
        sb.append("1. Mirar de lista peliculas\r\n");
        sb.append("2. Ver lista de actores\r\n");
        sb.append("3. Buscar pelicula por genero\r\n");
        sb.append("5. Ver Sucursales \r\n");
        sb.append("6. Menu Cartelera \r\n");
        sb.append("7. Menu Administracion de Clientes \r\n");
        sb.append("Elija una opción:\r\n");
        sendStringBuffer(bot, chatId, sb);

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
