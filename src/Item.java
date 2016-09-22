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
 * Description:  This is the item class it defines what the item is. 
 */

public abstract class Item {
	public abstract String getInfo(); //this will display all the information
	public abstract double setPrice(double newprice); //method to set the price
	public abstract double getPrice(); // method to get the price
	protected String type; // type of item
	protected String name; // name of the item
	protected double price; //initial price of the item
	protected int sNo; //serial number of the item
	protected int quantity; //quantity of the item
	public void setinfo(String[] info){ //takes in a string array and set the variables to specific indexes of the array
		sNo = Integer.parseInt(info[0]);//takes the first index of the array sets equal to serial Number
		name = info[1];//takes the second index of the array sets equal to name
		price = Integer.parseInt(info[3]);//takes the 4th index of the array sets equal to price
		quantity = Integer.parseInt(info[4]);//takes the 5th index of the array sets equal to quantity
	}
	public void changeQuantity (int change){ //method used to changed the quantity of an item in stock
		quantity = quantity - change;// this subtracts the quantity in stock depending on how much you want to take away
	}
	
	public void addQuantity (int change){//method used to add stock to the quantity of an item
		quantity = quantity + change;//This adds to the quantity in stock increasing the quantity.
	}
	
	public void setQuantity (int change){ //changes the quantity of the item that user is buying
		quantity = change;// This allows us to change the quantity of the item bought to anything we want. 
	}
}