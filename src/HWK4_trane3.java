/*
 * Name: Eric Tran, Robbie Smith, Dillon Mulcahy
 * MacID:
 * Eric - trane3
 * Robbie - smithrm3 
 * Dillon - mulcahdj
 * Student Numbers:
 * Eric - 1424660
 * Robbie - 1415496
 * Dillon - 1329995
 * Description:  This is the main file.  All it does it creates a new instance of the user interface. 
 */

public class HWK4_trane3 {
	public static void main(String[] args) {
		UserInterface start = new UserInterface();//Creating a new UserInterface
		start.changeCurrentPage(1);//sets the current page to 1.  This is not used for page navigation.  see comments for the currentPage int in the UserInterface.java file
		start.P1();//Starts the program on page 1
	}
}