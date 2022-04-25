package bo.edu.ucb.ingsoft.movies.chat;

import bo.edu.ucb.ingsoft.movies.bl.customerBl;
import bo.edu.ucb.ingsoft.movies.bl.filmBl;
import bo.edu.ucb.ingsoft.movies.dto.customerDto;
import bo.edu.ucb.ingsoft.movies.dto.filmDto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.List;

public class MenuBusquedaFlim extends AbstractProcess {

    public MenuBusquedaFlim() {
        this.setName("BUSQUEDA POR NOMBRE");
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
                try
                {
                    filmBl filmbl = new filmBl();
                    List<filmDto> customerdto = filmbl.findfilmByChatId(chatId);
                    StringBuffer sb = new StringBuffer();
                    sb.append(filmbl.busquedaNombre(customerdto,text).toString());

                    sendStringBuffer(bot, chatId, sb);
                    result = new MenuProcessImpl();


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
        sb.append("Ingrese el nombre de la Pelicula \n\r");
        sendStringBuffer(bot,chatId,sb);


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
