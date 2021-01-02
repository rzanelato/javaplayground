package file;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TestJSon {
	
	public static void main(String[] args) {
		 //String jsonString = "{\"archive\": [{\"field1\": 11,\"field2\": 12,\"field3\": 13},{\"field1\": 21,\"field2\": 22,\"field3\": 23},{\"field1\": 31,\"field2\": 32,\"field3\": 33}]}";
	        try {
	        	String jsonString = jsonTeste();
	        	JSONObject output;
	            output = new JSONObject(jsonString);


	            JSONArray docs = output.getJSONArray("archive");
	            
	            for(String str : JSONObject.getNames(output)) {
	            	
	            	System.out.println(str);
	            }
	            
	            Iterator<?> inter = docs.iterator();
	            while (inter.hasNext()) {
	            	Object obj = inter.next();
					System.out.println(obj);
					
				}
	            JSONObject jobj = docs.getJSONObject(2);
	            System.out.println(jobj.get("field2"));
	            
	            String[] nomes = JSONObject.getNames(jobj);
	            
	            for (String string : nomes) {
	            	System.out.println(string +":"+ jobj.get(string));
					
				}
	            
	            

	            File file = new File("/temp/fromJSON.xls");
	            String csv = CDL.toString(docs);
	            System.out.println("csv:");
	            System.out.println(csv);
	            FileUtils.writeStringToFile(file, csv, "UTF-8");
	            /*
	            FileUtils.writeStringToFile(file, "\tTeste", "UTF-8", true);
	            FileUtils.writeStringToFile(file, "\tOutro", "UTF-8", true);
	            FileUtils.writeStringToFile(file, "\tRenato", "UTF-8", true);
	        } catch (IOException e) {
	        	e.printStackTrace();
	            */
	        } catch (JSONException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
				e.printStackTrace();
			}  
		 
	}
	
	
	private static String jsonTeste() {
		return "{\"id\": \"0001\\\",\\\"type\\\": \\\"donut\\\",\\\"name\\\": \\\"Cake\\\",\\\"ppu\\\": 0.55,\\\"batters\\\":{\\\"batter\\\":[{ \\\"id\\\": \\\"1001\\\", \\\"type\\\": \\\"Regular\\\" },{ \\\"id\\\": \\\"1002\\\", \\\"type\\\": \\\"Chocolate\\\" },{ \\\"id\\\": \\\"1003\\\", \\\"type\\\": \\\"Blueberry\\\" },{ \\\"id\\\": \\\"1004\\\", \\\"type\\\": \\\"Devil's Food\\\" }]},\\\"topping\\\":[{ \\\"id\\\": \\\"5001\\\", \\\"type\\\": \\\"None\\\" },{ \\\"id\\\": \\\"5002\\\", \\\"type\\\": \\\"Glazed\\\" },{ \\\"id\\\": \\\"5005\\\", \\\"type\\\": \\\"Sugar\\\" },{ \\\"id\\\": \\\"5007\\\", \\\"type\\\":\\\"Powdered Sugar\\\" },{ \\\"id\\\": \\\"5006\\\", \\\"type\\\": \\\"Chocolate with Sprinkles\\\" },{ \\\"id\\\": \\\"5003\\\", \\\"type\\\": \\\"Chocolate\\\" },{ \\\"id\\\": \\\"5004\\\", \\\"type\\\": \\\"Maple\\\" }]},{\\\"id\\\": \\\"0002\\\",\\\"type\\\": \\\"donut\\\",\\\"name\\\":\\\"Raised\\\",\\\"ppu\\\": 0.55,\\\"batters\\\":{\\\"batter\\\":[{ \\\"id\\\": \\\"1001\\\", \\\"type\\\": \\\"Regular\\\" }]},\\\"topping\\\":[{ \\\"id\\\": \\\"5001\\\", \\\"type\\\": \\\"None\\\" },{ \\\"id\\\": \\\"5002\\\", \\\"type\\\": \\\"Glazed\\\" },{ \\\"id\\\":\\\"5005\\\", \\\"type\\\": \\\"Sugar\\\" },{ \\\"id\\\": \\\"5003\\\", \\\"type\\\": \\\"Chocolate\\\" },{ \\\"id\\\": \\\"5004\\\", \\\"type\\\": \\\"Maple\\\" }]},{\\\"id\\\": \\\"0003\\\",\\\"type\\\": \\\"donut\\\",\\\"name\\\": \\\"Old Fashioned\\\",\\\"ppu\\\": 0.55,\\\"batters\\\":{\\\"batter\\\":[{ \\\"id\\\": \\\"1001\\\", \\\"type\\\": \\\"Regular\\\" },{ \\\"id\\\": \\\"1002\\\", \\\"type\\\": \\\"Chocolate\\\" }]},\\\"topping\\\":[{ \\\"id\\\": \\\"5001\\\", \\\"type\\\": \\\"None\\\" },{ \\\"id\\\": \\\"5002\\\", \\\"type\\\": \\\"Glazed\\\" },{ \\\"id\\\":\\\"5003\\\", \\\"type\\\": \\\"Chocolate\\\" },{ \\\"id\\\": \\\"5004\\\", \\\"type\\\": \\\"Maple\\\" }]}";
	}

}
