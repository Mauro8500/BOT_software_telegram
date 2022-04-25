package bo.edu.ucb.ingsoft.movies.chat;

import bo.edu.ucb.ingsoft.movies.bl.customerBl;
import bo.edu.ucb.ingsoft.movies.dto.customerDto;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class findNameCustomer extends AbstractProcess {

    public findNameCustomer() {
        this.setName("Busqueda por nombres");
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
        customerBl customerbl = new customerBl();
        List<customerDto> permissionList = customerbl.findcustomerByChatId(chatId);
        StringBuffer sb = new StringBuffer();
        sb.append("Esta es la lista de Clientes en nuestros registros:\r\n\r\n " ).append("\nEncontrados = "+permissionList.size()+"\n");
        sb.append("PRESIONA CUALQUIER TECLA PARA VOLVER\r\n\r\n " );
        for(customerDto permission: permissionList) {
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