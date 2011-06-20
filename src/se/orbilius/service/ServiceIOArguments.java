package se.orbilius.service;

import java.util.Arrays;
import java.util.List;

public class ServiceIOArguments {
	private String inMode = null;
	private String inHost = null;
	private int inPort = -1;
	private String inDb = null;
	private String inCol = null;
	private String inFile = null;
	
	public enum Direction {
		DIRECTION_IN, DIRECTION_OUT;
	}
	
	public String getMode(Direction dir) {
		return dir == Direction.DIRECTION_IN ? inMode: outMode;
	}

	public String getHost(Direction dir) {
		return dir == Direction.DIRECTION_IN ? inHost: outHost;
	}

	public int getPort(Direction dir) {
		return dir == Direction.DIRECTION_IN ? inPort: outPort;
	}

	public String getDb(Direction dir) {
		return dir == Direction.DIRECTION_IN ? inDb: outDb;
	}

	public String getCol(Direction dir) {
		return dir == Direction.DIRECTION_IN ? inCol: outCol;
	}

	public String getFile(Direction dir) {
		return dir == Direction.DIRECTION_IN ? inFile: outFile;
	}



	private String outMode = null;
	private String outHost = null;
	private int outPort = -1;
	private String outDb = null;
	private String outCol = null;
	private String outFile = null;

	
	public String service = null;
	public String log = null;
	
	private static String INMODEARG = "-inmode";
	private static String INHOSTARG = "-inhost";
	private static String INPORTARG = "-inport";
	private static String INDBARG = "-indb";
	private static String INCOLARG = "-incol";
	private static String INFILEARG = "-infile";

	private static String OUTMODEARG = "-outmode";
	private static String OUTHOSTARG = "-outhost";
	private static String OUTPORTARG = "-outport";
	private static String OUTDBARG = "-outdb";
	private static String OUTCOLARG = "-outcol";
	private static String OUTFILEARG = "-outfile";

	
	private static String SERVICEARG ="-service";
	private static String LOGFILEARG = "-log";
	
	public static ServiceIOArguments parse(String args[]){
		List<String> list = Arrays.asList(args);

		ServiceIOArguments argms = new ServiceIOArguments();
		
		for (String str : list) {
			argms.inMode = argms.inMode == null ? getParsed(str, INMODEARG) : argms.inMode;
			argms.inHost = argms.inHost == null ? getParsed(str, INHOSTARG) : argms.inHost;
			String sport = argms.inPort == -1 ? getParsed(str, INPORTARG) : Integer
					.toString(argms.inPort);
			if (sport != null) {
				argms.inPort = Integer.parseInt(sport);

			}
			argms.inDb = argms.inDb == null ? getParsed(str, INDBARG) : argms.inDb;
			argms.inCol = argms.inCol == null ? getParsed(str, INCOLARG) : argms.inCol;
			argms.inFile = argms.inFile == null ? getParsed(str, INFILEARG) : argms.inFile;

			
			argms.outMode = argms.outMode == null ? getParsed(str, OUTMODEARG) : argms.outMode;
			argms.outHost = argms.outHost == null ? getParsed(str, OUTHOSTARG) : argms.outHost;
			String outsport = argms.outPort == -1 ? getParsed(str, OUTPORTARG) : Integer
					.toString(argms.outPort);
			if (outsport != null) {
				argms.outPort = Integer.parseInt(outsport);

			}
			argms.outDb = argms.outDb == null ? getParsed(str, OUTDBARG) : argms.outDb;
			argms.outCol = argms.outCol == null ? getParsed(str, OUTCOLARG) : argms.outCol;
			argms.outFile = argms.outFile == null ? getParsed(str, OUTFILEARG) : argms.outFile;
			
			argms.service = argms.service == null ? getParsed(str, SERVICEARG) : argms.service;
			argms.log = argms.log == null ? getParsed(str, LOGFILEARG) : argms.log;
		}
		return argms;
	}

	protected static String getParsed(String text, String name) {
		if (text.startsWith(name)) {
			return text.substring(name.length(), text.length());
		}
		return null;
	}
	
}
