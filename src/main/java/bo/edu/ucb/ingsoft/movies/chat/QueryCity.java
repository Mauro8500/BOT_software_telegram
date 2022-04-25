package bo.edu.ucb.ingsoft.movies.chat;

import bo.edu.ucb.ingsoft.movies.bl.cityBl;
import bo.edu.ucb.ingsoft.movies.dto.cityDto;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class QueryCity extends AbstractProcess {

    public QueryCity() {
        this.setName("Consultar lista de Ciudades");
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
        cityBl citybl = new cityBl();
        List<cityDto> permissionList = citybl.findcityByChatId(chatId);
        StringBuffer sb = new StringBuffer();
        sb.append("Esta es la lista de CIUDADES:\r\n\r\n " ).append("\nEncontrados = "+permissionList.size()+"\n");
        sb.append("PRESIONA CUALQUIER TECLA PARA VOLVER\r\n\r\n " );
        for(cityDto permission: permissionList) {
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