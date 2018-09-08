package acyclicpatterntest;

import acyclicpattern.AcyclicPattern;
import acyclicpattern.Parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AcyclicPatternTest {

	@Test
	void testPaser() {
		Parser parser = new Parser("<[��]��|��>[һ|��]<��|��|��>@{singer}��<��[��]|[����]����>$");
		StringBuilder builder = new StringBuilder();
		while(parser.hasNext()) {
			builder.append(parser.next());
		}
		String parsed = builder.toString();
		if(!"<[��]��|��>+[һ|��]+<��|��|��>+@{singer}��+<��+[��]|[����]+����>".equals(parsed)) {
			fail(parsed);
		}
	}
	
	@Test
	void testPatternMatch() {
		try {
			AcyclicPattern ap = new AcyclicPattern(
					"<[��]��|��>[һ|��]<��|��|��>@{singer}��<��[��]|[����]����>");
			assert(ap.match("������@{singer}�ĸ���"));
			assert(ap.match("����@{singer}�ĸ���"));
			assert(ap.match("��һ��@{singer}����������"));
			assert(!ap.match("������@{singer}�����и���"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
