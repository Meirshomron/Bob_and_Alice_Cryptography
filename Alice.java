


public class Alice {

    private Puzzle [] puzzlesArray;
    private AVLTree t=new AVLTree();

    public Alice(){
    }
    
    public Puzzle[] getPuzzlesCopy(){
        Puzzle[] puzzlesCopy = new Puzzle[puzzlesArray.length];
        for(int i = 0; i < puzzlesArray.length; i++){
            puzzlesCopy[i] = new Puzzle(puzzlesArray[i]);
        }
        return puzzlesCopy;
    }
    /*create new puzzles and store them in our array and in our avl tree*/
    public void createPuzzles(int n, int k){
    	puzzlesArray=new Puzzle[k];
    	/*go over all puzzles*/
    	for(int i=0;i<k;i++){ 
    		int[]key=new int[n];
    		int[]riddle=new int[n];
    		int random4Key;
    		int random4Riddle;
    		String sk="";
    		String sr="";
    		/*for every puzzles create a key and a riddle*/
        	for(int j=0;j<n;j++){ 
        		int s=n*n*n*j;
        		random4Key=s+(int)(Math.random()*n);
        		random4Riddle=s+(int)(Math.random()*n);
				key[j]=random4Key;
				riddle[j]=random4Riddle;
				sr=Puzzle.BinaryToXOR(Puzzle.numToBinary(riddle[j]))+sr;
				sk=Puzzle.BinaryToXOR(Puzzle.numToBinary(key[j]))+sk;
			}
        	Comparable data=new Comparable(sr,sk);
        	/*see of the puzzle that was created already exists*/
			int wehaverepeat=0;
        	if(t.search(data)==true){
            		i--;
            		wehaverepeat=1;
            		}
        	//	}
        	if(wehaverepeat==0){

        	t.insert(data);
        	Puzzle.RandomeShuffle(key);
        	Puzzle.RandomeShuffle(riddle);
    		puzzlesArray[i]=new Puzzle(key,riddle);	
        	}
       	}
    }
    /*given a riddle we must find its key,by searching for the riddle in our avl tree*/
    public Pair<String, Integer> findKey(String sIndex){
    	String key="";
    	Pair<int[], Integer> a=t.getPrivateKey(sIndex);
    	int[]keyarr=a.getKey();
    	Integer count=a.getValue();
    	for(int i=0;i<keyarr.length;i++)
    	key=keyarr[i]+key;	
    	
    	return new Pair<String, Integer>(key,count) ;
    }

}
