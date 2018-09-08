package acyclicpattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Parser {
	
	private String s;
	private int i;
	private boolean endWord;
	private boolean endSubPattern;
	private Map<Character, String> singletons;
	private Map<Character, String> leftHands;
	private Map<Character, String> rightHands;
	private Set<Character> punctSet;
	
	public Parser(String s) {
		this.s = s;
		i = 0;
		endWord = endSubPattern = false;

		singletons = new HashMap<>();
		singletons.put('|', "|");
		singletons.put('$', "$");

		leftHands = new HashMap<>();
		leftHands.put('<', "<");
		leftHands.put('[', "[");

		rightHands = new HashMap<>();
		rightHands.put('>', ">");
		rightHands.put(']', "]");

		punctSet = new HashSet<>(singletons.keySet());
		punctSet.addAll(leftHands.keySet());
		punctSet.addAll(rightHands.keySet());
	}
	
	public boolean hasNext() {
		return i < s.length();
	}
	
	public String next() {
		if(singletons.containsKey(s.charAt(i))) {
			endWord = endSubPattern = false;
			return singletons.get(s.charAt(i++));
		}
		if(leftHands.containsKey(s.charAt(i))) {
			String symbol = (endWord || endSubPattern) ? "+" : leftHands.get(s.charAt(i++));
			endWord = endSubPattern = false;
			return symbol;
		}
		if(rightHands.containsKey(s.charAt(i))) {
			endWord = false;
			endSubPattern = true;
			return rightHands.get(s.charAt(i++));
		}
		if(endSubPattern) {
			endSubPattern = false;
			return "+";
		}
		StringBuilder builder = new StringBuilder();
		do {
			builder.append(s.charAt(i++));
		} while(hasNext() && !punctSet.contains(s.charAt(i)));
		endWord = true;
		return builder.toString();
	}
	
//	private boolean toConcat() {
//		if(endWord) {
//			endWord = false;
//			return s.charAt(i) == '<' || s.charAt(i) == '[';
//		} else if(end) 
//		
//	}
}
