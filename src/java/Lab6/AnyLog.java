package Lab6;
import java.util.ArrayList;


public class AnyLog {
	ArrayList<String> arr = new ArrayList<String>();
	
	void addElementLog(String s){
		arr.add(s);
		
	}
	
	public static String printLog(ArrayList<String> arr)
	{
	    String str = "";    
	    for(String s : arr){
	        str += s + " ";
	    }
	    return str;
	}
	
}
