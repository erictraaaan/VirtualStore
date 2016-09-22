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
 * Description:  This is the audio class.  It extends the item class. 
 */

public class Audio extends Item{//New class Audio is created - is a subclass of Item
	protected String artistName;//initialized the protected variable artist name.
	@Override//we are overriding the method of setInfo found in the "item" class.
	public void setinfo(String[] info) {//taking in the array argument info
		super.setinfo(info);//getting the info about the item from the super class
		artistName = info[2]; // setting the second index of the array to the variable ArtistName
	}

	@Override// over riding the method getInfo from "Item" class
	public String getInfo() {// creates a new method getInfo 
		return String.format("%-10s%-25s%-15s%-30s%-25s%-25s", sNo, name, artistName , price, quantity,type);//returns all the information (in formated columns) 
	}
	
	@Override// over riding the method setPrice from "Item" class
	public double setPrice(double newprice) {return newprice;}// over riding the method setPrice from "Item" class
	@Override// over riding the method getPrice from "Item" class
	public double getPrice() {return price;}// Creates the getter getPrice method for Audio Class.
	
	public Audio buyAnAudio (Audio userBought , Audio storeItem , int quantity){//this method allows users to buy items. Takes in the parameters of (WHAT IS USERBOUGHT), the item and the quantity of that Item. 
		userBought.sNo = storeItem.sNo;//We are transferring the store's sNo to the userBought 
		userBought.name = storeItem.name;//We are transferring the store's name to the userBought 
		userBought.artistName = storeItem.artistName;//We are transferring the store's artist Name to the userBought 
		userBought.price = storeItem.price;//We are transferring the store's price to the userBought 
		userBought.quantity = quantity;//We are transferring the store's quantity to the userBought 
		userBought.type = storeItem.type;//We are transferring the stores type to the userBought 
		return userBought;//We are returning what the userBought 
	}
	
}