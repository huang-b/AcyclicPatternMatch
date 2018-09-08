import java.util.Scanner;

import acyclicpattern.AcyclicPattern;

public class Main {

	// <[播]放|来>[一|几]<首|曲|个>@{singer}的<歌[曲]|[流行]音乐>
	// 来几首@{singer}的流行歌曲 => false
	// 来几首@{singer}的歌曲 => true
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
