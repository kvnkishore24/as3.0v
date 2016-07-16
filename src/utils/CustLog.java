package utils;

import org.apache.log4j.Level;

@SuppressWarnings("serial")
public class CustLog extends Level {

	protected CustLog(int level, String levelStr, int syslogEquivalent) {
		super(level, levelStr, syslogEquivalent);
	}

	public static CustLog toLevel(int val, Level defaultLevel) {
		return AVGPAGELOAD_INFO;
	}

	public static CustLog toLevel(String sArg, Level defaultLevel) {
		return AVGPAGELOAD_INFO;
	}
	
	public static final CustLog  AVGPAGELOAD_INFO= new CustLog(20001, "AVGPAGELOAD_INFO", 0);

}
