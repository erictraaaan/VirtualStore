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
 * Description:  This is the Shopping Cart class.  It extends the User class. 
 */

import java.util.ArrayList;//Importing ArrayList so that we can work with ArrayList in the Class

public class ShoppingCart extends User {//A new Class Shopping cart is created so that we can store the items we want to buy, is a subclass of users. 
    protected ArrayList <Item> content = new ArrayList<Item>(); // intializing a new ArrayList "content", this is what our cart. 
	
	public void addItem (Item newItem){// This method gives us the ability to add things to our cart.
		content.add(newItem);//we use the add function to add items to our Array List. 
	}
}
