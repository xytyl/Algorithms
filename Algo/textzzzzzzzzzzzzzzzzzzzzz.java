package altext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;

public class textzzzzzzzzzzzzzzzzzzzzz {
	
    public static void main(String[] args) {
    	File file = new File("F:/","amino.csv");
    	BufferedReader reader =null;
    	LinearProbingHashST
    	<String, String> st = new LinearProbingHashST<String,String>();
    	try {
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line=reader.readLine())!=null){
				String[] tokens = line.split(",");
				String key = tokens[0];
				String val = tokens[3];
				st.put(key, val);
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	while(!StdIn.isEmpty()){
    		String query = StdIn.readString();
    		StdOut.println(st.get(query));
    	}
    }
}

