package bo.edu.ucb.ingsoft.movies.bl;

import bo.edu.ucb.ingsoft.movies.dto.ActorsList;

import java.util.ArrayList;
import java.util.List;

public class ShowActors {

    public ShowActors() {
    }

    public List<ActorsList> findLast10PermissionsByChatId(Long chatId) {
        List<ActorsList> result = new ArrayList<>();
        result.add(new ActorsList("Will", "Smith"));
        result.add(new ActorsList("John", "Krasinsky"));
        result.add(new ActorsList("Billy", "Murray"));
        result.add(new ActorsList("Ewan", "McGregor"));
        result.add(new ActorsList("Robbie", "Williams"));
        result.add(new ActorsList("Silvester", "Stalone"));
        result.add(new ActorsList("Samuel", "Jackson"));
        result.add(new ActorsList("Mark", "Hamill"));
        return result;
    }
}
