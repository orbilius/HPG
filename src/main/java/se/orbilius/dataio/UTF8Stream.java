package se.orbilius.dataio;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class UTF8Stream {
	
	private static PrintStream ps;

	
	static{
		try {
			ps = new PrintStream(System.out, true, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public static void println(String str){
		ps.println(str);
	}
}
