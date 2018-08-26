import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class ResponseCorrectAnswer implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	public Vector<String> RCA=new Vector<String>();
	
	public void display(IO io) {
	for(int i=0;i<RCA.size();i++){
		io.display(RCA.elementAt(i));
			}
		io.display("\n");
		}

	public void addResponse(int choice) {
		
		if(choice==1){
			System.out.println("Please enter the correct response - Write True and False only with a capital T and F.");
			BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Correct answer is ");
			String input;
			try {
				input = br3.readLine();
				RCA.addElement(input);
				} 
			catch (IOException e) {
				e.printStackTrace();
				}
			}
		else if(choice==5){
			String input;
			input = "Not applicable in essay type of questions ";
			RCA.addElement(input);
			}

		else if(choice==6){
			System.out.println("Enter number of correct answers ");
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			try {
				int n=Integer.parseInt(br1.readLine());
				System.out.println("Please enter the correct response ");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String input;
				try {
					for(int i=0;i<n;i++){
						System.out.println("Correct answer "+(i+1)+" ");
						input = br.readLine();
						RCA.addElement(input);
						}
					} 
				catch (IOException e) {
					e.printStackTrace();
					}	
				} 
			catch (NumberFormatException e) {
					e.printStackTrace();
				} 
			catch (IOException e) {
				e.printStackTrace();
				}
		}
		
		
		else{
			System.out.println("Enter number of correct answers ");
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			try {
				int n=Integer.parseInt(br1.readLine());
				System.out.println("Please enter the correct response - Enter option number only.");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String input;
				try {
					for(int i=0;i<n;i++){
						System.out.println("Correct answer "+(i+1)+" ");
						input = br.readLine();
						RCA.addElement(input);
						}
					} 
				catch (IOException e) {
					e.printStackTrace();
					}	
				} 
			catch (NumberFormatException e) {
					e.printStackTrace();
				} 
			catch (IOException e) {
				e.printStackTrace();
				}
			}
		
		
		
		
		}

	public void editResponse(String input) {
		RCA.set(0, input);
		}

	public void editResponses(Integer i, String input) {
		RCA.set(i, input);
		}

	public void addUserResponse(Question question, Integer k) {
		
		if(question.getClass().getName()=="TF"){
			System.out.println("Please enter your response. Write True or False - No Shortcuts.");
			BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
			String input;
			try {
				input = br3.readLine();
				RCA.addElement(input);
				} 
			catch (IOException e) {
				e.printStackTrace();
				}	
			}
		else if(question.getClass().getName()=="Essay"){
			String input;
			BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please write 2 paragraphs only. Press Enter after each paragraph");
				for(int i=0; i<2;i++){
					try {
					input = br3.readLine();
					RCA.addElement(input);
						} 
					catch (IOException e) {
						e.printStackTrace();
						}
					}
				}
	
		else if((question.getClass().getName()=="Matching") || (question.getClass().getName()=="Ranking")){
			System.out.println("Please write your response from the options in the correct order. Write options numbers only");
			System.out.println("You can only enter "+ k+ " response for this question. Press enter after each response.");
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
				for(int i=0;i<k;i++){
					String input;
					try {
					input = br1.readLine();
					RCA.addElement(input);
						}
				catch (IOException e) {
						e.printStackTrace();
						}
					}
				}
		
		else if((question.getClass().getName()=="ShortAnswer") || (question.getClass().getName()=="MCQ")){
			BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
			if(k>1){
				System.out.println("Please write "+k+" responses as this question might have multiple correct answers. ");
				if(question.getClass().getName()=="MCQ"){
					System.out.println("Write options number only");
				}
					for(int i=0;i<k;i++){
						String input;
						try {
							input = br3.readLine();
							RCA.addElement(input);
							}
						catch (IOException e) {
							e.printStackTrace();
							}
						}
					}
			else{
				System.out.println("Please write one response only. ");
				if(question.getClass().getName()=="MCQ"){
					System.out.println("Write option number only");
				}
				String input;
				try {
					input = br3.readLine();
					RCA.addElement(input);
					} 
				catch (IOException e) {
					e.printStackTrace();
					}	
				}	
			}
		}
	
	public Vector<String> getRCA() {
		return RCA;
	}

	public void setRCA(Vector<String> rCA) {
		RCA = rCA;
	}

	public boolean check(ResponseCorrectAnswer cr) {
		if(this.RCA.equals(cr.RCA))
			return true;
		else
			return false;
		}

	public String toString(){
		return RCA.toString();
		}
	
	public void addUserResponses(Question question) throws NumberFormatException, IOException {
		
		if(question.getClass().getName()=="TF"){
			System.out.println("Please enter your response. Write True and False only with a capital T and F.");
			BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
			String input;
			try {
				input = br3.readLine();
				RCA.addElement(input);
				} 
			catch (IOException e) {
				e.printStackTrace();
				}	
			}
		else if(question.getClass().getName()=="Essay"){
			String input;
			BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please write 2 paragraphs only. Press Enter after each paragraph");
				for(int i=0; i<2;i++){
					try {
						input = br3.readLine();
						RCA.addElement(input);
						} 
					catch (IOException e) {
						e.printStackTrace();
						}
					}
				}
		else if((question.getClass().getName()=="Matching") || (question.getClass().getName()=="Ranking")){
			
			if(question.getClass().getName()=="Matching") {
				Matching rank = (Matching) question;
				System.out.println("Please write your response from the options in the correct order. Write options number only.");
				System.out.println("You are only permitted to write "+ rank.leftList.size()+" response");
				BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
//				Integer k=Integer.parseInt(br1.readLine());
					for(int i=0;i<rank.leftList.size();i++){
						String input;
						try {
						input = br1.readLine();
						RCA.addElement(input);
							}
						catch (IOException e) {
							e.printStackTrace();
							}
						}
			}
			
			
			else if(question.getClass().getName()=="Ranking") {
				Ranking rank = (Ranking) question;
				System.out.println("Please write your response from the options in the correct order. Write options number only");
				System.out.println("You are only permitted to write "+ rank.leftList.size()+" response");
				BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
//				Integer k=Integer.parseInt(br1.readLine());
					for(int i=0;i<rank.leftList.size();i++){
						String input;
						try {
						input = br1.readLine();
						RCA.addElement(input);
							}
						catch (IOException e) {
							e.printStackTrace();
							}
						}
			}
			
			
				}
		
		
		
		
		
		else if((question.getClass().getName()=="ShortAnswer") || (question.getClass().getName()=="MCQ")){
			
			BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
			
			
			if(question.getClass().getName()=="MCQ"){
				MCQ mcq = (MCQ) question;
				System.out.println("You are only permitted to enter upto "+ mcq.choices.size()+" response." );
			
			
			System.out.println("Enter number of correct answers according to you");
			Integer k=Integer.parseInt(br3.readLine());
			
			if(mcq.choices.size()<k){
				System.out.println("You can not enter response more than options provided. Try again.");
				addUserResponses(question);
				
			}
			
			else {
				if(k>1){
					System.out.println("Please write "+k+" responses. Write options number only ");
					for(int i=0;i<k;i++){
						String input;
						try {
							input = br3.readLine();
							RCA.addElement(input);
							}
						catch (IOException e) {
							e.printStackTrace();
							}
						}
					}
				else{
					System.out.println("Please write one response only. Write options number only ");
					String input;
					try {
						input = br3.readLine();
						RCA.addElement(input);
						} 
					catch (IOException e) {
						e.printStackTrace();
						}	
					}
				
			}
			
		}
			
			else if(question.getClass().getName()=="ShortAnswer"){
				System.out.println("Enter number of correct answers according to you");
				Integer k=Integer.parseInt(br3.readLine());
			if(k>1){
				System.out.println("Please write "+k+" responses. ");
				for(int i=0;i<k;i++){
					String input;
					try {
						input = br3.readLine();
						RCA.addElement(input);
						}
					catch (IOException e) {
						e.printStackTrace();
						}
					}
				}
			else{
				System.out.println("Please write one response only. ");
				String input;
				try {
					input = br3.readLine();
					RCA.addElement(input);
					} 
				catch (IOException e) {
					e.printStackTrace();
					}	
				}
			}
			
		}
		
		
		
		}
	
	}
