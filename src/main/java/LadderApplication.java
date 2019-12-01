import domain.*;
import generator.LadderGenerator;
import utils.RandomBooleanGenerator;
import view.InputView;
import view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        String nameInput = InputView.getNameInput();
        String itemInput = InputView.getItemInput(nameInput);
        int height = InputView.getHeight();

        Players players = new Players(nameInput);
        int width = players.getNumberOfPlayers();
        Items items = new Items(itemInput);
        Ladder ladder = LadderGenerator.generate(
                players.getNumberOfPlayers(), height, new RandomBooleanGenerator()
        );
        LadderResult ladderResult = ladder.play(players, items);

        OutputView.printPlayers(players);
        OutputView.printLadder(ladder, width);
        OutputView.printItems(items, width);

        Player player = InputView.getPlayerInput(players);
        OutputView.printLadderResult(ladderResult, players, player);
    }
}
