

public class Bob {

    //Add Fields if needed

    public Bob(){
        //Complete Your Code Here
    }
    /* Function to randomly select a puzzle and solve it */
    public Pair<String, String> choosePuzzle(Puzzle[] puzzles){
    	int a=(int)(Math.random()*(puzzles.length));
    return solvePuzzle(puzzles[a]);
    
    
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
