package view;

import domain.*;

public class OutputView {
    private static final String PLAYER = "|";
    private final static String CONNECTED = "-----";
    private final static String DISCONNECTED = "     ";
    private static final String ALL = "all";
    private static final String RESULT_DELIMITER = " : ";

    public static void printPlayers(Players players) {
        int width = players.getNumberOfPlayers();
        System.out.println("사다리 결과");
        for (int i = 0; i < width; i++) {
            System.out.printf("%6s", players.getPlayer(i));
        }
        System.out.println();
    }

    public static void printLadder(Ladder ladder, int width) {
        for (int i = 0; i < ladder.getHeight(); i++) {
            Line line = ladder.getLine(i);
            printLine(line, width);
        }
    }

    private static void printLine(Line line, int width) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DISCONNECTED);
        for (int i = 0; i < width - 1; i++) {
            stringBuilder.append(PLAYER);
            stringBuilder.append(buildLine(line, i));
        }
        stringBuilder.append(PLAYER);
        System.out.println(stringBuilder);
    }

    private static String buildLine(Line line, int index) {
        if (line.isMovableToRight(index)) {
            return CONNECTED;
        }
        return DISCONNECTED;
    }

    public static void printItems(Items items, int width) {
        for (int i = 0; i < width; i++) {
            System.out.printf("%6s", items.getItem(i));
        }
        System.out.println();
    }

    public static void printLadderResult(LadderResult ladderResult, Players players, Player player) {
        System.out.println("실행 결과");
        if (new Player(ALL).equals(player)) {
            printAllResult(ladderResult, players);
            return;
        }
        System.out.println(player + RESULT_DELIMITER + ladderResult.getItemByPlayer(player));
    }

    private static void printAllResult(LadderResult ladderResult, Players players) {
        for (int i = 0; i < players.getNumberOfPlayers(); i++) {
            Player player = players.getPlayer(i);
            System.out.println(player + RESULT_DELIMITER + ladderResult.getItemByPlayer(player));
        }
    }
}
