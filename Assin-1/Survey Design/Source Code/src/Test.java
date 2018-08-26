import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;



public class Test extends Survey implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Vector<ResponseCorrectAnswer> correctResponse = new Vector<ResponseCorrectAnswer>();
	

	public Test() {
		  correctResponse= new Vector<ResponseCorrectAnswer>();
		}

	public void setCorrectResponse(Vector<ResponseCorrectAnswer> correctResponse) {
		this.correctResponse = correctResponse;
		}

	public Vector<ResponseCorrectAnswer> getCorrectResponse() {
		return this.correctResponse;
		}
	
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
				super.TestMenu();
				break;
			default: 
				System.out.println("Please select the valid options only \n");
				break;
			}
		questions.add(ques);
		ResponseCorrectAnswer a=new ResponseCorrectAnswer();
		a.addResponse(choice);
	    correctResponse.addElement(a);
		questionOptions();
		}
	
	public void displaySurvey(){
		System.out.println("Displaying the Test with the questions and correct answers created \n");
		this.IO.display("Name of the Test - "+this.nameOfSurvey+"\n");	
		for(int i=0;i<questions.size();i++){
			this.IO.display("\n");
			this.IO.display("" + (i + 1) + ")");
			questions.get(i).display(this.IO);
			this.IO.display("The correct answer is/are ");
			correctResponse.get(i).display(this.IO);	
			}
		}
	
	public void displaySurveyTakeTest() {
		
		this.IO.display("Name of the Test - "+this.nameOfSurvey+"\n");	
		
	}
	
	public Test createSurvey() throws IOException {
			System.out.println("type name of Test");
			Scanner reader1 = new Scanner(System.in);  // Reading from System.in
			String name_ = reader1.nextLine();
			nameOfSurvey= name_;
			questionOptions();
			return this;	
		}
	
	public  void savetofile(Survey currentSurvey) throws IOException {
		File createFile = new File("tests\\" + this.nameOfSurvey + ".dat");

		if (!createFile.exists())
			createFile.createNewFile();

		File testsFile = new File("tests.txt");

		if (!testsFile.exists())
			testsFile.createNewFile();
		
		FileOutputStream fileOut = new FileOutputStream(createFile);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(this);
		
		FileReader fr = new FileReader("tests.txt");
		BufferedReader br1 = new BufferedReader(fr);
		String collection = "";
		String temp = br1.readLine();
		while (temp != null){
			if (!temp.toLowerCase().equals((this.nameOfSurvey + ".dat").toLowerCase())){
				collection = collection + temp + "\n";
				}
			temp = br1.readLine();
			}
			FileWriter fw = new FileWriter("tests.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(collection + this.nameOfSurvey + ".dat\n");

			//Close all the streams
			br1.close();
			bw.close();
			fw.close();
			out.close();
			fileOut.close();	
		}
	
	public void modify(int i) {
		Question question = this.questions.get(i);
		ResponseCorrectAnswer correctResponse = this.correctResponse.get(i);
		question.modifyy();
		System.out.println("Do you wish to modify the correct answer?");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String yesno = br.readLine();
			if (yesno.toLowerCase().equals("yes")){
				System.out.println("Displaying the correct answer with this question?");
				correctResponse.display(IO);
				System.out.println("Follow the instructions to enter correct answer with this question");
				
				// TF QUESTIONS CORRECT ANSWER MODIFICATION
				if(TF.class.equals(question.getClass())){
					System.out.println("Enter the new correct answer? Write True or False only with a capital T and F ");
					BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
					try {
						String input =  br1.readLine();
					    correctResponse.editResponse(input);
					 	}
					catch (IOException e) {
						e.printStackTrace();
						System.out.println("Error, please try again");
						}
					}
				
				// SA and MCQ QUESTIONS CORRECT ANSWER MODIFICATION
				else if(ShortAnswer.class.equals(question.getClass()) || MCQ.class.equals(question.getClass())){
					BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
					if(this.correctResponse.get(i).RCA.size()>1){ 
						System.out.println("What choice do you wish to make the new correct answer? Enter option number only");
						int choice = Integer.parseInt(br.readLine());
						int choice1 = choice -1;
						System.out.println("Enter the new correct answer? ");
						try {
							String input =  br1.readLine();
						    correctResponse.editResponses(choice1,input );
						 	}
						catch (IOException e) {
							
							System.out.println("Error, please try again");
							} 
						}
					 
					 else{ 
						System.out.println("Enter the new correct answer? ");
						try {
							String input =  br1.readLine();
							correctResponse.editResponse(input);
							}
						catch (IOException e) {
							
							System.out.println("Error, please try again");
							} 
						}
					}
				
				// MATCHING and RANKING QUESTIONS CORRECT ANSWER MODIFICATION
				else if(Matching.class.equals(question.getClass()) || Ranking.class.equals(question.getClass())){
					BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
					int n = this.correctResponse.get(i).RCA.size();
					System.out.println("Please re-enter all the choices in the correct order for correct answer? Enter option number only");
					for(int j=0;j<n;j++){
						try {
							String input =  br1.readLine();
						    correctResponse.editResponses(j,input );
						 	}
						catch (IOException e) {
							System.out.println("Error, please try again");
							} 
						}
					}
				}
			else{
				System.out.println("Correct answers not to be modified");
				}
			} 
		catch (IOException e) {
			e.printStackTrace();
			}
		}

	public void take() {
		Vector<ResponseCorrectAnswer> abc = new Vector<ResponseCorrectAnswer>();
		System.out.println("Please enter your name");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String key;
		try {
			key = br.readLine();
			System.out.println("Displaying the Test with the questions \n");
			this.IO.display("Name of the Survey - "+this.nameOfSurvey+"\n");	
			for(int i=0;i<questions.size();i++){
				this.IO.display("" + (i + 1) + ")");
				questions.get(i).display(this.IO);
				ResponseCorrectAnswer a=new ResponseCorrectAnswer();
				a.addUserResponse(questions.get(i), this.correctResponse.get(i).RCA.size());
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
		int grade=0;
		int total=0;
		int essays=0;
		Vector<ResponseCorrectAnswer> usr=new 	Vector<ResponseCorrectAnswer>();
		IO.display("which response do you want to grade - write the name");
		Set<String> keys = currentSurvey.response.keySet();
	        for(String key: keys){
	            System.out.println(key);
	        	}
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input;
			try {
				input=br.readLine();
				usr=response.get((input));
				
				for(int j=0;j<correctResponse.size();j++){
					if(questions.get(j).getClass().getName().equals("Essay")){
						essays=essays+10;	
						}
					else if(correctResponse.get(j).check(usr.get(j))){
						
						grade=grade+10;	
						}
						total=total+10;
				}total = total-essays; }
			catch (IOException e) {
				e.printStackTrace();
				}
		IO.display("grade is "+grade+"/"+total);
			}
		
	}