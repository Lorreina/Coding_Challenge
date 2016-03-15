import java.util.ArrayList;

public class DeckCard {
	public enum Suit {
		Club(0), Diamond(1), Heart(2), Spade(3);
		private int value;
		private Suit(int v) {
			this.value = v;
		}
		public int getValue() {
			return this.value;
		}
		public static Suit getSuitFromValue(int value) {
			// to be added. 
			return null;
		}
	}
	
	public class Deck <T extends Card> {
		private ArrayList<T> cards; // all cards, dealt or not
		private int dealtIndex = 0; //mark first undealt card
		
		public void setDeckOfCards(ArrayList<T> deckOfCards) {
			// ...
		}
		
		public void shuffle() {
			// ...
		}
		
		public int remainingCards() {
			return cards.size();
		}
		
		public T[] dealHand(int number) {
			//...
			return null;
		}
		
		public T dealCard() {
			// ...
			return null;
		}
	}
	
	public abstract class Card {
		private boolean available = true;
		
		protected int faceValue;
		protected Suit suit;
		
		public Card(int c, Suit s) {
			this.faceValue = c;
			this.suit = s;
		}
		
		public abstract int value();
		public Suit suit() {
			return this.suit;
		}
		
		public boolean isAvailable() {
			return this.available;
		}
		
		public void markUnavailable() {
			this.available = false;
		}
		
		public void markAvailable() {
			this.available = true;
		}
	}
	
	public class Hand<T extends Card> {
		protected ArrayList<T> cards = new ArrayList<T> ();
		
		public int score() {
			int score = 0;
			for (T card : cards) {
				score = score + card.value();
			}
			return score;
		}
		
		public void addCard(T card) {
			cards.add(card);
		}
	}
	
	public class BlackJackHand extends Hand<BlackJackCard> {
		public int score() {
			ArrayList<Integer> scores = possibleScores();
			int maxUnder = Integer.MIN_VALUE;
			int minOver = Integer.MAX_VALUE;
			for (int score : scores) {
				if (score > 21 && score < minOver) {
					minOver = score;
				} else if (score <= 21 && score > maxUnder) {
					maxUnder = score;
				}
			}
			if (maxUnder == Integer.MIN_VALUE) {
				return minOver;
			} else {
				return maxUnder;
			}
		}
		
		private ArrayList<Integer> possibleScores() {
			// ...
			return null;
		}
		
		public boolean busted() {
			return score() > 21;
		}
		
		public boolean is21() {
			return score() == 21;
		}
		
		public boolean isBlackJack() {
			// ...
			return false;
		}
	}
	
	public class BlackJackCard extends Card {
		public BlackJackCard(int c, Suit s) {
			super(c, s);
		}
		public int value() {
			if (isAce()) {
				return 1;
			} else if (faceValue >= 11 && faceValue <= 13) {
				return 10;
			} else {
				return faceValue;
			}
		}
		
		public boolean isAce() {
			return (faceValue == 1);
		}
		
		public int minValue() {
			if (isAce()) {
				return 1;
			} else {
				return this.value();
			}
		}
		
		public int maxValue() {
			if (isAce()) {
				return 11;
			} else {
				return this.value();
			}
		}
		
		public boolean isFaceCard() {
			return faceValue >= 11 && faceValue <= 13;
		}
	}
	
	
}
