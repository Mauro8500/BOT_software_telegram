package bo.edu.ucb.ingsoft.movies.chat;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;

public class MenuCartelera extends AbstractProcess {

    public MenuCartelera() {
        this.setName("Menu Cartelera");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

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
                        case 1 : result = new QueryFilm();
                            break;
                        case 2 : result = new MenuBusquedaFlim();
                        break;
                        case 3 : result = new QueryCustomer();
                            break;
                        case 4 : result = new QueryCustomer();
                            break;
                        case 5 : result = new QueryCustomer();
                            break;
                        case 6 : result = new QueryCustomer();
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

        sb.append("CARTELERA INFORMACION  \r\n");
        sb.append("1. Ver todas las peliculas disponibles \r\n");
        sb.append("2. Buscar peliculas por Nombre\r\n");
        sb.append("3. Buscar peliculas por Genero\r\n");
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
