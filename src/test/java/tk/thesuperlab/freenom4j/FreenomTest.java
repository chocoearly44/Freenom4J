package tk.thesuperlab.freenom4j;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FreenomTest {
	static Freenom freenom;

	@BeforeAll
	static void setup() {
		freenom = new Freenom(System.getenv("EMAIL"), System.getenv("PASSWORD"));
	}

	@Test
	void listDomains() {
		freenom.listDomains();
	}
}