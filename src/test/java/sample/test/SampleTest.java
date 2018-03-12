package sample.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SampleTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void simplePassingTest() {
		System.out.println("Running always-passing test");
		// With nothing here, this test should pass.
		// This is to make sure that everything is working, before we continue on.
	}

}
