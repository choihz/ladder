package domain;

import exception.InvalidNameException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Players {
    private static final String DELIMITER = ",";

    private final List<Player> players;

    public Players(String nameInput) {
        this.players = initializePlayers(nameInput);
    }

    private List<Player> initializePlayers(String nameInput) {
        String[] names = nameInput.split(DELIMITER);
        checkDuplication(names);
        List<Player> players = new ArrayList<>();
        for (String name : names) {
            players.add(new Player(name));
        }
        return players;
    }

    private void checkDuplication(String[] names) {
        long count = Stream.of(names)
                .distinct()
                .count();
        if (count != names.length) {
            throw new InvalidNameException("중복된 이름이 존재합니다.");
        }
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public boolean contains(Player player) {
        return players.contains(player);
    }
}
