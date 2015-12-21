package org.sonatype.mavenbook.ch04.simple_weather;

import java.io.InputStream;

import org.apache.log4j.PropertyConfigurator;

public class Main {

	public Main(int zipcode) {
		this.zip = zipcode;
	}

	public static void main(String[] args) {
		// Configure Log4J
		PropertyConfigurator.configure(Main.class.getClassLoader().getResource("log4j.properties"));
		// Read the Zip code from Command-line (if none supplied,use 60202)
		int zipcode = 60202;
		try {
			zipcode = Integer.parseInt(args[0]);
		} catch (Exception e) {
			try {
				new Main(zipcode).start();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

	private int zip;

	public void start() throws Exception {
		// Retrieve data
		InputStream dataIn = new YahooRetriever().retrieve(zip);
		// Parse Data
		Weather weather = new YahooParser().parse(dataIn);
		// Format (Print) Data
		System.out.print(new WeatherFormatter().format(weather));
	}

}
