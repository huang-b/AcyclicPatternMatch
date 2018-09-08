package acyclicpattern;

public class ConcatLink extends Link {

	private Link link1;
	private Link link2;
	
	public ConcatLink(Link link1, Link link2) {
		this.link1 = link1;
		this.link2 = link2;
	}
	
	@Override
	public int match(String s, int i) {
		int j = link1.match(s, i);
		if(j >= 0) {
			j = link2.match(s, j);
		}
		return j;
	}
}
