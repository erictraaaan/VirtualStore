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
 * Description:  This is the user inteface.  This is where most of the program is written.  
 ********************************************************************************************** 
 * NOTE: THIS PROGRAM CONTAINS THE FIRST EXTRA CREDIT - all the items are purchased and stored in ItemsBought.txt
 * For the second extra credit - not all of the required functions of the ADMIN were completed.  All the ADMIN can do is not allow duplicate
 * usernames.  For the ADMIN to function, it must be implemented in the FIRST line of the Users.txt file,
 * in the following format:
 * 
 * EG. Users.txt
 * ADMIN,ADMIN
 * White
 * Brown
 * Eric
 * 
 * Although the ADMIN doesn't complete everything that it should, we're hoping to get a few marks for what we worked very hard on.
 * 
 * ALSO NOTE: As mentioned later in the comments, the int currentPage and methods getCurrentPage and changeCurrentPage, although are present
 * in the code, are not used for anything.  We talked this over with Dr Bonakdarpour and he said that it's okay that are program navigates
 * through the user interface in the way that we set it up.  The only reason we still have it included in our code is because of a post on 
 * piazza where a TA mentioned that the functions in the instructions MUST be included in our code.
 */

import java.util.Scanner;// library that allows us to use scanner 
import java.io.File;// Importing the File 
import java.io.BufferedReader;// imports the BufferReader library that allows us the reading of characters, arrays, and lines.
import java.io.BufferedWriter;// imports the BufferWriter library that allows us the writing of characters,arrays and lines. 
import java.io.FileReader; // imports the FileReader library that allows us the reading of characters from a file. 
import java.io.FileWriter;// imports the BufferReader library that allows us the writing of characters to a file.
import java.io.IOException;// Imports the IOException library, this allows us to handle exceptions produced by failed or interrupted I/O operations
import java.math.RoundingMode;// Imports the RoundingMode library, Allows us to round numbers
import java.text.DateFormat;// Imports DateFormat library, for date/time formatting
import java.text.DecimalFormat;// Imports DecimalFormat, make it possible to parse and format numbers
import java.text.SimpleDateFormat;// Imports SimpleDateFormat library, It allows for formatting , parsing, and normalization
import java.util.ArrayList;// Imports ArrayList Library, Allows us to use arrayList
import java.util.Arrays;// Imports Array Library, Allows us to use arrays
import java.util.Date;// Imports Date Library, Allows us to represents a specific instant in time,.

public class UserInterface { //creates the public class UserInterface
    
    static void pagesep(){System.out.println("****************************************************");}// prints a line of asterix to keep current and previous separated
	
	public static ArrayList <String[]> readfile(String fileName){ //TAKES A TEXT FILE INTO AN ARRAY
		try {
	        BufferedReader in = new BufferedReader(new FileReader(fileName)); //creates a new instance of buffered reader
	        String str; // Initializes a empty string array 
	        ArrayList <String[]> MasterBookList = new ArrayList <String[]> ();// creates an arrayList MasterBookList (currently Empty)
	        while ((str = in.readLine()) != null) {// while loop is initialized, will run as long as the line it reads isn't empty.
	            String[] bookArray=str.split(",");// takes the current line splits it at the "," and places it in the array bookArray
	            for (int i = 0; i < bookArray.length; i++)// This for loop will trim the white space in the book array
	            	bookArray[i] = bookArray[i].trim();// the trimmed string replaces the old untrimmed string
	            MasterBookList.add(bookArray);//Add the Array to the list of arrays MasterBookList
	        }
	        in.close();//Closes the File
	        return MasterBookList;//returns ArrayList MasterBookList - this has all the information
	        }
		catch (IOException e) { //exception catcher
	        System.out.println(e); //prints the error message
	        return null; //will return null
	    }	
	}
	
	public ArrayList <Item> getReadables (String product1 , String product2){ //generates the products lists
		ArrayList <Item> productList = new ArrayList <Item>();//creates the empty Arrays list
		ArrayList <String[]> product1List = readfile(product1);//reads the file of the type of produce(ie, book or eBook), 
		ArrayList <String[]> product2List = readfile(product2);//reads the file of the type of produce(ie, book or eBook),
		
		for (int i = 0 ; i < product1List.size() ; i ++){ //This is for all the books
			Book myBook = new Book();//creates a new variable myBook
			myBook.setinfo(product1List.get(i));//uses the method setinfo defined in Book class to change the type and price of book
			productList.add(myBook);//Adds this new information to the product Arraylist
		}
		for (int i = 0 ; i < product2List.size() ; i ++){ //This is for all the eBooks
			eBook myeBook = new eBook();//creates a new variable myeBook
			myeBook.setinfo(product2List.get(i));//uses the method setinfo defined in eBook class to change the type and price of ebook
			productList.add(myeBook);//Adds this new information to the product Arraylist		
		}
		return productList;//The getReadables function sends this arrayList when called.
	}
	
	public ArrayList <Item> getAudioProducts (String product1 , String product2){ //generates the products lists
		ArrayList <Item> productList = new ArrayList <Item>();//New product arrayList is created to hold all the information about AudioProducts (currently empty)
		ArrayList <String[]> product1List = readfile(product1);//Reads the Product1 file (ie MP3 or CD), stores info to an arrayList
		ArrayList <String[]> product2List = readfile(product2);//Reads the Product1 file (ie MP3 or CD), stores info to an arrayList  
		
		for (int i = 0 ; i < product1List.size() ; i ++){ //This is for all the CDs
			CD myCD = new CD();//creates a new variable myCD
			myCD.setinfo(product1List.get(i));//uses the method setinfo defined in CD class to change the type and price of CDs
			productList.add(myCD);//Appends this new info to the ArrayList
		}
		for (int i = 0 ; i < product2List.size() ; i ++){ //This is for all the MP3s
			MP3 myMP3 = new MP3();//creates a new variable myCD
			myMP3.setinfo(product2List.get(i));//uses the method setinfo defined in MP3 class to change the type and price of MP3
			productList.add(myMP3);//Appends this new info to the ArrayList		
		}
		return productList;////The getAudioProduct function sends this arrayList when called.
	}
	
	public int showReadables (ArrayList<Item> readables){//Defining a method that will out put our information about our readables
		int readableItemCounter = 0;// Initializes the readable item counter and sets it equal to zero
		System.out.println(String.format("%-10s%-10s%-25s%-15s%-30s%-25s%-25s", "#", // this is the spacing used to create the columns in which our data is formated, as well as the titles of each colomn
				"S.No", "Name of Book", "Author" , "Price (+ env. tax.) ($)", "Quantity in Store","Type"));// The "%" are the variables defined in the subsequent indexes of the list
		for (Item i : readables){// a for loop that will print out all the information under our titles. 
			readableItemCounter ++;// Add one to the counter to start looking at the first item
			System.out.print(String.format("%-10s",readableItemCounter));//prints the item number
			System.out.println(i.getInfo());//All the information about the product is printed out
		}
		return readableItemCounter;// the readable item counter is returned
	}
	
	public int showAudioProducts (ArrayList <Item> audioproducts){//Defining a method that will out put our information about our AudioProducts
		int audioItemCounter = 0;// Initializes the Audio Products item counter and sets it equal to zero 
		System.out.println(String.format("%-10s%-10s%-25s%-15s%-30s%-25s%-25s", "#",// this is the spacing used to create the columns in which our data is formated, as well as the titles of each column
				"S.No", "Name of Book", "Arist Name" , "Price (+ env. tax.) ($)", "Quantity in Store","Type"));// The "%" are the variables defined in the subsequent indexes of the list
		for (Item i : audioproducts){ // a for loop that will print out all the information under our titles.
			audioItemCounter ++;//Add one to the counter to start looking at the first item and all the rest
			System.out.print(String.format("%-10s",audioItemCounter));// prints the item number
			System.out.println(i.getInfo());//All the information about the product is printed out of 
		}
		return audioItemCounter;// the Audio item counter is returned
	}
	
	public boolean CartChecker (String itemName , ArrayList <Item> Cart){//this Checks all the indexes in the arrayList to see if if we already have somethig in our cart
		for ( int i = 0 ; i < Cart.size() ; i ++){ //for loop that goes thru each index of the Arraylist of our cart 
			if (itemName == Cart.get(i).name){// checks to see if the item we are looking for is in the cart
				return false;//if it is it returns false.
			}
		}
		return true;//if not it returns true.
	}
		
	public ArrayList<String> getUsers(String userFileName){// This is used to read our user file
	ArrayList <String> userList = new ArrayList <String> ();//initializes our new user array list (currently empty)
    try {//We us a try/catch in order to make it more robust
        BufferedReader in = new BufferedReader(new FileReader(userFileName));//We open the file and store all of its character in the variable "in"
        String str;//Initialized the string string, currently empty
        while ((str = in.readLine()) != null) { //While the "in" variable is not empty the code will exectute. 
            userList.add(str);// Characters originally from "in" are stored in "str" and the appended to the UserList
        }
        in.close();//we close the file that we opened
        return userList;// return the Array list with the name of all our users.
    } 
    catch (IOException e) {//this helps handle any problems with Inputing/outputting to the file
        System.out.println(e);//prints the exception
    }
	return null;// this method doesn't return anything
	}
	
	public ArrayList<User> createUsers (ArrayList<String> usernames){//this will allow us to create new users in our system
		ArrayList<User> usernameList = new ArrayList<User>();//Initializes new arrayList that is empty
		for (String a : usernames){ //For loop that will add new users to our UsernameList
			User tempUser = new User();// Initializes the temp users
			tempUser.setUsername(a);//sets the tempUser's username to the value of "a"
			usernameList.add(tempUser);//the temperary username is added to the usernameList 
		}
		return usernameList;//This returns the list of users including the new ones
	}
	
	public void writeFileReadables (ArrayList<Item> itemList, String filename1, String filename2){//updates the readables text files
		try {
			File file1 = new File(filename1);//takes in the first filename
			File file2 = new File(filename2);//takes in the second filename

			// if file doesn't exists, then create it
			if (!file1.exists()||!file2.exists()) {
				file1.createNewFile();
				file2.createNewFile();
			}
			
			
			FileWriter fw1 = new FileWriter(file1.getAbsoluteFile());//opens a new filewriter
			FileWriter fw2 = new FileWriter(file2.getAbsoluteFile());//opens a new filewriter
			BufferedWriter bw1 = new BufferedWriter(fw1);//creates a new buffered reader
			BufferedWriter bw2 = new BufferedWriter(fw2);//creaters a new buffered reader
			for (int i=0; i < itemList.size();i++){//loops through the list of items
				if (itemList.get(i).type.equals("Book")){ //if the item is a book, write to books.txt
					Book hon = (Book) itemList.get(i);//gets the ith item in the list
					bw1.write(hon.sNo+", "+hon.name+", "+hon.author+", "+ (int) ((50.0/51.0)*hon.price)+", "+hon.quantity);//prints the required attributes, reversing the environmental tax on the price
					bw1.write("\n");
				}
				else if (itemList.get(i).type.equals("eBook")){//if the item is an ebook, write to eBooks.txt
					eBook ehon = (eBook) itemList.get(i);//gets the ith item in the list
					bw2.write(ehon.sNo+", "+ehon.name+", "+ehon.author+", "+ (int) ehon.price+", "+ehon.quantity);//prints the required attributes
					bw2.write("\n");
				}
			}

			bw1.close();//closes the buffered writer
			bw2.close();//closes the buffered writer

		} catch (IOException e) {//catches exception
			e.printStackTrace();//prints the exception
		}
	}
	
	public void writeFileAudio (ArrayList<Item> itemList, String filename1, String filename2){//updates the audios text files
		try {
			File file1 = new File(filename1);//takes in the first filename
			File file2 = new File(filename2);//takes in the second filename

			// if file doesn't exists, then create it
			if (!file1.exists()||!file2.exists()) {
				file1.createNewFile();
				file2.createNewFile();
			}

			FileWriter fw1 = new FileWriter(file1.getAbsoluteFile());//opens a new filewriter
			FileWriter fw2 = new FileWriter(file2.getAbsoluteFile());//opens a new filewriter
			BufferedWriter bw1 = new BufferedWriter(fw1);//creates a new buffered reader
			BufferedWriter bw2 = new BufferedWriter(fw2);//creates a new buffered reader
			for (int i=0; i < itemList.size();i++){//loops through the list of items
				if (itemList.get(i).type.equals("CD")){//if the item is a CD, write to CDs.txt
					CD hon = (CD) itemList.get(i);//get the ith item in the list
					bw1.write(hon.sNo+", "+hon.name+", "+hon.artistName+", "+ (int) ((50.0/51.0)*hon.price)+", "+hon.quantity);//writes the appropriate attributes, removing the environmental tax
					bw1.write("\n");	
				}
				else if (itemList.get(i).type.equals("MP3")){//if the item is an MP3, write to MP3.txt
					MP3 ehon = (MP3) itemList.get(i);// gets the ith item in the list
					bw2.write(ehon.sNo+", "+ehon.name+", "+ehon.artistName+", "+ (int) ehon.price+", "+ehon.quantity);//writes the required attributes to the file
					bw2.write("\n");
				}
			}

			bw1.close();//closes the buffered reader
			bw2.close();//closes the buffered reader

		} catch (IOException e) {//catches exception
			e.printStackTrace();//prints exception
		}
	}
	
	public void writeUserFile (ShoppingCart shoppingCart){//method to write the users shopping cart file
		try {
			String name = myUser.getUsername(); //creates a string of the users username
			File file = new File("Cart_"+ name +".txt");//creates a new file with the username

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file,false); //the false will overwrite the new data if data exists
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");//creates the proper date format
			Date date = new Date();//creates an object of class date with the current date
			for (int i=0; i < shoppingCart.content.size();i++){//loops through the items in the users shopping cart
					fw.write(shoppingCart.content.get(i).sNo+","+shoppingCart.content.get(i).name //prints the appropriate attributes into the shopping cart file
							+","+dateFormat.format(date)+","+shoppingCart.content.get(i).quantity);
					fw.write("\n");
			}

			fw.close();//closes the file writer

		} catch (IOException e) {//catches exception
			e.printStackTrace();//prints exception
		}
	}
	
	public void getTheCartBack (String username , ShoppingCart cart){//method to retreive the users previous shopping cart
		try {
			String name = myUser.getUsername(); //gets a string that is the users username
			File file = new File("Cart_"+ name +".txt");//gets the users shopping cart file
			if (!file.exists()) {
				return;
			}
			BufferedReader in = new BufferedReader(new FileReader("Cart_"+ name +".txt"));//creates a new buffered reader
			ArrayList<ArrayList<String>> cartItemHolder = new ArrayList<ArrayList<String>>();//creates an array of items
	        String str;
	        while ((str = in.readLine()) != null) {//reads each line in the file
	        	ArrayList<String> cartItem = new ArrayList<String>(Arrays.asList(str.split("\\s*,\\s*")));//grabs the attributes associated with each item in each line of the shopping cart
	        	cartItemHolder.add(cartItem);//adds it to the array
	        }
	        ArrayList<ArrayList<Integer>> cartItemInfo = new ArrayList<ArrayList<Integer>>();//creates a new array of arrays of integers
	        for (int i = 0 ; i < cartItemHolder.size() ; i++){//loops through each item in the item array
	        	ArrayList<Integer> bar = new ArrayList<Integer>();//creates a new array list of integers
	        	int itemSerialNum = Integer.parseInt(cartItemHolder.get(i).get(0));//0th number is the serial number of the item
	        	bar.add(itemSerialNum);//adds it to the list
	        	int itemQuantity = Integer.parseInt(cartItemHolder.get(i).get(3));//3rd item is the quantity of the item
	        	bar.add(itemQuantity);//adds it to the list
	        	cartItemInfo.add(bar);//adds the list to the cartItemInfo list
	        }
	        for (ArrayList<Integer> a : cartItemInfo){//loops through the arrays in cartItemInfo
	        	for (int i = 0 ; i < readableList.size() ; i ++){//loops through each item in the readablelist
	        		if (readableList.get(i).sNo == a.get(0)){//checks if the serial numbers match
	        			int quantity = a.get(1);
	        			Readable userItem = new Readable();//creates an item to add to the users shopping cart
						userItem.buyAReadable(userItem, (Readable) readableList.get(i), quantity);//gets the req'd attributes
						myShoppingCart.addItem(userItem);//adds it to the users shopping cart
						readableList.get(i).changeQuantity(quantity);//changes the stores quantity of the item
	        		}
	        	}
	        	for (int j = 0 ; j < audioList.size() ; j++  ){//loops through each item in audioList
	        		if (audioList.get(j).sNo == a.get(0)){//checks if the serial numbers match
	        			int quantity = a.get(1);
	        			Audio userItem = new Audio();//creates an item to add to the users shopping cart
						userItem.buyAnAudio(userItem, (Audio) audioList.get(j), quantity);//gets the req'd attributes
						myShoppingCart.addItem(userItem);//adds it to the users shopping cart
						audioList.get(j).changeQuantity(quantity);//changes the stores quantity of the item
	        		}
	        	}
	        }
	        
	        in.close();//closes the file reader

		} catch (IOException e) {//catches exception
			e.printStackTrace();//prints exception
		}
	}
	
	public void clearShoppingCartFile (ShoppingCart shoppingCart){//metho to clear the shopping cart file
		try {
			String name = myUser.getUsername(); //gets the username
			File file = new File("Cart_"+ name +".txt");//finds the users shopping cart text file

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file,false);//overwrites the file with a blank file

			fw.close();//closes the file writer

		} catch (IOException e) {//catches exception
			e.printStackTrace();//prints exception
		}
	}
	
	private int currentPage;//THIS IS REQUIRED IN THE INSTRUCTIONS.  We spoke with the instructor (Dr. Bonakdarpour).  We explained that
	//we don't use this method for page navigation, as we implemented it in a different way.  He said that this is okay since, as you will
	//see in our code, it works the same way.  We left the current page int in our code, although it isn't used for page navigation.
	
	public int getCurrentPage(){//RETURNS THE CURRENT PAGE.  not used in the program, but placed in the code as per the instructions.
		//refer to the comments for "currentPage" for more information.
		return currentPage;
	}
	
	public void changeCurrentPage(int change){//CHANGES THE CURRENT PAGE.  not used in the program for navgation, but place in the 
		//code as per the instructions.  Refer to the comments for "currentPage" for more information.
		currentPage = change;
	}
	
	private ArrayList<Item> readableList = getReadables("Books.txt","Ebooks.txt");//Creates the Array List for Readables,get readable pulls information for the listed .TxtFiles
	
	private ArrayList<Item> audioList = getAudioProducts("CDs.txt","MP3.txt");//Creates the Array List for audio,get readable pulls information for the listed .TxtFiles
	
	private User myUser = new User();//Initializes a new user
	
	private ShoppingCart myShoppingCart = new ShoppingCart();//Creates a new shopping cart
		
	protected ArrayList <String> userList = getUsers("Users.txt");// Stores all current usernames in an ArrayList
	protected ArrayList <User> allTheUsers = createUsers (userList);//Creates and arraylist storing all the users

	public void P1() { //FIRST PAGE
		myUser = new User(); //Refreshes the user , starts fresh!
		myShoppingCart = new ShoppingCart(); //Refreshes the shopping cart, starts fresh!
		pagesep(); //Start of new page
		Scanner user_input = new Scanner( System.in ); //P1 INPUT OPEN
		int P1_option; //holds the value that the user inputs
		userList = getUsers("Users.txt"); //refreshes the list of username strings, checks for new users
		allTheUsers = createUsers (userList); //refreshes the list of users in case there are new usernames
		
		System.out.println("1.Sign in \n2.Sign up \nChoose your option:"); //output prompt
	    P1_option = user_input.nextInt(); //waits for user input
	    
	    if (P1_option==1){ 
	    	changeCurrentPage(3);
	    	P3(); //Goes to sign in page
	    }
	    else if (P1_option==2){	
	    	changeCurrentPage(2);
	    	P2(); //Goes to sign up page	
	    }
	    else {
	    	System.out.println("Invalid Input. Please enter either 1 or 2."); 
	    	changeCurrentPage(1);
	    	P1(); //restarts the page if the user inputs something unexpected
	    }
	    user_input.close(); //P1 INPUT CLOSE
	}
	
	public void P2() { //SIGN UP PAGE
		pagesep(); // Start of new page
		
		Scanner user_input = new Scanner( System.in ); //P2 INPUT OPEN
		String newUser; //holds the username
		System.out.println("Choose your username:"); //prompt for user
	    newUser = user_input.nextLine(); //waits for user input
	    
	    boolean b = true; 
	    for (String a : userList){ //checks if the user's inputted name is in the user list
	    	if (a.equalsIgnoreCase(newUser))
	    		b = false; //changes b to false if the name already exists
	    }
	    
	    if (b){ //if b is true
	    	try{
		        String filename = "Users.txt"; //opens the users file
		        FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		        fw.write("\n"); //makes a new line to hold the new user
		        fw.write(newUser.substring(0,1).toUpperCase()+newUser.substring(1).toLowerCase());//appends the string to the file
		        fw.close(); //closes the file reader
		    }
		    catch(IOException ioe){
		        System.err.println("IOException: " + ioe.getMessage()); //IO Exception, end program
		    }
	    	System.out.println("Username successfully added");
	    	changeCurrentPage(1);
	    	P1(); //goes back to the first page
	    }
	    else { //If the username already exists within the file
	    	System.out.println("Username exists");
	    	changeCurrentPage(1);
	    	P1(); //goes back to the first page
	    }
	    user_input.close(); //P2 INPUT CLOSE
	}
		
	public void P3() { //SIGN IN PAGE
		pagesep(); //start of new page
		Scanner user_input = new Scanner( System.in ); //P3 INPUT OPEN
		String username; //holds the inputted username
		System.out.println("Enter your username:"); //user prompt
	    username = user_input.nextLine(); //waits for user input
	    
	    if (username.contains("ADMIN")){//Checks to see if the ADMIN is trying to sign in
	    	String password;//if they are we create a password string (currently empty)
	    	System.out.println("Enter the password: ");//prompts the user to enter the password
	    	password = user_input.nextLine();//takes in users password from the keyboard
	    	if (userList.get(0).contains(","+password)){//checks to see if the password entered matches the one in the userlist
	    		System.out.println("Correct Password");
	    		myUser.setUsername("ADMIN");//sets the current user to ADMIN
	    		myShoppingCart.setUsername("ADMIN");//sets the current shopping cart user to ADMIN.
	    		System.out.println("Hello ADMIN");
	    		adminP1(); //goes to the main admin menu
	    	}
	    	else{ //if the user inputted the incorrect password
	    		System.out.println("Incorrect Password.");
	    		changeCurrentPage(1);
	    		P1();//sends user back to the start page
	    	}
	    	
	    }
	        
	    boolean b = false;
	    for (String a : userList){ //checks if the input exists within the username list
	    	if (a.equalsIgnoreCase(username)){
	    		b = true; //sets b to true if the name exists 
	    	}
	    }
	    
		if (b){ //if b is true
			username = username.substring(0,1).toUpperCase() + username.substring(1).toLowerCase(); //changes the username to capitalize the first letter
			System.out.println("Hello " + username);// prints out a welcome greeting to the user
			for (int i = 0 ; i < allTheUsers.size() ; i ++){
				if (allTheUsers.get(i).getUsername().equals(username)){//finds the user corresponding to the inputted user
					myUser.setUsername(username);//Assigns this username to the current user
					myShoppingCart.setUsername(username);//Assigns this username to the shopping cart
					break;//breaks out of hte loop
				}
			}
			getTheCartBack(myUser.getUsername(), myShoppingCart);//checks the users shopping cart file, adds previous items in the shopping cart to the current shopping cart
			P5();//sends the user to the main menu
		}
		else{
			changeCurrentPage(4);
			P4();//sends user to the no access page
		}
		user_input.close(); //P3 INPUT CLOSE
	}
	
	public void P4() { //NO ACCESS PAGE
		pagesep();
		System.out.println("No access.  Returning to start page.");
		changeCurrentPage(1);
		P1();//returns to the start page
	}
	
	public void P5() { //MAIN SHOPPING PAGE
		pagesep();
		Scanner user_input = new Scanner( System.in ); //initializes a new scanner
		int P5_option;//variable to hold the users choice
		System.out.println("1.View Items By Category \n2.View Shopping Cart \n3.Sign Out \n4.View Previous Orders \n \nChoose your option:");//prompts the user on their available options

	    P5_option = user_input.nextInt();//this section decides what the program should do based on what the user inputs
	    if (P5_option==1){//view items
	    	changeCurrentPage(6);
	    	P6(); //sends to view items by category page
	    }
	    else if (P5_option==2){ //shopping cart
	    	changeCurrentPage(7);
	    	P7();//sends to shopping cart page
	    }
	    else if (P5_option==3){ //sign out
	    	myUser = null; //resets the user
	    	myShoppingCart = null; //resets the shopping cart
	    	changeCurrentPage(1);
	    	P1();//returns to the start page
	    }
	    else if (P5_option==4){ //view previous orders
	    	changeCurrentPage(11);
	    	P11();//goes to the previous orders page
	    }
	    else{//if the user inputted some other integer
	    	System.out.println("Invalid Input. Please enter either 1, 2, 3, or 4.");
	    	changeCurrentPage(5);
	    	P5();//starts the page again
	    }
	    user_input.close();//closes the scanner
	}
	
	public void P6() { //VIEW ITEMS BY CATEGORY
		pagesep();
		Scanner user_input = new Scanner( System.in );
		int P6_option;
		System.out.println("1.Readables");//PROMPTS THE USER for their available options
		System.out.println("2.Audio");//prompt
		System.out.println("");
		System.out.println("Choose your option:");//prompt
		System.out.println("");
		System.out.println("Press -1 to return to previous menu");//prompt
	    P6_option = user_input.nextInt();//this section decides what the program should do based on what the user inputs
	    if (P6_option==1){//checks to see if the input was 1
	    	changeCurrentPage(8);
	    	P8();//if it was redirects to the readables list
	    }
	    else if (P6_option==2){//checks to see if the input was 2
	    	changeCurrentPage(9);
	    	P9();//if it was redirects to the Audio list
	    }
	    else if (P6_option==-1){//Checks to see if the input was -1
	    	changeCurrentPage(5);
	    	P5();//if it was redirects to the main shopping menu
	    }
	    else{
	    	System.out.println("Invalid Input. Please enter either 1, 2 or -1.");//this is used incase the user enters a improper key
	    	P6();//send them back to the category viewer to try again
	    }
	    user_input.close();// closes the scanner
	}
	
	public void P7() { //SHOPPING CART
		pagesep();
		Scanner user_input = new Scanner( System.in );//Initializing another keyboard scanner
		int P7_option;//stores decision for scanner on the shopping cart
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); //initializes the date formatting, to be printed
		Date date = new Date();//creates a new instance of the date class
		for (int a = 0; a < myShoppingCart.content.size(); a++){
			System.out.println(myShoppingCart.content.get(a).sNo + ", "+myShoppingCart.content.get(a).name+", "
					+dateFormat.format(date)+ ", " + myShoppingCart.content.get(a).quantity);//print the required info for the shopping cart
		}
		System.out.print("\n \n");
	    System.out.println("Press -2 to checkout \nPress -1 to return to the previous menu:");//user prompt
	    P7_option = user_input.nextInt();//takes the next user input
	    
	    if (P7_option == -1) {
	    	changeCurrentPage(5);
	 	    P5();//returns to main menu
	    }
	    else if (P7_option == -2) {
	    	changeCurrentPage(10);
	    	P10();//sends to checkout page
	    }
	    else {//covers the user inputting any other integer
	    	System.out.println("Invalid input. Please press -1 or -2");
	    	System.out.println("Reloading shopping cart");
	    	changeCurrentPage(7);
	    	P7();//reloads the shopping cart
	    }
	    user_input.close();//closes the scanner
	}
	
	public void P8() { //READABLES
		pagesep();
		Scanner user_input = new Scanner( System.in );//Initializing another keyboard scanner
		int P8_option_item, P8_option_amount, P8_option_return;// Initializes 3 int variables regarding the option choice, amount, and the choice of what to do after a option has been choosen
		
		System.out.println("Readables: \n");
		int itemCount = showReadables(readableList);//prints the list of readable items
		
		System.out.println("Choose your option:");//user prompt
		System.out.println("Press -1 to return to previous menu");
		P8_option_item = user_input.nextInt();//this section decides what the program should do based on what the user inputs
		
		int itemChoice = P8_option_item - 1; //The user picks which item they want
		
		if (itemChoice >=0 && itemChoice < itemCount && P8_option_item != -1){ //Note itemcount is 1 greater than total number of items
			System.out.println("You have selected " + readableList.get(itemChoice).name + ".");//prints out what the user has choosen
			System.out.println("Enter quantity:");// asks the user to enter the quantity of the item they want
			P8_option_amount = user_input.nextInt();// store the amount that the user wants in a variable
			
			if (P8_option_amount > 0 && P8_option_amount <= readableList.get(itemChoice).quantity){ //checks if the user inputs a quantity that is in stock
				boolean b = CartChecker(readableList.get(itemChoice).name , myShoppingCart.content);//checks if the item the user picked is already in the cart, returns true or false
				if (b){//if true
					Readable userItem = new Readable();//creates a new item, to be added to the cart
					userItem.buyAReadable(userItem, (Readable) readableList.get(itemChoice), P8_option_amount);//gets the required attributes using the function
					myShoppingCart.addItem(userItem);//adds to the users shopping cart
					readableList.get(itemChoice).changeQuantity(P8_option_amount); //changes the stores item quantity
				}
				else{//if false, meaning the item already exists in the shopping cart
					for (int i = 0 ; i < myShoppingCart.content.size() ; i++){//loops through the items in the cart
						if (myShoppingCart.content.get(i).name.equals(readableList.get(itemChoice).name)){
							myShoppingCart.content.get(i).addQuantity(P8_option_amount);//updates the quantity of the cart item
							break;
						}
					}
				}
				
				System.out.println(readableList.get(itemChoice).name + " has been added to your shopping cart.");
				
				writeUserFile(myShoppingCart); //updates the users shopping cart txt file
				
				System.out.println("Press -2 to Continue Shopping or Press 0 to CheckOut");
				
			    P8_option_return = user_input.nextInt();// Assigns the users decision to the variable shown
			    
			    if (P8_option_return==-2){ 
			    	changeCurrentPage(6);
			    	P6();//Goes back to "view items per category"
			    }
			    else if (P8_option_return==0){ 
			    	changeCurrentPage(10);
			    	P10();//Goes to the checkout
			    }
			    else{
			    	System.out.println("You entered an invalid option.  Your order has been cancalled."
			    			+ "\nReturning to the previous page.");
			    	changeCurrentPage(8);
			    	P8();//returns the user to the READABLES page
			    }
			}
			else {
				System.out.println("Invalid entry amount");//lets the user know that they have asked for an invalid amount of product
				System.out.println("Returning to previous page");//tells the user that they are returning to the View by category page
				changeCurrentPage(6);
				P6();// returns to View by Catagory Page
				
			}
		}
		else if (P8_option_item==-1){
			changeCurrentPage(6);
	    	P6();//returns to view by category page
	    	
		}
		else {
			System.out.println("Invalid entry item #");
			System.out.println("Returning to previous page");
			changeCurrentPage(8);
			P8();// send the user to the readable page to try again
		}
		
	    user_input.close();//close the scanner
	}
	
	public void P9() { //AUDIO
		pagesep();
		Scanner user_input = new Scanner( System.in );//Initializing another keyboard scanner
		int P9_option_item, P9_option_amount, P9_option_return;// Initializes 3 int variables regarding the option choice, amount, and the choice of what to do after a option has been choosen
		System.out.println("Audio: \n");// prints the title of the page 
		
		int itemCount = showAudioProducts(audioList);//shows the list of audio products

		System.out.println("Choose your option:");//user prompt
		System.out.println("Press -1 to return to previous menu");
		P9_option_item = user_input.nextInt();//this sections decides what the program should do based on what the user inputs
		
		int itemChoice = P9_option_item - 1; //The user picks which item they want
		
		
		if (itemChoice >=0 && itemChoice < itemCount && P9_option_item != -1){
			System.out.println("You have selected " + audioList.get(itemChoice).name + ".");
			System.out.println("Enter quantity:");//prompt
			P9_option_amount = user_input.nextInt();

			if (P9_option_amount > 0 && P9_option_amount <= audioList.get(itemChoice).quantity){//checks if the user inputs a quantity that is in stock
				
				boolean b = CartChecker(audioList.get(itemChoice).name , myShoppingCart.content);//checks if the item already exists in the cart
				if (b){//if true
					Audio userItem = new Audio();//creates a new audio item
					userItem.buyAnAudio(userItem, (Audio) audioList.get(itemChoice), P9_option_amount);//gives the item it's proper attributes
					myShoppingCart.addItem(userItem);//adds the item to the shopping cart
					audioList.get(itemChoice).changeQuantity(P9_option_amount);//changes the quantity of readable in stock
				}
				else{//if false
					for (int i = 0 ; i < myShoppingCart.content.size() ; i++){//loops through the shopping cart
						if (myShoppingCart.content.get(i).name.equals(audioList.get(itemChoice).name)){
							myShoppingCart.content.get(i).addQuantity(P9_option_amount);//updates the carts item quantity
							break;
						}
					}
				}
				
				System.out.println(audioList.get(itemChoice).name + " has been added to your shopping cart.");
				
				writeUserFile(myShoppingCart); //updates the users shopping cart txt file
				
				System.out.println("Press -2 to Continue Shopping or Press 0 to CheckOut");//user prompt
				
			    P9_option_return = user_input.nextInt();// Assigns the users decision to the variable shown
			    
			    if (P9_option_return==-2){
			    	changeCurrentPage(6);
			    	P6();//Goes back to "view items per category"
			    }
			    else if (P9_option_return==0){
			    	changeCurrentPage(10);
			    	P10();//Goes to the checkout
			    }
			    else{
			    	System.out.println("You entered an invalid option.  Your order has been cancalled."
			    			+ "\nReturning to the previous page.");
			    	P8();
			    }
			}
			else { //if the user inputs some other integer
				System.out.println("Invalid entry amount");
				System.out.println("Returning to previous page");
				P6();//returns to view items per category
			}
		}
		else if (P9_option_item==-1){
			changeCurrentPage(6);
	    	P6();//returns to view items per category
		}
		else {
			System.out.println("Invalid entry item #");
			System.out.println("Returning to previous page");
			changeCurrentPage(9);
			P9();//returns to the audio products page
		}
	    user_input.close();//closes the scanner
	}
	
	public void P10(){ //CHECKOUT AND CONFIRMATION
		pagesep();
		Scanner user_input = new Scanner( System.in );//new scanner
		
		double HST, totalPrice;//initializes variables
		double shipping = 0;
		double envTax = 0;
		String P10_option;
		double cartPrice = 0;
		
		DecimalFormat df = new DecimalFormat("#.##");//new format style, to two decimal places
		df.setRoundingMode(RoundingMode.CEILING);//sets rounding type
		System.out.println("Billing Information:");//prints the required information
		System.out.println(String.format("%-25s%-20s%-30s%-20s","Name","Quantity","Price per Item ($)" , "Total Price ($)"));
		
		System.out.print("\n");
		for (int a = 0; a < myShoppingCart.content.size(); a++){//loops through the items in the shopping cart
			if (myShoppingCart.content.get(a).type.equals("CD") || myShoppingCart.content.get(a).type.equals("Book")){//checks if the item is a cd or book
				shipping = shipping + 0.1 * (double) (50.0/51.0) * myShoppingCart.content.get(a).price;//adds to the shipping price NOTE (50/51)*price converts price to the price without environmental tax
				envTax = envTax + 0.02 * (double) (50.0/51.0)*myShoppingCart.content.get(a).price;//adds to the environmental tax
				System.out.println(String.format("%-25s%-20s%-30s%-20s", myShoppingCart.content.get(a).name, 
						myShoppingCart.content.get(a).quantity,//prints the required item attributes using proper formatting
						df.format((double) (50.0/51.0) * myShoppingCart.content.get(a).price) ,
						df.format(myShoppingCart.content.get(a).quantity * (double) (50.0/51.0) * myShoppingCart.content.get(a).price) ));
				cartPrice += myShoppingCart.content.get(a).quantity * (double)(50.0/51.0) * myShoppingCart.content.get(a).price;
						}
			else {
				System.out.println(String.format("%-25s%-20s%-30s%-20s", myShoppingCart.content.get(a).name,//prints the required item attributes using proper formatting 
						myShoppingCart.content.get(a).quantity,
						df.format(myShoppingCart.content.get(a).price) ,
						df.format(myShoppingCart.content.get(a).quantity * myShoppingCart.content.get(a).price) ));
				cartPrice += myShoppingCart.content.get(a).quantity * myShoppingCart.content.get(a).price;
			}
		}
		HST = 0.13*cartPrice;//calculates tax
		totalPrice = cartPrice+HST+shipping+envTax; //calculates total price
		System.out.print("\n");

		System.out.println("______________________________________________________________________________________________________________");
		System.out.println(String.format("%-25s%-50s%-20s","Environment Tax","2%",df.format((double) envTax))); //outputs environmental tax
		System.out.println(String.format("%-25s%-50s%-20s","HST","13%",df.format(HST)));// //prints the HST
		System.out.println(String.format("%-25s%-50s%-20s","Shipping","10%",df.format(shipping)));//prints the shipping price
		System.out.println("______________________________________________________________________________________________________________");
		System.out.println(String.format("%-75s%-20s","Total:", df.format(totalPrice)+"$"));//prints the total price
		System.out.print("\n");
		
		System.out.println("Are you sure you want to pay? yes or no.");//user confirmation
		P10_option = user_input.nextLine();
		
		if (P10_option.equalsIgnoreCase("yes")){
			int orderID = 99; //since the count starts at 100, we start one number lower and count up for each order
			
			try {//This will keep track of the number of orders
				String filename = "ones.txt";
				
				FileWriter fw = new FileWriter(filename,true); //the true will append the new data
				fw.write("1");//writes 1 to the "ones.txt" file.  this will be used to count the number of orders
				fw.close();
			}
			catch(IOException ioe){//catches exception
				System.err.println("IOException: " + ioe.getMessage());//prints the exception
			}
			
			try {
		        BufferedReader in = new BufferedReader(new FileReader("ones.txt"));//opens the ones.txt file
		        String str;
		        str = in.readLine();
		        in.close();
		        for (int i =0; i<str.length();i++){ //COUNTS THE NUMBER OF 1'S IN THE FILE
		        	orderID += 1;//adds 1 to the orderID count
		        }
		    } 
		    catch (IOException e) {//catches exception
		        System.out.println(e);//prints the exception
		    }
			System.out.println("Confirmation ID: " + "U" + orderID ); //prints confirmation ID
			System.out.println("Items shipped to: " + myUser.getUsername());//prints the required username
			
			
			try { /////////////////////////////////////////////THIS IS THE ITEMS BOUGHT BONUS MARK////////////////////////////////
				String filename1 = "ItemsBought.txt";
				FileWriter fw1 = new FileWriter(filename1,true); //the true will append the new data
				
				fw1.write(myUser.getUsername() + "\n");//writes the username
				for (int i = 0; i < myShoppingCart.content.size();i++){//loops through the shopping cart
					fw1.write("U"+orderID+", "+ myShoppingCart.content.get(i).name+", " //writes the required attributes to the ItemsBought file
							+df.format(myShoppingCart.content.get(i).quantity * myShoppingCart.content.get(i).price) + "\n");
					//fw1.write("\n");
				}
				fw1.write("Total Price of order U" + orderID + ": " + df.format(totalPrice)+"$" + "\n" + "\n");	//writes the total price			
				fw1.close();//closes the file writer
			}
			catch(IOException ioe){//catches exception
				System.err.println("IOException: " + ioe.getMessage());//prints exception message
			}
			
			writeFileReadables (readableList, "Books.txt", "EBooks.txt");// UPDATES THE BOOKS.TXT AND EBOOKS.TXT FILES FOR NEW QUANTITIES
			writeFileAudio (audioList, "CDs.txt","MP3.txt");//UPDATES THE CDS.TXT AND MP3.TXT FILES FOR NEW QUANTITIES
			clearShoppingCartFile(myShoppingCart);//clears the shopping cart file for the specific user
			myShoppingCart = new ShoppingCart();//creates a new shopping cart
			P5();//returns to the main shopping page
		}
		else if (P10_option.equalsIgnoreCase("no")) {
			System.out.println("Returning to menu");//aborts the purchase
			changeCurrentPage(5);
			P5();//returns to the main shopping page
		}
		user_input.close();//closes the scanner
	}
	
	public void P11(){//Previous orders ALSO PART OF THE BONUS MARK
		pagesep();
		Scanner user_input = new Scanner( System.in );//initializes a new scanner
		int P11_option;//holds the users choice
		System.out.println("Previous Orders (Confirmation ID, Product Name, Total ($))");//prints the required attribute titles
		try {
	        BufferedReader in = new BufferedReader(new FileReader("ItemsBought.txt"));//reads the ItemsBought file
	        String str;
	        while ((str = in.readLine()) != null) {//reads each line in the file
	            if (str.equals(myUser.getUsername())){//finds the purchases associated with the current user
	            	str = in.readLine();//prints the first line after the users name in ItemsBought.txt
	            	while ( !str.contains("Total") ) {//since the last line in the purchase contains "total" we loop until we reach it
	            		System.out.println(str);//prints the line in ItemsBought.txt
	            		String test2 = in.readLine();//reads the next line
	            		str = test2;
	            	}
	            	System.out.println(str);//prints the "Total ..." line
	            }
	        }
	        in.close();//closes the scanner
	    } 
	    catch (IOException e) {//catches exception
	        System.out.println(e);//prints the exception
	    }
		
		System.out.print("\n");
	    System.out.println("Press -1 to return to the previous menu:");//user prompt
	    P11_option = user_input.nextInt();//gets the users next input
	    
	    if (P11_option == -1) {
	    	changeCurrentPage(5);
	 	    P5();//returns to the view items by category page
	    }
	    else {
	    	System.out.println("Invalid input. Please press -1");//user prompt
	    	System.out.println("Reloading Previous Purchases");
	    	changeCurrentPage(11);
	    	P11();//reloads the previous purchases page
	    }
		user_input.close();//closes the scanner
	}

	public void adminP1(){
		pagesep();
		
		Scanner admin_input = new Scanner( System.in ); //adminP1 INPUT OPEN
		int admin_option; //holds the value that the user inputs
		
		System.out.println("1.Sign Out \nChoose your option:"); //output prompt
	    admin_option = admin_input.nextInt();//takes in the admin's choice
	    
	    if (admin_option == 1){ //SIGN OUT
	    	myUser = null; //clears the user
	    	myShoppingCart = null; //clears the shopping cart
	    	P1();//returns to the starting page
	    }
	    else {
	    	System.out.println("Invalid Input. Please enter a valid option.");
	    	adminP1(); //restarts the page if the user inputs something unexpected
	    }
	    admin_input.close();//closes the scanner
	}
}