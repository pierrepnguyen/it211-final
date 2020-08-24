import java.io.IOException;

public class guessGame {
	public static guessDeck deck;

	public static void main(String[] args) throws IOException {
		deck = new guessDeck();
		deck.shuffle();
		new gameGUI();
	}
}