package hailo;

import java.util.HashMap;

public interface Logging {
	
	public Integer ALL		= 1;
	public Integer LOGGING 	= 10;
	public Integer DEBUG 	= 100;
	public Integer WARNING 	= 1000;
	public Integer ERROR 	= 10000;
	public Integer NONE 	= 100000;
	public HashMap<Integer, String> LABELS = new HashMap<Integer, String>() 
	{/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		put(ALL, "");
		put(LOGGING, "[LOGGING]: ");
		put(DEBUG, "[DEBUG]: ");
		put(WARNING, "[WARNING]: ");
		put(ERROR, "[ERROR]: ");
		put(NONE, "[NONE]: ");
	}};
	
	public String ALL_TEXT 		= LABELS.get(ALL);
	public String LOGGING_TEXT 	= LABELS.get(LOGGING);
	public String DEBUG_TEXT 	= LABELS.get(DEBUG);
	public String WARNING_TEXT 	= LABELS.get(WARNING);
	public String ERROR_TEXT 	= LABELS.get(ERROR);
	public String NONE_TEXT 	= LABELS.get(NONE);
	
}