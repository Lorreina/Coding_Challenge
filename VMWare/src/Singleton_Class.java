
public class Singleton_Class {
	public static class Restaurant {
		private static Restaurant _instance = null;
		protected Restaurant() {
			
		}
		
		public static Restaurant getInstance() {
			if (_instance == null) {
				_instance = new Restaurant();
			} 
			return _instance;
		}
	}
	
//	public class Restaurant {
//		private static Restaurant _instance = null;
//		protected Restaurant () {
//			
//		}
//		
//		public Restaurant getInstance() {
//			if (_instance == null) {
//				_instance = new Restaurant();
//			} 
//			return _instance;
//		}
//	}
	
	public static class CardGame {
		public static CardGame createCardGame(GameType type) {
			if (type == GameType.Poker) {
				return new PokerGame();
			} else if (type == GameType.Poker) {
				return new BlackJackGame();
			}
			return null;
		}
	}
	
	public static class PokerGame extends CardGame{
		public PokerGame() {
			super();
		}
	}
	
	public static class BlackJackGame extends CardGame {
		public BlackJackGame() {
			super();
		}
	}
	
	public enum GameType {Poker, BlackJackGame};
}
