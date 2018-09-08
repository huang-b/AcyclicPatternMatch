package acyclicpattern;

public class OptionalLink extends Link {
	
	private Link link;
	
	public OptionalLink(Link link) {
		this.link = link;
	}

	@Override
	public int match(String s, int i) {
		int j = link.match(s, i);
		return j < 0 ? i : j;
	}
}
