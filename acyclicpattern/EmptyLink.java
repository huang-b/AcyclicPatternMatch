package acyclicpattern;

public class EmptyLink extends Link {
	
	@Override
	public int match(String s, int i) {
		return i;
	}
	
	@Override
	public Link concat(Link other) {
		return other;
	}
	
	@Override
	public Link toOptional() {
		return this;
	}

}
