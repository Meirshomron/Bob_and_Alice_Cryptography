
import java.io.PrintWriter;

/* Class AVLTree */
class AVLTree
{
    private AVLNode root;

    /* Constructor */
    public AVLTree()
    {
    	root=null;
    }
    /*helper functions*/
    public AVLNode getRoot(){
    	return root;
    }
    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
    	return root==null;   
    }
    /* Make the tree logically empty */
    public void makeEmpty()
    {
    	root=null;    
    }
    /* Function to insert data */
    public void insert(Comparable data)
    {
    	root=insert(data,root);
    }
    /* Function to get height of node */
    private int height(AVLNode t )
    {
    	if(t==null)
    		return -1;
    	return t.height;
    }
    /* Function to max of left/right node */
    private int max(int lhs, int rhs)
    {
    	if(lhs>rhs)
    		return lhs;
    	else
    		return rhs;
    }
    /* Function to insert data recursively */
    private AVLNode insert(Comparable x, AVLNode t)
    {
    	
    	if(t==null){
    		t=new AVLNode(x);
    }
    	 else if( x.data.compareTo( t.data.data ) < 0 )
         {
             t.left = insert( x, t.left );
             if( height( t.left ) - height( t.right ) == 2 )
                 if( x.data.compareTo( t.left.data.data ) < 0 )
                     t = rotateWithLeftChild( t );
                 else
                     t = doubleWithLeftChild( t );
         }
         else if( x.data.compareTo( t.data.data ) > 0 )
         {
             t.right = insert( x, t.right );
             if( height( t.right ) - height( t.left ) == 2 )
                 if( x.data.compareTo( t.right.data.data ) > 0 )
                     t = rotateWithRightChild( t );
                 else
                     t = doubleWithRightChild( t );
         }
         else
            
         t.height = max( height( t.left ), height( t.right ) ) + 1;
         return t;
    	
    }
    /* Rotate binary tree node with left child */
    private AVLNode rotateWithLeftChild(AVLNode k2)
    {
    	 AVLNode newTop = k2.left;
         k2.left = newTop.right;
         newTop.right = k2;
         newTop.height = max( height( newTop.left ), k2.height ) + 1;
         k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
         return newTop;
    }

    /* Rotate binary tree node with right child */
    private AVLNode rotateWithRightChild(AVLNode k1)
    {
    	AVLNode newTop = k1.right;
        k1.right = newTop.left;
        newTop.left = k1;
        newTop.height = max( height( newTop.right ), k1.height ) + 1;
        k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
        return newTop;    }
    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child */
    private AVLNode doubleWithLeftChild(AVLNode k3)
    {
        k3.left = rotateWithRightChild( k3.left );
        return rotateWithLeftChild( k3 );    
        }
    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child */
    private AVLNode doubleWithRightChild(AVLNode k1)
    {
    	k1.right = rotateWithLeftChild( k1.right );
        return rotateWithRightChild( k1 );    }
    /* Functions to count number of nodes */
    public int countNodes()
    {
        return countNodes(root);
    }
    /* Function to count number of nodes recursively */
    private int countNodes(AVLNode r)
    {
        if (r == null)
            return 0;
        else
        {
            int num = 1;
           num=num + countNodes(r.left);
           num=num + countNodes(r.right);
            return num;    
        }}
    /* Functions to search for an element */
    public boolean search(Comparable val)
    {
    	return search(root,val);
		}
    /* Function to search for an element recursively */
    private boolean search(AVLNode r, Comparable val)
    {
    	   boolean found = false;
           while ((r != null) && !found)
           { 
               if (val.data.compareTo(r.data.data) < 0)
                   r = r.left;
               else if (val.data.compareTo(r.data.data)>0)
                   r = r.right;
               else    
                   found = true;
          }
           return found;
    }
    /* Function for inorder traversal */
    public void inorder(PrintWriter out)
    {
        inorder(root,out);
    }
    /* Function for inorder traversal recursively */
    private void inorder(AVLNode r, PrintWriter out)
    {
    	  if (r != null)
          {
              inorder(r.left,out);
              System.out.print(r.data +" ");
              inorder(r.right,out);
          }}
    /* Function to return the key that belongs to the riddle we received */
    public Pair<int[],Integer> getPrivateKey(String sIndex) {
    	return getPrivateKey(root,sIndex);
		}
    /* Function to return the key that belongs to the riddle we received recursively */
    private Pair<int[],Integer> getPrivateKey (AVLNode r, String sIndex) {
    	int counter=0;
    	int[]ans=new int[sIndex.length()];
    	boolean found=false;
    	while(r!=null&&!found){
    		if(r.data.data.compareTo(sIndex)>0){
    			r=r.left;
    			counter++;
    		}
    		else if(r.data.data.compareTo(sIndex)<0){
    			r=r.right;
    			counter++;    
    		}
    		else{
    			/* we have found the matching key and now 
    	       	we must convert it from a string to an array */
    			counter++;
    			for(int i=0;i<sIndex.length();i++){
    				ans[sIndex.length()-1-i]=(r.data.key).charAt(i)-'0';
    				 
    				found=true;
    			}
    		}
    	}
		return new Pair<int[],Integer>(ans,new Integer(counter));
    }
}
