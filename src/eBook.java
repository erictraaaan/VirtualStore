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
 * Description:  This is the eBook class.  It extends the readable class. 
 */

public class eBook extends Readable {// A new class ebook is created that extends Readables
	@Override//Over riding the super class readable 
	public void setinfo(String[] info) {//taking in the array argument info
		super.setinfo(info);//getting the info about the item from the super class
		type = "eBook";// Changing the "type" to eBook
	}
	@Override//We are overriding the superclass readable
	public double getPrice() { //technically we don't need this here, since we're not changing the price
		//it can use the parent's price function.  There's no point in putting this here. but it's in the 
		//instructions
		return super.getPrice();//returns the super class value for price. 
	}
}
