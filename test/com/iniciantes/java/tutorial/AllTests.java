package com.iniciantes.java.tutorial;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(LivroTest.class);
		suite.addTestSuite(TestPessoa.class);
		suite.addTestSuite(BibliotecaTest.class);
		//$JUnit-END$
		return suite;
	}

}
