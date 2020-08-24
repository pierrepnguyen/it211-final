import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class guessDeck {
	public static guessCard[] deck;
	public static int currentCard;

	public guessDeck() throws IOException {
		deck = new guessCard[52];
		int i = 0;
		//for loop through 4 suits
		for (guessCard.Suit s : guessCard.Suit.values()){
			for (guessCard.Rank r : guessCard.Rank.values()){
				deck[i] = new guessCard (r.getRank(),
														s.getSuit(),
														r.getValue(),
														ImageIO.read(new File("cards/" + r.getImg() + s.getImgVal() + ".gif")));                   
				i++;
			}
		}
		currentCard = 0;
	}

  // Shuffle deck method
	public void shuffle() {
		Random rand = new Random();
		guessCard temp;
    
		for(int i = 0; i < deck.length; i++) {
      int num = rand.nextInt(deck.length - 1);
			temp = deck[i];
			deck[i] = deck[num];
			deck[num] = temp;
		}
		currentCard = 0;
	}

	public static guessCard deal(){
		if (currentCard < deck.length) {
			guessCard cRValue = deck[currentCard];
			currentCard++;
			return cRValue;
		} else{
			System.out.println("Out of cards error");
			return null;
		}
	}
}