package org.sonatype.mavenbook.ch04.simple_weather;

import java.io.InputStream;

import junit.framework.TestCase;

public class YahooParserTest extends TestCase {

	public YahooParserTest() {
		super();
	}

	public YahooParserTest(String name) {
		super(name);
	}

	public void testParser() throws Exception {
		InputStream nyData = getClass().getClassLoader().getResourceAsStream("ny-weather.xml");
		if (null != nyData) {
			Weather weather = new YahooParser().parse(nyData);
			assertEquals("New York", weather.getCity());
			assertEquals("NY", weather.getRegion());
			assertEquals("US", weather.getCountry());
			assertEquals("39", weather.getTemp());
			assertEquals("Fair", weather.getCondition());
			assertEquals("39", weather.getChill());
			assertEquals("67", weather.getHumidity());
		}
	}

}
