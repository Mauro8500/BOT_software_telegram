package bo.edu.ucb.ingsoft.movies.chat;

import bo.edu.ucb.ingsoft.movies.bl.ShowMovies1;
import bo.edu.ucb.ingsoft.movies.dto.MovieList;
import org.telegram.telegrambots.meta.api.objects.Update;
import java.util.List;

public class ObtenerPeliculas1 extends AbstractProcess {
    public ObtenerPeliculas1() {
        this.setName("Consultar lista de actores");
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
        ShowMovies1 showActors = new ShowMovies1();
        List<MovieList> permissionList = showActors.findmovies(chatId);
        StringBuffer sb = new StringBuffer();
        sb.append("Esta es la lista pelicuals disponible:\r\n\r\n " ).append(permissionList.size());
        sb.append("PRESIONA CUALQUIER TECLA PARA VOLVER ATRAS\r\n\r\n " );
        for(MovieList permission: permissionList) {
            sb.append(permission.toString()).append("\n\r");
        }
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