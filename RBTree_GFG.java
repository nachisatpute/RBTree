
package visem;

//Java program to find position of root node in inorder
//  traversal of RBTree which consist color of node instead of data.
import java.util.ArrayList;
import java.util.Scanner;

public class RBTree_GFG {
    static int RootNode(int n, char[] inorder, char[] preorder, char[] postorder){
        ArrayList<Integer> arr=new ArrayList<>();
        int root;
        int post_R=0, post_B=0;  //No. of black and red node in postorder
        int pre_R=0, pre_B=0;    //No. of black and red node in preorder
        int in_R=0, in_B=0;      //No. of black and red node in inorder
        int p=0;
        for( int i=0; i<n-2; i++ ){
            if(preorder[i+1] == postorder[i]){
                if(postorder[i] == 'R'){
                    post_R++;
                    pre_R++;          
                }
                else{
                    post_B++;
                    pre_B++; 
                }
            }
            else{
                if( postorder[i] == 'B' && preorder[i+1] == 'R'){
                    post_B++;
                    pre_R++;
                }
                else{
                    post_R++;
                    pre_B++;
                }
            }
            
            if( post_B == pre_B && post_R == pre_R && post_B != 0){
                for( int j=p; j<=i; j++){
                    if( inorder[j] == 'B' )
                        in_B++;
                    else
                        in_R++;
                }
                p=i+1;
                if( in_B == post_B && in_R == post_R && in_B != 0){
                  
                    if( inorder[i+1] == 'B' && preorder[i+2] == postorder[n-2] ){
                       
                        arr.add(i+2);                                                                      
                    }                    
                }                
            }           
        }
        if( arr.size() == 1 )
            root = arr.get(0);
       else
            root = arr.get(arr.size()-2);
        
       return root;        
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter No of Nodes: ");
        n = sc.nextInt(); //Take No of Node input
        char[] inorder = new char[n];
        char[] preorder = new char[n];
        char[] postorder = new char[n];
        
        System.out.println("Enter Inorder Traversal: ");  
        for(int i=0; i<n; i++)
            inorder[i] = sc.next().charAt(0);  //Take color code input in inorder
        
        System.out.println("Enter Preorder Traversal: ");
        for(int i=0; i<n; i++)
            preorder[i] = sc.next().charAt(0);  //Take color code input in inorder
        
        System.out.println("Enter Postorder Traversal: ");
        for(int i=0;i<n;i++)
            postorder[i] = sc.next().charAt(0);  //Take color code input in inorder
        
        int root=RootNode(n, inorder, preorder, postorder);
              
        System.out.println("Position of Root in Inorder is " + root);
        
       
    }
}
