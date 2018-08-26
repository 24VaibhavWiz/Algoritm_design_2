import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class Survey extends Main implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	protected Vector<Question> questions=new Vector<Question>();
	protected IO IO=new Output();
	protected String nameOfSurvey;
	HashMap<String,Vector<ResponseCorrectAnswer>> response=new HashMap<String,Vector<ResponseCorrectAnswer>>();
	
		public Survey() {
		
			}

		public void setQuestions(Vector<Question> questions) {
			this.questions = questions;
			}

		public Vector<Question> getQuestions() {
			return this.questions;
			}
	
		public static  Survey load(String surveyList, String type) {
			Survey abc=new Survey();
			System.out.println("Select a " + type);
			String temp = "";
			String[] surveys = surveyList.split("\n");
			for (int i = 0; i < surveys.length; i++){
				System.out.println("" + (i + 1) + ") "+ surveys[i].substring(0, surveys[i].lastIndexOf('.')));
				}
			System.out.println("" + (surveys.length + 1) + ") Exit");
			int choice = -1;
			Scanner scan = new Scanner(System.in);
			temp = scan.nextLine();
			try{
				choice = Integer.parseInt(temp);
				} 
			catch (Exception e){
			//Catch invalid input, non digit
				System.out.println("Invalid entry, enter a number for a " + type+ " \n\n\n");
				load(surveyList, type);
				scan.close();	
				}
		//Not valid choices for this menu, let the user know and prompt again
			if (choice > surveys.length + 1 || choice < 1){
				System.out.println("Invalid entry, enter a number for a " + type+ " \n\n\n");
				load(surveyList, type);
				scan.close();	
				}
			else{
				if (choice == surveys.length + 1){
					try {
						System.out.println("\n");
						MenuOption();
							} 
					catch (IOException e) {
						e.printStackTrace();
							}
						}
				try{  
				//Deserialization 
				FileInputStream fis = new FileInputStream(type.toLowerCase()+ "s\\" + surveys[choice - 1]);
				ObjectInputStream ois = new ObjectInputStream(fis);
				switch (type.toLowerCase()){
				case "survey":
					abc = (Survey) ois.readObject();
					break;
				case "test":
					abc = (Test) ois.readObject();
					break;
				default:
					//won't happen
					break;
					}
					fis.close();
					ois.close();
				} 
				catch (Exception e){
					System.out.println("File was not serialized correctly or may be an old version \n");
					scan.close();	
				}
			}
			abc.displaySurvey();
			return abc;
		}
	
		public  void savetofile(Survey currentSurvey) throws IOException {
		
			File createFile = new File("surveys\\" + this.nameOfSurvey + ".dat");

			if (!createFile.exists())
				createFile.createNewFile();

			File testsFile = new File("surveys.txt");

			if (!testsFile.exists())
				testsFile.createNewFile();
		
			FileOutputStream fileOut = new FileOutputStream(createFile);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);

			FileReader fr = new FileReader("surveys.txt");
			BufferedReader br1 = new BufferedReader(fr);
			String collection = "";
			String temp = br1.readLine();
			while (temp != null){
				if (!temp.toLowerCase().equals((this.nameOfSurvey + ".dat").toLowerCase())){
				collection = collection + temp + "\n";
					}
			temp = br1.readLine();
			}
			FileWriter fw = new FileWriter("surveys.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(collection + this.nameOfSurvey + ".dat\n");

			//Close all the streams
			br1.close();
			bw.close();
			fw.close();
			out.close();
			fileOut.close();	
			}
	
		// displays the types of questions a user might want to create 
		public void displaySurvey(){
			System.out.println("Displaying the survey with the questions created \n");
			this.IO.display("Name of the Survey - "+this.nameOfSurvey+"\n");	
			for(int i=0;i<questions.size();i++){
				this.IO.display("" + (i + 1) + ")");
				questions.get(i).display(this.IO);
					}
				this.IO.display("\n");
				}

		//creates the questions it self 
		protected void createQuestion(int choice) throws IOException{
		Question ques = null;
			switch (choice){
				case 1:
					System.out.println("You have selected to " + choice);
					ques = new TF();
					ques.createques();
					break;
				case 2:
					System.out.println("You have selected to " + choice);
					ques= new MCQ();
					ques.createques();
					break;
				case 3:
					System.out.println("You have selected to " + choice);
					ques= new Ranking();
					ques.createques();
					break;
				case 4:
					System.out.println("You have selected to " + choice);
					ques = new Matching();
					ques.createques();
					break;
				case 5:
					System.out.println("You have selected to " + choice);
					ques= new Essay();
					ques.createques();
					break;
				case 6:
					System.out.println("You have selected to " + choice);
					ques = new ShortAnswer();
					ques.createques();
					break;
				case 7:
					super.SurveyMenu();
					break;
				default: 
					System.out.println("Please select the valid options only \n");
					break;
				}
			questions.add(ques);	
			questionOptions();
			}
		
		public Survey createSurvey() throws IOException {
			System.out.println("type name of survey");
			Scanner reader1 = new Scanner(System.in);  // Reading from System.in
			String name_ = reader1.nextLine();
			nameOfSurvey= name_;
			questionOptions();
			//	responses=new Vector<Vector<ResponseCorrectAnswer>>();
			return this;	
			}	
		
		public void questionOptions(){
			
			System.out.println("1.) Add a new T/F question:"); 
			System.out.println("2.) Add a new multiple choice question");
			System.out.println("3.) Add a new Ranking question:");
			System.out.println("4.) Add a new Matching question:");
			System.out.println("5.) Add a new Essay question:");
			System.out.println("6.) Add a new Short Answer question:");
			System.out.println("7.) Previous Menu");
	

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String var;
			try {
				var = br.readLine();
				int n; 
				try{
				n=Integer.parseInt(var);
				if(n>=1 || n<=7){
					createQuestion(n);
						}
				else{
					System.out.println("Please select the valid options only \n");
					questionOptions();
						}
					}
				catch (Exception e){
					 System.out.println("Please select the valid options only \n");
					 questionOptions();	
					}
				} 
			catch (IOException e1) {
				e1.printStackTrace();
				}
			}

		public void modify(int i) {
			Question question = this.questions.get(i);
			question.modifyy();
			}

		public void take() {
			Vector<ResponseCorrectAnswer> abc = new Vector<ResponseCorrectAnswer>();
			System.out.println("Please enter your name");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String key;
			try {
				key = br.readLine();
				System.out.println("Displaying the survey with the questions \n");
				this.IO.display("Name of the Survey - "+this.nameOfSurvey+"\n");	
				for(int i=0;i<questions.size();i++){
					this.IO.display("" + (i + 1) + ")");
					questions.get(i).display(this.IO);
				//this.IO.display("enter your response");	
					ResponseCorrectAnswer a=new ResponseCorrectAnswer();
					
					a.addUserResponses(questions.get(i));
					abc.addElement(a);
					}
				if (response.isEmpty()){
					response = new HashMap<String,Vector<ResponseCorrectAnswer>>();
					}
				response.put(key, abc);
				} 
			catch (IOException e) {
				e.printStackTrace();
				}
			}

		public void gradeTest(Survey currentSurvey) {
		
			}

		public void tabulate() {
			HashMap<Integer,Vector<ResponseCorrectAnswer>> table=new HashMap<Integer,Vector<ResponseCorrectAnswer>>();
			Vector<ResponseCorrectAnswer> usr=new 	Vector<ResponseCorrectAnswer>();
			 Set<String> keys = currentSurvey.response.keySet();
		        System.out.println("\n");
		        for(String key: keys){
					usr=response.get((key));	
					for(int j=0;j<questions.size();j++){
						if(table.get(j)==null){
							table.put(j, new Vector<ResponseCorrectAnswer>());			
						}
						table.get(j).add(usr.get(j));	
					}	
		        }
		       
		        for(Integer k : table.keySet()){
					System.out.println("Question "+(k+1)+")");
					questions.get(k).display(this.IO);
					
					System.out.println("Replies");
					
					//Tabulation for TF
					if(questions.get(k).getClass().getName()=="TF"){
						
						
						for (ResponseCorrectAnswer rca : table.get(k))  {
							for (String strs : rca.getRCA()) {
								System.out.println(strs );
							}
							
						}
						System.out.println("");
						System.out.println("Tabulation");
						
						
						int fal=0;
						int tru=0;
						for (ResponseCorrectAnswer rca : table.get(k))  {
							for (String strs : rca.getRCA()) {
								if(strs.equals("False")){
									fal++;
								}
								else if(strs.equals("True")){
									tru++;
								}
							}
						}
						System.out.println("True:" + tru);
						System.out.println("False:" +fal);
					}
					
					//Tabulation for Essay
					if(questions.get(k).getClass().getName()=="Essay"){
						
						for (ResponseCorrectAnswer rca : table.get(k))  {
							for (String strs : rca.getRCA()) {
								System.out.println(strs );
							}
							System.out.println("");
						}
						System.out.println("");
						System.out.println("Tabulation");
						
						
						for (ResponseCorrectAnswer rca : table.get(k))  {
							for (String strs : rca.getRCA()) {
								System.out.println(strs );
							}
						}
					}
					
					
					if(questions.get(k).getClass().getName()=="ShortAnswer"){
						
						for (ResponseCorrectAnswer rca : table.get(k))  {
							for (String strs : rca.getRCA()) {
								System.out.println(strs );
							}
							System.out.println("");
						}
						System.out.println("");
						System.out.println("Tabulation");
						
						
						HashMap<String, Integer> hmap = new HashMap<>();
						for (ResponseCorrectAnswer rca : table.get(k))  {
							for (String str : rca.getRCA()) {
								if (hmap.containsKey(str)) {
									hmap.put(str, hmap.get(str)+1);
								} else {
									hmap.put(str, 1);
								}
							}
						}
						
						for (Map.Entry<String, Integer> entry : hmap.entrySet()) {
						    String key = entry.getKey().toString();
						    Integer value = entry.getValue();
						    System.out.println(key + " " + value);
						}
						
						
					}
					
					if(questions.get(k).getClass().getName()=="MCQ"){
						
						for (ResponseCorrectAnswer rca : table.get(k))  {
							
							for (String strs : rca.getRCA()) {
								System.out.println(strs );
								
							}
							
						}
						System.out.println("");
						System.out.println("Tabulation");
						
						
						MCQ mcq = (MCQ) questions.get(k);
						HashMap<String, Integer> hmap = new HashMap<>();
						for (ResponseCorrectAnswer rca : table.get(k))  {
							for (String str : rca.getRCA()) {
								if (hmap.containsKey(str)) {
									hmap.put(str, hmap.get(str)+1);
								} else {
									hmap.put(str, 1);
								}
							}
						}
						
						for (Map.Entry<String, Integer> entry : hmap.entrySet()) {
						    String key = entry.getKey().toString();
						    Integer value = entry.getValue();
						    System.out.println(key + " : " + value);
						}
					}
					
					if(questions.get(k).getClass().getName()=="Matching"){
						for (ResponseCorrectAnswer rca : table.get(k))  {
							int i=65;
							for (String strs : rca.getRCA()) {
								System.out.println(Character.toString((char) (i))+" "+strs );
								i++;
							}
							i=0;
							System.out.println("");
						}
						System.out.println("");
						System.out.println("Tabulation");
						HashMap<String, Integer> hmap1 = new HashMap<>();
						for (ResponseCorrectAnswer rca : table.get(k))  {
							StringBuilder sb = new StringBuilder();
							for (String str : rca.getRCA()) {
								sb.append(str);	 
								
							}
							if (hmap1.containsKey(sb.toString())) {
								hmap1.put(sb.toString(), hmap1.get(sb.toString())+1);
							} else {
								hmap1.put(sb.toString(), 1);
							}
						}
						
						for (Map.Entry<String, Integer> entry : hmap1.entrySet()) {
						    String key = entry.getKey().toString();
						    Integer value = entry.getValue();
						    System.out.println(value + " ) \n ");
						    int h=65;
						    for(int m=0;m<key.length();m++){
						    	System.out.println(Character.toString((char) (h)) +" "+ key.charAt(m));
						    	h++;
						    }
						    h=0;
						    System.out.println("\n");
						
							}					
						}
					
					if(questions.get(k).getClass().getName()=="Ranking"){
						for (ResponseCorrectAnswer rca : table.get(k))  {
							
							for (String strs : rca.getRCA()) {
								System.out.println(strs );
								
							}
							
							System.out.println("");
						}
						System.out.println("");
						System.out.println("Tabulation");
						HashMap<String, Integer> hmap1 = new HashMap<>();
						for (ResponseCorrectAnswer rca : table.get(k))  {
							StringBuilder sb = new StringBuilder();
							for (String str : rca.getRCA()) {
								sb.append(str);	 
								
							}
							if (hmap1.containsKey(sb.toString())) {
								hmap1.put(sb.toString(), hmap1.get(sb.toString())+1);
							} else {
								hmap1.put(sb.toString(), 1);
							}
						}
						
						for (Map.Entry<String, Integer> entry : hmap1.entrySet()) {
						    String key = entry.getKey().toString();
						    Integer value = entry.getValue();
						    System.out.println(value + " ) \n ");
						  
						    for(int m=0;m<key.length();m++){
						    	System.out.println(key.charAt(m));
						    }
						    System.out.println("\n");
						
						}		
					}
					System.out.println("\n");
				}
				System.out.println("\n");
			}
		
		
		
		
		public static  Survey loads(String surveyList, String type) {
			Survey abc=new Survey();
			System.out.println("Select a " + type);
			String temp = "";
			String[] surveys = surveyList.split("\n");
			for (int i = 0; i < surveys.length; i++){
				System.out.println("" + (i + 1) + ") "+ surveys[i].substring(0, surveys[i].lastIndexOf('.')));
				}
			System.out.println("" + (surveys.length + 1) + ") Exit");
			int choice = -1;
			Scanner scan = new Scanner(System.in);
			temp = scan.nextLine();
			try{
				choice = Integer.parseInt(temp);
				} 
			catch (Exception e){
			//Catch invalid input, non digit
				System.out.println("Invalid entry, enter a number for a " + type+ " \n\n\n");
				loads(surveyList, type);
				scan.close();	
				}
		//Not valid choices for this menu, let the user know and prompt again
			if (choice > surveys.length + 1 || choice < 1){
				System.out.println("Invalid entry, enter a number for a " + type+ " \n\n\n");
				loads(surveyList, type);
				scan.close();	
				}
			else{
				if (choice == surveys.length + 1){
					try {
						System.out.println("\n");
						MenuOption();
							} 
					catch (IOException e) {
						e.printStackTrace();
							}
						}
				try{  
				//Deserialization 
				FileInputStream fis = new FileInputStream(type.toLowerCase()+ "s\\" + surveys[choice - 1]);
				ObjectInputStream ois = new ObjectInputStream(fis);
				switch (type.toLowerCase()){
				case "survey":
					abc = (Survey) ois.readObject();
					break;
				case "test":
					abc = (Test) ois.readObject();
					break;
				default:
					//won't happen
					break;
					}
					fis.close();
					ois.close();
				} 
				catch (Exception e){
					System.out.println("File was not serialized correctly or may be an old version \n");
					scan.close();	
				}
			}
			abc.displaySurveyTakeTest();
			return abc;
		}

		public void displaySurveyTakeTest() {
			// TODO Auto-generated method stub
			
		}
		
		
	}
		

