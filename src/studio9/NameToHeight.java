package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	

	
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<String,Integer> nameToHeight = new HashMap<>();
		nameToHeight.put("Will",1000);
		nameToHeight.put("Zachary", 1);
		nameToHeight.put("Nidhi", 64);
		String search = null;
		boolean quit=false;
		
		while(!quit) {
			System.out.println("search for a name");
			search=in.next();
			if(search.equals("quit")) {
				quit=true;
			}

			boolean contain = false;
			for(int i=0;i<nameToHeight.keySet().size();i++) {
				if(nameToHeight.keySet().contains(search)) {
					contain = true;
				}else {
					contain=false;
				}
			}
			if(contain) {
			System.out.println(search + ": " + nameToHeight.get(search));
			} else {
				System.out.println("invalid name");
			}
					}
		
		
	}
}
