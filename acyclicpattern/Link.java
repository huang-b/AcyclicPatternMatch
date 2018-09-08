package acyclicpattern;

public abstract class Link {
	
	public abstract int match(String s, int i);
	
	public Link toOptional() {
		return new OptionalLink(this);
	}
	
	public Link combine(Link other) {
		return new AlternativeLink(this, other);
	}
	
	public Link concat(Link next) {
		return new ConcatLink(this, next);
	}
}
