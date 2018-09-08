package acyclicpattern;

import java.util.HashMap;
import java.util.Map;

public class Parser {
	
	private String s;
	private int i;
	private boolean endWord;
	private boolean endSubPattern;
	private Map<Character, String> punctMap;
	
	public Parser(String s) {
		this.s = s;
		i = 0;
		endWord = false;
		endSubPattern = false;
		punctMap = new HashMap<>();
		punctMap.put('<', "<");
		punctMap.put('>', ">");
		punctMap.put('[', "[");
		punctMap.put(']', "]");
		punctMap.put('|', "|");
		punctMap.put('$', "$");
	}
	
	public boolean hasNext() {
		return i < s.length();
	}
	
	public String next() {
		String punctuation = punctMap.get(s.charAt(i));
		if(null != punctuation) {
			if(endWord && (s.charAt(i) == '<' || s.charAt(i) == '[')) {
				endWord = false;
				return "+";
			}
			endWord = false;
			endSubPattern = s.charAt(i) == '>' || s.charAt(i) == ']';
			i++;
			return punctuation;
		}
		if(endSubPattern) {
			endSubPattern = false;
			return "+";
		}
		StringBuilder builder = new StringBuilder();
		do {
			builder.append(s.charAt(i++));
		} while(hasNext() && !punctMap.containsKey(s.charAt(i)));
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
