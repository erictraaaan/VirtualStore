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
 * Description:  This is the Readalbe class.  It extends the Item class. 
 */

public class Readable extends Item{
	protected String author;
	@Override
	public void setinfo(String[] info) {
		super.setinfo(info);
		author = info[2];
	}
	@Override
	public String getInfo() {
		return String.format("%-10s%-25s%-15s%-30s%-25s%-25s", sNo, name, author , price, quantity,type);
	}
	@Override
	public double setPrice(double newprice) {return newprice;}
	@Override
	public double getPrice() {return price;}
	
	public Readable buyAReadable (Readable userBought , Readable storeItem , int quantity){
		userBought.sNo = storeItem.sNo;
		userBought.name = storeItem.name;
		userBought.author = storeItem.author;
		userBought.price = storeItem.price;
		userBought.quantity = quantity;
		userBought.type = storeItem.type;
		return userBought;
	}
	
}
