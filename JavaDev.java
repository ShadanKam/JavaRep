import java.util.*;
import java.io.*;

public class JavaDev{
	public static void main(String[] args) {
		File fileDir = new File("/Users/kamal/myProjectDir");
		String[] pathnames = null;
		String[] fList = null;
		int a, op;
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		//welcome menu
		System.out.println("Welcome/n/nShadan Khan");
		do{
			
		System.out.println("Enter a number to select from one of these options: ");
		System.out.println("1.Show current file names");
		System.out.println("2.Details of user interface");
		System.out.println("3.Exit application");
		op = input.nextInt();
		
		switch(op) {
		//Option 1: return the current file names in ascending order
		case 1: 
			pathnames = fileDir.list();
			Arrays.sort(pathnames);
			for(String f: pathnames) {
				System.out.println(f);
			}
				break;
		//Option 2: return the details of the user interface
		case 2:
			do {	
			System.out.println("Enter a number to select from the next actions: ");
			System.out.println("1/ Add a new file");
			System.out.println("2/ Delete and exisiting file");
			System.out.println("3/ Search for an existing file");
			System.out.println("4/ Back to main menu");
			a= input.nextInt();
			switch(a) {
			case 1: //add file
				System.out.println("Enter the new file name: ");
				String newfile = input2.nextLine();
				try {
					addFile(newfile, fileDir);
				} catch (IOException e) {
					System.out.println("File cannot be added.. Exiting system.");
					System.exit(0);
				}
					break;
			case 2: //delete file
					System.out.println("Enter the file name you want to delete: ");
					String file2delete = input2.nextLine();
					try {
					deleteFile(file2delete, fileDir);
					}
					catch(FileNotFoundException e) {
						System.out.println("File cannot be deleted.. Exiting system.");
						System.exit(0);
					}
					break;
			case 3: //search for file
					System.out.println("Enter the title of file you're searching for: ");
					String searchedFile = input2.nextLine();
					try {
						searchFile(searchedFile, fileDir);
					}
					catch(FileNotFoundException e) {
						System.out.println("File cannot be deleted.. Exiting system.");
						System.exit(0);}
					break;
			case 4: //back to main menu
				break;
			}

			}while(a!=4);
				break;
			
		//Option 3: close the application
		case 3:
				System.out.print("Closing../nThank You!");
				System.exit(0);
		}
		}while(op!=3);
	}
	
	static void addFile(String name, File directory) throws IOException{
		File newFile = new File(directory, name);
		newFile.createNewFile();
	}
	
	static void deleteFile(String file, File dir) throws FileNotFoundException{
		//CASE SENSITIVE
		//search through list until file is found then delete
		boolean a = false;
		for(int i = 0; i<dir.list().length; i++) {
			if(dir.listFiles()[i].equals(file)) {
				dir.listFiles()[i].delete();
				a = true;
			}
		}
		//if file not found
		if(a==false){
			System.out.println("File not found!");
		}
		
	}
	
	static void searchFile(String file ,File dirF) throws FileNotFoundException{
		//search through array(directory list) for file
		boolean a = false;
		String[] dirList = dirF.list();
		for(int i = 0; i<dirList.length; i++) {
			if(dirList[i].equalsIgnoreCase(file)){
				a = true;
			}
		}
		if(a==true) {
			System.out.println("File is found");
		}
		else
			System.out.println("File is not found!");
	}
	
}