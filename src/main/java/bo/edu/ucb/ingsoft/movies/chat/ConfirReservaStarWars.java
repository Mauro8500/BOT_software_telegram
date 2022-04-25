package bo.edu.ucb.ingsoft.movies.chat;

import bo.edu.ucb.ingsoft.movies.bl.ShowActors;
import bo.edu.ucb.ingsoft.movies.dto.ActorsList;
import org.telegram.telegrambots.meta.api.objects.Update;
import java.util.List;

public class ConfirReservaStarWars extends AbstractProcess {

    public ConfirReservaStarWars() {
        this.setName("Reserva exitosa");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        //this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    @Override
    public AbstractProcess handle(Update update, MoviesLongPollingBot bot) {
        Long chatId = update.getMessage().getChatId();
        StringBuffer sb = new StringBuffer();
        sb.append("Reserva Exitosa!\r\n\r\n " );
        sb.append("PRESIONA CUALQUIER TECLA PARA VOLVER AL MENU\r\n\r\n " );
        sendStringBuffer(bot, chatId, sb);
        return new MenuSW();
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
