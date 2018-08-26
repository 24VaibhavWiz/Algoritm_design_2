import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	static Survey currentSurvey;

	public static void main( String [] args) throws IOException {	
		MenuOption();		
		}
	
	public static void MenuOption() throws IOException{
		System.out.println("MENU");
		System.out.println("1. Surevy");
		System.out.println("2. Test");
		System.out.println("3. Quit");
	
		System.out.println("Please select one of the option from above - type 1,2,or 3: \n ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String var=br.readLine();
		int n; 
		try{
		n=Integer.parseInt(var);
		if(n==1){
			System.out.println("Option 1 - Survey Selected: \n");
			SurveyMenu();
				}
		else if(n==2){
			System.out.println("Option 2 - Test Selected: \n");
			TestMenu();
				}
		else if(n==3){
			System.out.println("Exiting the Survey/Test Application \n");
			System.exit(0);
				}
		else { 
			System.out.println("Please follow the instruction and select the valid option from the menu only \n");
			MenuOption();
				}	
			}
		catch (Exception e){
			System.out.println("Please follow the instruction and select the valid option from the menu only \n");
			MenuOption();	
			}
		}
	@SuppressWarnings("resource")
	public static void SurveyMenu() throws IOException{
		
		System.out.println("Displaying Survey Menu:");
		System.out.println("Please select one of the option:");
		System.out.println("1) Create a new Survey");
		System.out.println("2) Display a Survey");
		System.out.println("3) Load a Survey");
		System.out.println("4) Save a Survey");
		System.out.println("5) Modify an Existing Survey");
		System.out.println("6) Take a Survey");
		System.out.println("7) Tabulate a Survey");
		System.out.println("8) Quit");
		
		System.out.println("Please select one of the option from above - type 1,2,3,4 or 5: \n");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		String var=br1.readLine();
		int n; 
		try{
		n=Integer.parseInt(var);
		switch(n){
		case 1:{
			currentSurvey = new Survey();
			currentSurvey=currentSurvey.createSurvey();
			break;
			}
		case 2:{
			currentSurvey.displaySurvey();
			break;
			}
		case 3:{
			try{
				String list = "";
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				//list = br.readLine();
				FileReader fr = new FileReader("surveys.txt");
				br = new BufferedReader(fr);
				String surveyList = "";
				list = br.readLine();
				while (list != null){
					if (!list.equals(""))
						surveyList = surveyList + list + "\n";
					list = br.readLine();
						}
				currentSurvey = Survey.load(surveyList, "Survey");
					} 
				catch (FileNotFoundException e){
				System.out.println("Survey's doesn't exist");	
				} 
			catch (Exception e){
				try{
					System.out.println("File has been edited outside of system check at "+ (new FileReader("surveys.txt")).toString());
					} 
				catch (FileNotFoundException e1){	
					}	
				}
			break;
			}
		case 4: {
			currentSurvey.savetofile(currentSurvey);
			System.out.println(" Survey saved to the file. ");
			break;
			}
		case 5: {
			currentSurvey = loadSurvey();
			System.out.println("What question do you wish to modify? (Enter question number only)");
			Scanner in = new Scanner(System.in);
			int num = in.nextInt();
			currentSurvey.modify(num-1);
			System.out.println("Do you wish to save your changes - Write yes or no only. ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String yesno = br.readLine();
			if(yesno.toLowerCase().equals("yes")){
				currentSurvey.savetofile(currentSurvey);
				System.out.println(" Changes made to the Survey saved to the file. ");
			}
			else if (yesno.toLowerCase().equals("no")) {
				System.out.println(" Alright not saved! ");
			}
			else{  System.out.println(" Incorrect Input. Try again. Write yes or no only. ");
			String yesno1 = br.readLine();
			if(yesno1.toLowerCase().equals("yes")){
				currentSurvey.savetofile(currentSurvey);
				System.out.println(" Changes made to the Survey saved to the file. ");
			}
			else if (yesno1.toLowerCase().equals("no")) {
				System.out.println(" Alright not saved! ");}
				else{ System.out.println(" Incorrect input entered, changes not saved! "); }
			}
			break;
			}
		case 6:{
			currentSurvey = loadSurvey();
			currentSurvey.take();
			currentSurvey.savetofile(currentSurvey);
			System.out.println(" You have succesfully completed the survey! \n ");
			break;
			}
		case 7:{
			currentSurvey = loadSurvey();
			currentSurvey.tabulate();
			break;	
			}
		case 8:{
			System.out.println("Exiting from Survey \n");
			MenuOption();
			break;
			}
		default: System.out.println("Please select the valid options only \n");
			break;
			}
		SurveyMenu();
		}
		catch (Exception e){
			System.out.println("Please follow the instruction and select the valid option from the menu only \n");
			SurveyMenu();
			}
		}
	@SuppressWarnings("resource")
	public static void TestMenu() throws IOException{
		
		System.out.println("Displaying Test Menu:");
		System.out.println("Please select one of the option:");
		System.out.println("1) Create a new Test");
		System.out.println("2) Display a Test");
		System.out.println("3) Load a Test");
		System.out.println("4) Save a Test");
		System.out.println("5) Modify an Existing Test");
		System.out.println("6) Take Test");
		System.out.println("7) Grade a Test");
		System.out.println("8) Tabulate a Test");
		System.out.println("9) Quit");
		
		System.out.println("Please select one of the option from above - type 1,2,3,4 or 5:  \n");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		String var=br1.readLine();
		int n; 
		try{
			n=Integer.parseInt(var);
		switch(n){
		case 1:{	
			currentSurvey = new Test();
			currentSurvey=currentSurvey.createSurvey();
			break;	
			}
		case 2:{	
			currentSurvey.displaySurvey();
			break;	
			}
		case 3:{
				try{
					String list = "";
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					//list = br.readLine();
					FileReader fr = new FileReader("tests.txt");
					br = new BufferedReader(fr);
					String surveyList = "";
					list = br.readLine();
					while (list != null){
						if (!list.equals(""))
							surveyList = surveyList + list + "\n";
						list = br.readLine();
						}
					Test.load(surveyList, "Test");
					br.close();
					} 
				catch (FileNotFoundException e){
					System.out.println("Test doesn't exist");
					} 
				catch (Exception e){
					try{
						System.out.println("File has been edited outside of system check at "+ (new FileReader("tests.txt")).toString());
					} 
					catch (FileNotFoundException e1){	
					}
				}
			break;
			}
		case 4: {
			currentSurvey.savetofile(currentSurvey);
			System.out.println(" Test saved to the file. ");
			break;
			}
		case 5: {
			currentSurvey = loadTest();
			System.out.println("What question do you wish to modify? (Enter question number only)");
			Scanner in = new Scanner(System.in);
			int num = in.nextInt();
			currentSurvey.modify(num-1);
			System.out.println("Do you wish to save your changes - Write yes or no only");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String yesno = br.readLine();
			if(yesno.toLowerCase().equals("yes")){
				currentSurvey.savetofile(currentSurvey);
				System.out.println(" Changes made to the Test saved to the file. ");
				}
			else if (yesno.toLowerCase().equals("no")) {
				System.out.println(" Alright not saved! ");
			}
			else{  System.out.println(" Incorrect Input. Try again. Write yes or no only. ");
			String yesno1 = br.readLine();
			if(yesno1.toLowerCase().equals("yes")){
				currentSurvey.savetofile(currentSurvey);
				System.out.println(" Changes made to the Survey saved to the file. ");
			}
			else if (yesno1.toLowerCase().equals("no")) {
				System.out.println(" Alright not saved! ");}
				else{ System.out.println(" Incorrect input entered, changes not saved! "); }
			}
			break;
			}
		case 6:{
			currentSurvey = loadTakeTest();
			currentSurvey.take();
			currentSurvey.savetofile(currentSurvey);
			System.out.println(" You have succesfully completed the test! \n ");
			break;
			}
		case 7:{
			currentSurvey = loadTest();
			currentSurvey.gradeTest(currentSurvey);
			break;
			}
		case 8:{
			currentSurvey = loadTest();
			currentSurvey.tabulate();
			break;
			}
		case 9:{
			System.out.println("Exiting from Test \n");
			MenuOption();
			break;
			}
		default: System.out.println("Please select the valid options only \n");
		break;
			}
		TestMenu();
		}
	catch (Exception e){
		
		System.out.println("Please follow the instruction and select the valid option from the menu only \n");
		TestMenu();
			}
		}
	
	public static Survey loadSurvey(){
		Survey abc=new Survey();
		try{
			String list = "";
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//list = br.readLine();
			FileReader fr = new FileReader("surveys.txt");
			br = new BufferedReader(fr);
			String surveyList = "";
			list = br.readLine();
			while (list != null){
				if (!list.equals(""))
					surveyList = surveyList + list + "\n";
				list = br.readLine();
					}
			 abc = Survey.load(surveyList, "Survey");
			} 
			catch (FileNotFoundException e){
			System.out.println("Survey's doesn't exist");	
			} 
		catch (Exception e){
			try{
				System.out.println("File has been edited outside of system check at "+ (new FileReader("surveys.txt")).toString());
				} 
			catch (FileNotFoundException e1){	
				}	
			}
		return abc;
		}
	
	public static Survey loadTest(){
		Survey abc=new Survey();
		try{
			String list = "";
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//list = br.readLine();
			FileReader fr = new FileReader("tests.txt");
			br = new BufferedReader(fr);
			String surveyList = "";
			list = br.readLine();
			while (list != null){
				if (!list.equals(""))
					surveyList = surveyList + list + "\n";
				list = br.readLine();
					}
			 abc = Survey.load(surveyList, "Test");
			} 
			catch (FileNotFoundException e){
			System.out.println("Test's doesn't exist");	
			} 
		catch (Exception e){
			try{
				System.out.println("File has been edited outside of system check at "+ (new FileReader("surveys.txt")).toString());
				} 
			catch (FileNotFoundException e1){	
				}	
			}
		return abc;
		}
	
	
	public static Survey loadTakeTest(){
		Survey abc=new Survey();
		try{
			String list = "";
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//list = br.readLine();
			FileReader fr = new FileReader("tests.txt");
			br = new BufferedReader(fr);
			String surveyList = "";
			list = br.readLine();
			while (list != null){
				if (!list.equals(""))
					surveyList = surveyList + list + "\n";
				list = br.readLine();
					}
			 abc = Survey.loads(surveyList, "Test");
			} 
			catch (FileNotFoundException e){
			System.out.println("Test's doesn't exist");	
			} 
		catch (Exception e){
			try{
				System.out.println("File has been edited outside of system check at "+ (new FileReader("surveys.txt")).toString());
				} 
			catch (FileNotFoundException e1){	
				}	
			}
		return abc;
		}
	
	
	}