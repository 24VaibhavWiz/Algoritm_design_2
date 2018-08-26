
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;

public class MCQ extends Question  implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	protected Vector<String> choices=new Vector<String>();

	public MCQ() {
		
		}

	public void createques(){
		try {
			super.getPrompt();
			} 
		catch (IOException e) {
			e.printStackTrace();
			}
		System.out.println("Enter no of choices you want");
		Scanner reader1 = new Scanner(System.in);
		int n = reader1.nextInt();
		for(int i=1;i<=n;i++){
			System.out.println("Enter choice " + i);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String choices_;
			try {
				choices_ = br.readLine();
				choices.add(choices_);
				} 
			catch (IOException e) {
				e.printStackTrace();
				}
			}	
		}
	
	public Vector<String> getChoices() {
		return this.choices;
		}

	public void setChoices(Vector<String> choices) {
		this.choices = choices;
		}

	public void display(IO IO) {
		IO.display(this.prompt);
		for(int i=0;i<choices.size();i++){
			IO.display( "option-"+(i+1)+") " +choices.elementAt(i)+" ");	
			}
		IO.display("\n");
		}

	public void modifyy() {
		
		System.out.println(this.prompt);
		System.out.println("Do you wish to modify the prompt?");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		try {
			String prompt = br1.readLine();
			if(prompt.toLowerCase().equals("yes"))
				super.editPrompt();
			System.out.println("Do you wish to modify the Choices?");
			prompt = br1.readLine();
			if(prompt.toLowerCase().equals("yes")){
				System.out.println("Which choice do you want to modify? Enter option number only");
				for(int i=0;i<choices.size();i++){
					System.out.println( "option-"+(i+1)+") " +choices.elementAt(i)+" ");	
					}
				System.out.print("\n");
				prompt = br1.readLine();
				//choices.elementAt(Integer.parseInt(res));
				System.out.println("Enter new value for choice");
				String	 newValue = br1.readLine();
				choices.setElementAt(newValue, (Integer.parseInt(prompt)-1));		
				}
			} 
		catch (IOException e) {
			modifyy();
			}	
		}
		
	}