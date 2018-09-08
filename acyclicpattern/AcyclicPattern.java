package acyclicpattern;

import java.util.Stack;

public class AcyclicPattern {
	
	private final static String EXCEP_MSG = "Invalid pattern format!";
	private Link link;
	
	public AcyclicPattern(String sentence) throws Exception {
		link = constructLink(new Parser(sentence + "$"), "#", "$");
	}
	
	/**
	 * 
	 * @param parser
	 * @return
	 * 
	 *    < [ + | ] > $
	 * #: < < < < x x end
	 * <: < < < < x = x
	 * [: < < < < = x x
	 * +: < < > > > > > 
	 * |: < < < > > > >
	 */
	private Link constructLink(Parser parser, final String startPunctuation,
			final String endPunctuation) throws Exception {
		Stack<String> punctStack = new Stack<>();
		punctStack.push(startPunctuation);
		Stack<Link> linkStack = new Stack<>();
		linkStack.push(new EmptyLink());
		
		boolean repeat = true;
		while(repeat && parser.hasNext()) {
			String s = parser.next();
			switch(s) {
			case "<": 
				linkStack.push(constructLink(parser, "<", ">"));
				concat(linkStack);
				break;
			case "[": 
				linkStack.push(constructLink(parser, "[", "]"));
				optional(linkStack);
				break;
			case "+":
				if("+".equals(punctStack.peek())) {
					concat(linkStack);
					punctStack.pop();
				}
				punctStack.push(s);
				break;
			case "|":
				if ("+".equals(punctStack.peek())) {
					concat(linkStack);
					punctStack.pop();
				}
				if("|".equals(punctStack.peek())) {
					combine(linkStack);
					punctStack.pop();
				}
				punctStack.push(s);
				break;
			default: 
				if(!endPunctuation.equals(s)) {
					linkStack.push(new ElementLink(s));
					break;
				}
				repeat = false;
				if ("+".equals(punctStack.peek())) {
					concat(linkStack);
					punctStack.pop();
				}
				if ("|".equals(punctStack.peek())) {
					combine(linkStack);
					punctStack.pop();
				}
				if (!startPunctuation.equals(punctStack.peek())) {
					throw new Exception(EXCEP_MSG);
				}
			}
		}
		
		return linkStack.pop();
	}
	
	private void combine(Stack<Link> linkStack) {
		Link link2 = linkStack.pop();
		Link link1 = linkStack.pop();
		linkStack.push(link1.combine(link2));
	}
	
	private void optional(Stack<Link> linkStack) {
		Link link = linkStack.pop();
		//linkStack.push(new OptionalLink(link));
		linkStack.push(link.combine(new EmptyLink()));
	}
	
	private void concat(Stack<Link> linkStack) {
		Link link2 = linkStack.pop();
		Link link1 = linkStack.pop();
		linkStack.push(link1.concat(link2));
	}
	
	public boolean match(String sentence) {
		int i = link.match(sentence, 0);
		return i == sentence.length();
	}
}
