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
 * Description:  This is the CD class. it extends the audio class. 
 */

public class CD extends Audio{
	@Override// we are overriding the method of setInfo found in the "Audio" class.
	public void setinfo(String[] info) {// This method will set the price and type of our CDs
		super.setinfo(info);//getting the info about the item from the supper class
		price = setPrice(Integer.parseInt(info[3]));//setting the price of the CD to the forth index of the array
		type = "CD";//Setting the type of the CDs to "CD"
	}	
	@Override//overriding the method of set Price found in the "Audio" class.
	public double setPrice(double newprice) {//this will return the new price once accounting for an environmental tax
		return newprice * 1.02;//we return the price accounting for the environmental tax
	}
}