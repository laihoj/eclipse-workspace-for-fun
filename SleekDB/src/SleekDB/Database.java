package SleekDB;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Database {
	final String address;
	
	public Database(String address) {
		this.address = address;
	}

	
	public void saveDatapoint(	String deviceAddress,
								String timestamp,
								String data) 
	throws Exception
	{
		Map<String, String> parameters = new HashMap<>();
		parameters.put("device_address", deviceAddress);
		parameters.put("timestamp", timestamp);
		parameters.put("data", data);
		 
		URL url = new URL(address + "api/datapoints");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		
		 
		DataOutputStream out = new DataOutputStream(con.getOutputStream());
		out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
		out.flush();
		out.close();
		
		BufferedReader in = new BufferedReader(
				  new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
				    content.append(inputLine);
				}
				System.out.println("Datapoint of " + deviceAddress + " saved");
				in.close();
				con.disconnect();
	}
	
	
	
	/*
	 * 
	 * */
	public void saveDevice(	String deviceAddress,
							String deviceUUID,
							String deviceName,
							String deviceUser) 
	throws Exception
	
	{
		if(!(getDeviceByAddress(deviceAddress).length() > 0)) {
			
		Map<String, String> parameters = new HashMap<>();
		parameters.put("device_address", deviceAddress);
		parameters.put("device_uuid", deviceUUID);
		parameters.put("device_name", deviceName);
		parameters.put("device_user", deviceUser);
		 
		URL url = new URL(address + "api/devices");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		
		 
		DataOutputStream out = new DataOutputStream(con.getOutputStream());
		out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
		out.flush();
		out.close();
		
		BufferedReader in = new BufferedReader(
				  new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
				    content.append(inputLine);
				}
				System.out.println("Device " + deviceAddress + " saved");
				in.close();
				con.disconnect();
		} else {
			System.out.println("Device " + deviceAddress + " not saved, record already exists");
		}
	} 
	
	
	
	
	public String getDeviceByAddress(String deviceAddress)
	throws Exception
	{
		 
		URL url = new URL(address + "api/devices/address/"+deviceAddress);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		
		BufferedReader in = new BufferedReader(
				  new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
				    content.append(inputLine);
				}
//				System.out.println(content);
				in.close();
				con.disconnect();
				return content.toString();
	}
	
	
	
	
	public String getDevicesByUser(String username)
	throws Exception
			{
				 
				URL url = new URL(address + "api/devices/user/"+username);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				
				BufferedReader in = new BufferedReader(
						  new InputStreamReader(con.getInputStream()));
						String inputLine;
						StringBuffer content = new StringBuffer();
						while ((inputLine = in.readLine()) != null) {
						    content.append(inputLine);
						}
						in.close();
						con.disconnect();
						return content.toString();
			}
	
}
