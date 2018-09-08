import java.util.Scanner;

import acyclicpattern.AcyclicPattern;

public class Main {

	// <[��]��|��>[һ|��]<��|��|��>@{singer}��<��[��]|[����]����>
	// ������@{singer}�����и��� => false
	// ������@{singer}�ĸ��� => true
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
