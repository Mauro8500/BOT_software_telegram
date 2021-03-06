package bo.edu.ucb.ingsoft.movies.chat;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoviesLongPollingBot extends TelegramLongPollingBot {

    /**
     * Atributo que sirve para guardar el proceso actual de los diferentes usuarios.
     */
    private Map<Long, AbstractProcess> usersSession;
    private boolean test = false;
    private List<BotApiMethod> testMessages = new ArrayList<>();

    public MoviesLongPollingBot() {
        usersSession = new HashMap<>();
    }

    public MoviesLongPollingBot(boolean test) {
        this.test = test;
        usersSession = new HashMap<>();
    }

    @Override
    public String getBotUsername() {
        return "software_movies_bot";
    }

    @Override
    public String getBotToken() {
        return "5196834781:AAHrgR8Ei3_Fgw7WKWiAphJgytGEbmVlHVk";
    }

    public void sendMyMessage(BotApiMethod method) throws TelegramApiException {
        System.out.println("Enviando mensaje: " + method);
        if (test) {
            // no enviamos
            testMessages.add(method);
        } else {
            this.execute(method);
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        // Primero identifico al usuario por chat Id Long
        Long chatId = update.getMessage().getChatId();
        System.out.println("\n\n===========> Recibiendo chatId: " + chatId);
        // Busco si ya existe Proceso en el map userSession
        AbstractProcess currentProcess = usersSession.get(chatId);

        if (currentProcess == null) { // Primera vez que se contacto con nostros.
            System.out.println("Creando proceso para el  chatId: " + chatId);
            // Debo crear el proceso por defecto
            currentProcess = new MenuProcessImpl();
            usersSession.put(chatId, currentProcess);
            System.out.println("Derivando la conversaci??n al proceso: " + currentProcess.getName());
            AbstractProcess nextProcess = currentProcess.handle(update, this);

            if (!nextProcess.equals(currentProcess)) { // Si el siguiente proceso es diferente lo iniciamos
                System.out.println("Iniciando siguiente proceso: " + nextProcess.getName());
                nextProcess.handle(update, this);
            } else {
                System.out.println("No hay cambio de proceso, as?? que termina conversaci??n");
            }
            usersSession.put(chatId, nextProcess);

        } else { // Ya existe un proceso
            System.out.println("Continuamos el proceso para el  chatId: " + chatId
                    + " proceso: " + currentProcess.getName());
            AbstractProcess nextProcess = currentProcess.handle(update, this);

            if (!nextProcess.equals(currentProcess)) { // Si el siguiente proceso es diferente
                System.out.println("Iniciando siguiente proceso: " + nextProcess.getName());
                nextProcess = nextProcess.handle(update, this);
            } else {
                System.out.println("No hay cambio de proceso, as?? que termina conversaci??n");
            }
            usersSession.put(chatId, nextProcess);
        }

    }

    public List<BotApiMethod> getTestMessages() {
        return testMessages;
    }
}