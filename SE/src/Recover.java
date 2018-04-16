import java.util.ArrayList;
import java.util.Scanner;

public class Recover {
	
	static ArrayList<TreeNode> copy = new ArrayList<>();
	
	public class TreeNode {
		  int stateID;
		  ArrayList<TreeNode> children;
		  TreeNode(int id) { stateID = id; }
	}
	
	interface Action {
        TreeNode goNext();
    }

    private ArrayList<Action> functions;
    // need some default value here

    public TreeNode goNext(int index) {
        return functions.get(index).goNext();
    }

	public void goForward(TreeNode current, int instruction) {
		// based on the instruction, call the right function on current state
		TreeNode next = goNext(instruction);
		
		// store the new state to the copy list
		copy.add(next);
	}
	
	public void process(int processID, TreeNode current){
		  // id = 1 -> go forward to the next state
		if(processID == 1){
			// accept instruction index here
			Scanner scan = new Scanner(System.in);
			int index = scan.nextInt();
			goForward(current, index);
		}
		  // id = 2 -> backup
		else if(processID == 2){
			backup(args);
		}
		  // id = 3 -> should go back to the previous state
		else if(processID == 3){
		    goBack(args);
		}
	}

	public static void main(){
	  // first initialize all the arguments
	  boolean switchON = true;

	  while(switchON){
	    // call the process function;
	    process(args);
	    // update arguments here
	  }
	}
}