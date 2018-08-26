import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TF extends MCQ implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	public TF() throws IOException {
 
		}

	public void createques(){
		try {
			super.getPrompt();
			} 
		catch (IOException e) {
			e.printStackTrace();
			}
		choices.add("True");
		choices.add("False");
		}
	
	public void modifyy(){
		System.out.println(this.prompt);
		String prompt = null;
		System.out.println("Do you wish to modify the prompt?");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		try {
			String prompt1 = br1.readLine();
			if(prompt1.toLowerCase().equals("yes")){
				System.out.println("Enter a new Prompt");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				prompt = br.readLine();
				this.prompt = prompt;
				} 	
			}
		catch (IOException e) {
			System.out.println("Error, please try again");
			}
		}

	}