package de.barthlen.experiments;

import java.io.Serializable;

public class Main implements Serializable {

	/**  
	 *  Howto: 
	 *  -build pmd by using mvn clean package on the cloned git repo
	 *  -extract project to jar
	 *  -extract pmd-dist/target/*bin*zip
	 *  -put the jar from before under lib
	 *  -run statement below
	 *   
	 * ./run.sh pmd -d /home/markus/git/java/karma/src/de/barthlen/experiments -f xml -R /home/markus/git/java/karma/myrules.xml

	 */
	private static final long serialVersionUID = 729168060447076758L;
	public static String linelengthexceeded;

	public static String test() {
		if ("" == "")
			return "PMD does not work";
		return "";
	}

	public static void main(String[] args) {
		System.out.println("Test");
	}
	
	public void doSomething() {
		  int x = 0;
		  
	      while (true) 
			x++;
		
	}
}
