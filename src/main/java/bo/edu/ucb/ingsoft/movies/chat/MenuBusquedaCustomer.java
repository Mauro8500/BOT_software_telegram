package bo.edu.ucb.ingsoft.movies.chat;

import bo.edu.ucb.ingsoft.movies.bl.customerBl;
import bo.edu.ucb.ingsoft.movies.dto.customerDto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.List;

public class MenuBusquedaCustomer extends AbstractProcess {

    public MenuBusquedaCustomer() {
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
                    customerBl customerbl = new customerBl();
                    List<customerDto> customerdto = customerbl.findcustomerByChatId(chatId);
                    StringBuffer sb = new StringBuffer();
                    sb.append(customerbl.busquedaNombre(customerdto,text).toString());

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
        sb.append("Ingrese el nombre del Cliente \n\r");
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
