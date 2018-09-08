import java.util.Scanner;

import acyclicpattern.AcyclicPattern;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		try {
			AcyclicPattern acyclicPattern = new AcyclicPattern(
					scanner.nextLine());
			String sentence = scanner.nextLine();
			System.out.println(acyclicPattern.match(sentence));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		scanner.close();
	}

}
