
/**
 * Created by tomercoh on 16/04/2016.
 */
public class Eve {
	
	//Add Fields if needed

    public Eve(){}

    public Pair<String, Integer> findKey(String index, Puzzle[] puzzles){
    	boolean found=false;
    	int counter=0;
    	Pair<String, String>temp=new Pair<String, String>("","");
    	for(int i=0;i<puzzles.length&&!found;i++){
    		temp=solvePuzzle(puzzles[i]);
    		if(!(index.compareTo(temp.getKey())==0))
    			counter++;
    		else{
    			counter++;
    			found=true;

    		}
    	}
		return new Pair<String, Integer>(temp.getValue(),new Integer(counter));	
    }

    public Pair<String, String> solvePuzzle(Puzzle puz){
    	String r="";
    	String k="";
    	int[]tempk=puz.getPrivateKey();
    	int[]tempr=puz.getRiddle();
    	Puzzle.sort(tempr);
    	Puzzle.sort(tempk);
    	for(int i=0;i<tempk.length;i++){
    		r=Puzzle.BinaryToXOR(Puzzle.numToBinary(tempr[i]))+r;
    		k=Puzzle.BinaryToXOR(Puzzle.numToBinary(tempk[i]))+k;
    	}
    	return new Pair<String, String>(r,k);
    }
    

}
