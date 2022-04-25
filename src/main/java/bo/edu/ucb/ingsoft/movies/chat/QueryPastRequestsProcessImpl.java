package bo.edu.ucb.ingsoft.movies.chat;

import bo.edu.ucb.ingsoft.movies.bl.ShowActors;

import bo.edu.ucb.ingsoft.movies.dto.ActorsList;
import org.telegram.telegrambots.meta.api.objects.Update;
import java.util.List;

public class QueryPastRequestsProcessImpl extends AbstractProcess {

    public QueryPastRequestsProcessImpl() {
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
        ShowActors showActors = new ShowActors();
        List<ActorsList> permissionList = showActors.findLast10PermissionsByChatId(chatId);
        StringBuffer sb = new StringBuffer();
        sb.append("Esta es la lista de actores:\r\n\r\n " ).append(permissionList.size());
        sb.append("PRESIONA CUALQUIER TECLA PARA VOLVER\r\n\r\n " );
        for(ActorsList permission: permissionList) {
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