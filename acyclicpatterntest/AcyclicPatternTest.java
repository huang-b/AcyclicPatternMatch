package acyclicpatterntest;

import acyclicpattern.AcyclicPattern;
import acyclicpattern.Parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AcyclicPatternTest {

	@Test
	void testPaser() {
		Parser parser = new Parser("<[播]放|来>[一|几]<首|曲|个>@{singer}的<歌[曲]|[流行]音乐>$");
		StringBuilder builder = new StringBuilder();
		while(parser.hasNext()) {
			builder.append(parser.next());
		}
		String parsed = builder.toString();
		if(!"<[播]放|来>+[一|几]+<首|曲|个>+@{singer}的+<歌+[曲]|[流行]+音乐>".equals(parsed)) {
			fail(parsed);
		}
	}
	
	@Test
	void testPatternMatch() {
		try {
			AcyclicPattern ap = new AcyclicPattern(
					"<[播]放|来>[一|几]<首|曲|个>@{singer}的<歌[曲]|[流行]音乐>");
			assert(ap.match("来几首@{singer}的歌曲"));
			assert(ap.match("来首@{singer}的歌曲"));
			assert(ap.match("来一首@{singer}的流行音乐"));
			assert(!ap.match("来几首@{singer}的流行歌曲"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
