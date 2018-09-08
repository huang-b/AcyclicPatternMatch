package acyclicpatterntest;

import acyclicpattern.AcyclicPattern;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AcyclicPatternTest {

	@Test
	void test() {
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
