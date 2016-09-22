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
 * Description:  This is the MP3 class.  It extends the audio class. 
 */

public class MP3 extends Audio { // //New class MP3 is created - is a subclass of Audio
	@Override//We are overriding the setinfo method 
	public void setinfo(String[] info) {//This method will allow us to personalize the type of our MP3's
		super.setinfo(info);// call the info from the super class Audio
		type = "MP3";//We change the type to MP3
	}
	
	@Override // over riding the method getPrice from "Audio" class
	public double getPrice() { //technically we don't need this here, since we're not changing the price
		//it can use the parent's price function.  There's no point in putting this here. but it's in the 
		//instructions
		return super.getPrice();// returns the price
	}
}