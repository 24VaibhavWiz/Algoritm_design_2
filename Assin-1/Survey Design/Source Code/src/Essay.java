import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Essay extends Question implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	public Essay() {
		
		}	
	
	public void createques(){
		try {
			super.getPrompt();
			} 
		catch (IOException e) {
			e.printStackTrace();
			}
		}

	public void display(IO IO) {
		IO.display(prompt);
		IO.display("\n");
		}
	
	public void modifyy(){
		System.out.println(this.prompt);
		System.out.println("Do you wish to modify the prompt?");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		String prompt;
		try {
			prompt = br1.readLine();
			if(prompt.toLowerCase().equals("yes"))
				super.editPrompt();
			} 
		catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}