package bo.edu.ucb.ingsoft.movies.chat;

import bo.edu.ucb.ingsoft.movies.bl.filmBl;
import bo.edu.ucb.ingsoft.movies.dto.filmDto;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class QueryFilm extends AbstractProcess {

    public QueryFilm() {
        this.setName("Consultar lista de Peliculas");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        //this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }
    // Retornar un Widget con la información de los permisos solicitados
//    @Override
//    public AbstractWidget onInit() {
//        return null;
//    }

    @Override
    public AbstractProcess handle(Update update, MoviesLongPollingBot bot) {
        Long chatId = update.getMessage().getChatId();
        filmBl filmbl = new filmBl();
        List<filmDto> permissionList = filmbl.findfilmByChatId(chatId);
        StringBuffer sb = new StringBuffer();
        sb.append("Esta es la lista de PELICULAS:\r\n\r\n " ).append("\nEncontrados = "+permissionList.size()+"\n");
        sb.append("PRESIONA CUALQUIER TECLA PARA VOLVER\r\n\r\n " );
        for(filmDto permission: permissionList) {
            sb.append(permission.toString()).append("\n\r");
        }
        sendStringBuffer(bot, chatId, sb);
        return new MenuProcessImpl();
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