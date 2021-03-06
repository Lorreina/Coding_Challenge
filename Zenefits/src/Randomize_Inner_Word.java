import java.util.Arrays;
import java.util.HashMap;

public class Randomize_Inner_Word {
	public static String randomizeWord(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		StringBuilder result = new StringBuilder();
		String[] words = str.split(" ");
		for (int i = 0; i < words.length; i++) {
			String tmp = randomize(words[i]);
			if (i > 0) {
				result.append(" ");
			}
			result.append(tmp);
		}
		return result.toString();
	}
	
	private static String randomize(String word) {
		if (word == null || word.length() <= 3) {
			return word;
		}
		
		HashMap<Double, Character> map = new HashMap<Double, Character> ();
		double[] randomNum = new double[word.length() - 2];
		for (int i = 0; i < randomNum.length; i++) {
			randomNum[i] = Math.random();
			map.put(randomNum[i], word.charAt(i + 1));
		}
		
		Arrays.sort(randomNum);
		
		StringBuilder result = new StringBuilder();
		result.append(String.valueOf(word.charAt(0)));
		for (int i = 0; i < randomNum.length; i++) {
			result.append(String.valueOf(map.get(randomNum[i])));
		}
		result.append(String.valueOf(word.charAt(word.length() - 1)));
		
		return result.toString();
	}
	
	public static void main(String[] args) {
		String words = "you are beautiful";
		System.out.println(randomizeWord(words));
	}
}
