package acyclicpattern;

public class ElementLink extends Link {

    private String pattern;

    public ElementLink(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public int match(String s, int i) {
        if (s.regionMatches(i, pattern, 0, pattern.length())) {
            return i + pattern.length(); // match
        } else {
            return -1; // unmatch
        }
    }
}
