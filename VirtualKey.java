package assignment;
import java.io.*;
import java.util.*;

class operation
{
	static Scanner sc = new Scanner(System.in);
	static void	 showFiles() 
	{
		String [] filename;
		File f=new File("C:\\Users\\Edwin A\\eclipse-workspace\\phase1\\src\\assignment\\");
		
		filename=f.list();
		for(String files:filename)
		{
			System.out.println(files);
		}		
	}
			
	static void addFile() throws Exception //starts of addFile method
	{
		//Extension is to be added just to perfection of file.
		System.out.println("Please enter file name with extention(Such as Me.txt/You.java etc): ");
		String filename=null;
		try {
			filename=sc.next();
		}catch(InputMismatchException e) {
			System.out.println("Invalid inputs are given, please give correct input");
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		//adding a new file to the directory
		String filepath="C:\\Users\\Edwin A\\eclipse-workspace\\phase1\\src\\assignment\\"+filename;
		File newFile=new File(filepath);
		
		Boolean flag=null;
		flag = newFile.createNewFile();
			
		if(flag==false) 
		{
			System.out.println("File name "+filename+" is already in the Directory !!!");
		}else 
		{
			System.out.println("File has been created succesfully on below path \n"+newFile);
		}
	}//end of addFile method
	
	static void deleteFile() throws Exception //starts of deleteFile method
	{
		System.out.println("Please tell us, which file you want to remove: ");
		String filename=sc.next();
		File f=new File("C:\\Users\\Edwin A\\eclipse-workspace\\phase1\\src\\assignment\\"+filename);
		if(f.delete())
		{
			System.out.println("The File name "+f.getName()+" is Deleted");
		}
		else
		{
			System.out.println("The file name "+f.getName()+" is not available");
		}
	}//end of deleteFile method
	
	static void searchFileName()//starts of searchFileName method
	{
		System.out.println("Please give file name to find");
		String fname=sc.next();
		File dir=new File("C:\\Users\\Edwin A\\eclipse-workspace\\phase1\\src\\assignment\\");
		String[] filelist =dir.list();
		int flag=0;
		
		if(filelist==null)
		{
			System.out.println("Empty Directory");
		}
		else
		{
			for(int i=0;i<filelist.length;i++)
			{
				String filename=filelist[i];
				if(filename.equalsIgnoreCase(fname))
				{
					System.out.println("File name "+filename+" is available in the Directory !");
					flag = 1;					
				}
			}
		}
		if(flag==0)
		{		
			System.out.println("File name "+fname+" is not available");		
		}
	}//end of searchFileName method
}
	

//Main Class starts from here
public class VirtualKey extends operation{
	static Scanner sc=new Scanner(System.in);
	
	private static void mydetails() 
	{
		System.out.println("\n<------ Hi Everyone! Welcome to My Project ------>\n\n");
		System.out.println("=========================================\nLet me introduce my self\n=========================================");
		System.out.println("My Name is Edwin");
		System.out.println("My Project name is LockedMe.com");
		System.out.println("My mail id is edwin.dass50383@gmail.com\n=========================================\n");
		
	}
	static void subchoice() throws Exception  
	{
		 int ch=0;
		 breakMe: while(true) {
			 System.out.println("\nPlease select any of below\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n1. Let's add new file\n"
				+ "\n2. Let's delete a file\n\n3. Let's find a file\n\n4. Let's go back to main menu\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			 boolean flag=true;
			 while(flag) try {
				 ch=sc.nextInt();
				 flag=false;
			 }
			 catch(InputMismatchException e){
				 System.out.println("Please Enter a number not a Character");
				 sc.nextLine();
			 }
			 switch(ch) {
			 case 1: 
				 addFile();
				 break;
			 case 2: 
				 deleteFile();
				 break;
			 case 3: 
				 searchFileName();
				 break;
			 case 4: 
				 System.out.println("\nMain menu is just downside.\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				 break breakMe;
			 default: 
				 System.out.println("\nNice input but it won't work.\nPlease enter value from 1 to 4.\nThank you!");
			}
		}
	}
	public static void main(String[] args) throws Exception {
		int ch=0;
		VirtualKey.mydetails();
			while(true) {
			System.out.println("\nPlease enter your choice from below \n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n\n1. Want to see files in ascending order ? - press 1\n"
					+"\n2. Want to do some operation ? - press 2 \n\n3. Want to end the program ? - press 3");
			boolean flag=true;
			while(flag) try {
				ch=sc.nextInt();
				flag=false;
		}
		catch(InputMismatchException e){
			System.out.println("Please Enter a number not a Character");
			sc.next();
		}
	
			switch(ch) {
				case 1: 
					System.out.println("File's List ascending order\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					showFiles();
					break;
				case 2:				
					VirtualKey.subchoice();
					break;
				case 3: 
					System.out.println("<----- Thank you so much! Please Visit Again.\n\nby Edwin A. ----->");
					System.exit(0);
					break;
				default: 
					System.out.println("\nNice input but it won't work.\nPlease enter value from 1 or 2 or 3.\nThank you!");
					}
			}
		}
}

