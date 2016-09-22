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
 * Description:  This is the book class.  It extends the readable class. 
 */

public class Book extends Readable{//A new Class is created that is a subclass of Readable
	@Override// we are overriding the method of setInfo found in the "Readable" class.
	public void setinfo(String[] info) {//taking in the array argument info
		super.setinfo(info);//getting the info about the item from the super class
		price = setPrice(Integer.parseInt(info[3]));//setting the price of the Book to the 4th index of the array
		type = "Book";//Setting the type of the Book to "Book"
	}	
	@Override//overriding the method of set Price found in the "Readable" class.
	public double setPrice(double newprice) {//this will return the new price once accounting for an environmental tax
		return newprice * 1.02;//we return the price accounting for the environmental tax
	}
}