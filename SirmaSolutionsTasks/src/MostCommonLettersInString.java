import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class MostCommonLettersInString {

	static TreeMap<Character, Integer> lettersSet;
	static int maxElements;

	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);

		System.out.print("Please enter some text: ");

		String inputString = scan.nextLine();

		findMostCommonLetters(inputString);

	}

	static void findMostCommonLetters(String inputString) {

		inputString = inputString.toUpperCase();

		lettersSet = new TreeMap<>();

		for (int i = 0; i < inputString.length(); i++) {
			if (inputString.charAt(i) >= 'A' && inputString.charAt(i) <= 'Z') {
				if (lettersSet.containsKey(inputString.charAt(i))) {
					lettersSet.put(inputString.charAt(i), lettersSet.get(inputString.charAt(i)) + 1);
				} else {
					lettersSet.put(inputString.charAt(i), 1);
				}
			}
		}

		maxElements = lettersSet.entrySet().stream()
				.max((value1, value2) -> value1.getValue() > value2.getValue() ? 1 : -1).get().getValue();

		System.out.printf("%s%n%n", "Most common letters:");

		lettersSet.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).limit(20)
				.forEach(x -> print(x));

	}

	static void print(Entry<Character, Integer> letter) {
		System.out.println(letter.getKey() + ": " + letter.getValue() + " " + setRating(letter.getValue()));
	}

	static StringBuilder setRating(Integer currValue) {

		StringBuilder sb = new StringBuilder();

		int n = (int) Math.round((20.0 / maxElements) * currValue);
		for (int i = 0; i < n; i++) {
			sb.append("#");
		}

		return sb;
	}

}
