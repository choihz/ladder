package view;

import domain.Player;
import domain.Players;
import exception.InvalidHeightException;
import exception.InvalidItemException;
import exception.InvalidNameException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.stream.Stream;

public class InputView {
    private static final Logger logger = LoggerFactory.getLogger(InputView.class);
    private static final Scanner scanner = new Scanner(System.in);

    private static final int MIN_NUMBER_OF_PLAYER = 2;
    private static final int MIN_HEIGHT = 1;
    private static final String DELIMITER = ",";
    private static final String NAME_REGEX = "[가-힣a-zA-Z,]+";
    private static final String ITEM_REGEX = "[가-힣a-zA-Z0-9,]+";
    private static final String ALL = "all";

    public static String getNameInput() {
        System.out.println("참여할 사람 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분하며, 1~5자만 가능합니다).");
        try {
            return validateNameInput(scanner.nextLine());
        } catch (InvalidNameException e) {
            System.err.println(e.getMessage());
            logger.error("error: {}", e.getMessage());
            return getNameInput();
        }
    }

    private static String validateNameInput(String nameInput) {
        String[] names = nameInput.split(DELIMITER);
        validateNumberOfPlayers(names);
        validateNameInputRule(names);

        return nameInput;
    }

    private static void validateNumberOfPlayers(String[] names) {
        if (names.length < MIN_NUMBER_OF_PLAYER) {
            throw new InvalidNameException("둘 이상의 이름을 입력하세요.");
        }
    }

    private static void validateNameInputRule(String[] names) {
        long numberOfValidNames = Stream.of(names)
                .filter(name -> name.matches(NAME_REGEX))
                .count();
        if (numberOfValidNames != names.length) {
            throw new InvalidNameException("이름으로는 1자 이상의 한글, 영어만 사용 가능합니다.");
        }
    }

    public static String getItemInput(String nameInput) {
        int numberOfItem = nameInput.split(DELIMITER).length;
        System.out.println("실행 결과를 입력하세요(결과는 쉼표(,)를 기준으로 구분하며, 1~5자만 가능합니다).");
        try {
            return validateItemInput(scanner.nextLine(), numberOfItem);
        } catch (InvalidItemException e) {
            System.err.println(e.getMessage());
            logger.error("error: {}", e.getMessage());
            return getItemInput(nameInput);
        }
    }

    private static String validateItemInput(String itemInput, int numberOfItem) {
        if (!itemInput.matches(ITEM_REGEX)) {
            throw new InvalidNameException("결과로는 한글, 영어, 숫자만 사용 가능합니다.");
        }
        if (itemInput.split(DELIMITER).length != numberOfItem) {
            throw new InvalidItemException("이름과 같은 수의 결과가 입력되어야 합니다.");
        }
        return itemInput;
    }

    public static int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            return validateHeightInput(Integer.parseInt(scanner.nextLine()));
        } catch (NumberFormatException e) {
            System.err.println("숫자만 입력 가능합니다.");
            logger.error("error: {}", e.getMessage());
            return getHeight();
        } catch (InvalidHeightException e) {
            System.err.println(e.getMessage());
            logger.error("error: {}", e.getMessage());
            return getHeight();
        }
    }

    private static int validateHeightInput(int heightInput) {
        if (heightInput < MIN_HEIGHT) {
            throw new InvalidHeightException();
        }
        return heightInput;
    }

    public static Player getPlayerInput(Players players) {
        System.out.println("결과를 보고 싶은 사람은?");
        try {
            return validatePlayerInput(scanner.nextLine(), players);
        } catch (InvalidNameException e) {
            System.err.println(e.getMessage());
            logger.error("error: {}", e.getMessage());
            return getPlayerInput(players);
        }
    }

    private static Player validatePlayerInput(String playerInput, Players players) {
        Player player = new Player(playerInput);
        if (ALL.equals(playerInput) || players.contains(player)) {
            return player;
        }
        throw new InvalidNameException("존재하지 않는 이름입니다.");
    }
}
