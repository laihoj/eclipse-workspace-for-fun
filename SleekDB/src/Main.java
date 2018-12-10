import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import SleekDB.Database;

public class Main {
	static Database db;
	public static void main(String[] args) throws Exception {
		final String url = "https://sleekgestures.herokuapp.com/";
		
		
		db = new Database(url);
		
		db.saveDevice("00:0E:0E:0D:7B:0A", "74278BDA-B644-4520-8F0C-720EAF059935", "Sleek0101", "jaakko");
//			db.saveDatapoint("000E0E0D7B01", ""+System.currentTimeMillis(), "{data}");			
//		System.out.println(db.getDeviceByAddress("00:0E:0E:0D:7B:0A"));
//		System.out.println(db.getDevicesByUser("jaakko"));
		
		String response = db.getDevicesByUser("jaakko");


	}

}
