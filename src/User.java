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
 * Description:  This is the User class.  It defines the properties of the user. 
 */

public class User { //A new Class "User" is created
	private String username;// The Variable username is created, this is how our customers will be represented in the program
	
	String getUsername(){return username;}//this getter will allow us to access our usernames
	
	public void setUsername(String name){//This setter will allow us to set add new users.
		this.username = name; // setting the naem given to the username 
	}
}
