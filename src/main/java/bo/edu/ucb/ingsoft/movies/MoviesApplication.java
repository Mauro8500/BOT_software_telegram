package bo.edu.ucb.ingsoft.movies;


import bo.edu.ucb.ingsoft.movies.chat.MoviesLongPollingBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
//import javax.sql.DataSource;

@SpringBootApplication
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
		try {
			// Inicializamos libreria de bots
			TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
			// Registramos la implementación de nuestro BOT
			telegramBotsApi.registerBot(new MoviesLongPollingBot());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

}