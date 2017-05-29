

public class Comparable {

	String data;
	String key;
	
	
	
	public Comparable(String r,String k){
		data=r;
		key=k;
		
	}
	
	public int compareTo(String t){
		if(data.compareTo(t)>0)
			return 1;
		else if(data.compareTo(t)<0)
			return -1;
		else
			return 0;
		
	}
	
}
