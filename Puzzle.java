
public class Puzzle {

    private int[] privateKey;
    private int[] riddle;

    public Puzzle(int[] privateKey, int[] riddle){
        this.privateKey = privateKey;
        this.riddle = riddle;
    }

    public Puzzle(Puzzle o){
        int [] oRiddle = o.getRiddle();
        int [] oPrivateKey = o.getPrivateKey();
        privateKey = new int[oPrivateKey.length];
        riddle = new int[oRiddle.length];
        for (int i = 0; i < oPrivateKey.length; i++){
            privateKey[i] = oPrivateKey[i];
        }
        for (int i = 0; i < oRiddle.length; i++){
            riddle[i] = oRiddle[i];
        }
    }

    public int[] getPrivateKey(){
        return privateKey;
    }

    public int[] getRiddle() {
        return riddle;
    }
    public static void swap(int [] arr,int i,int j){
    	int temp=arr[i];
    	arr[i]=arr[j];
    	arr[j]=temp;
    }
    public static void RandomeShuffle(int [] arr){
    	int b;
    	for(int i=0;i<arr.length-1;i++){
    		 b=i+(int)(Math.random()*(arr.length-i));
    		 swap(arr,i,b);
    	}
    }
    public static String numToBinary(int num){
    	String ans="";
    	while(num>0){
    		if(num%2==0)
    			ans=0+ans;
    		else
    			ans=1+ans;
    		num=num/2;
    	}
    	return ans;
    }
    public static int BinaryToXOR(String num){
    	int counter=0;
    	for(int i=0;i<num.length();i++){
    		if(num.charAt(i)=='1')
    			counter++;
    	}
    	if(counter%2!=0)
    		return 1;
    	else
    		return 0;
    }
    public static void sort(int[] arr){
    	int n=arr.length;
    	int [] ans=new int[n];
    	for(int i=0;i<n;i++)
    			ans[arr[i]/(n*n*n)]=arr[i];
    	for(int i=0;i<n;i++)
    		arr[i]=ans[i];
    }
}
