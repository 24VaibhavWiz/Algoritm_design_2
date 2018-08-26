import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;

public class Ranking extends Question {

	
	private static final long serialVersionUID = 1L;
	protected Vector<String> leftList;

	public Ranking() {
		leftList=new Vector<String>();
		}
	
	public void createques(){
		try {
			super.getPrompt();
			System.out.println("Enter no of choices you want");
			Scanner reader1 = new Scanner(System.in);
			int n = reader1.nextInt();
			for(int i=1;i<=n;i++){
				System.out.println("Enter choice " + i);
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String choices_;
				try {
					choices_ = br.readLine();
					leftList.add(choices_);	
					} 
				catch (IOException e) {
					e.printStackTrace();
					}
				}	
			} 
		catch (IOException e) {
			e.printStackTrace();
			}	
		}
	
	public Vector<String> getLeftList() {
		return this.leftList;
		}

	public void setLeftList(Vector<String> leftList) {
		this.leftList = leftList;
		}
	
	public void display(IO IO) {
		IO.display(this.prompt);
		for(int i=0;i<leftList.size();i++){
			IO.display( "option-"+(i+1)+") " +leftList.elementAt(i)+" ");
			}
		IO.display("\n");
		}
	
	public void modifyy() {
		System.out.println(this.prompt);
		System.out.println("Do you wish to modify the prompt?");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		String res;
		try {
			res = br1.readLine();
			if(res.toLowerCase().equals("yes"))
				super.editPrompt();
			} 
		catch (IOException e) {
				modifyy();
			}
		for(int i=0;i<leftList.size();i++){  
			  System.out.println("    " +(i+1)+":"+leftList.elementAt(i)+"  ");
			}
		System.out.println("Do you wish to modify the choices ?");
		try {
			res = br1.readLine();
			if(res.toLowerCase().equals("yes")){
				System.out.println("Which choice do you want to modify? Enter option number only");
				for(int i=0;i<leftList.size();i++){
					System.out.println( "option-"+(i+1)+") " +leftList.elementAt(i)+" ");	
					}
				System.out.print("\n");
				String prompt1 = br1.readLine();
				System.out.println("Enter new value for choice");
				String	 newValue = br1.readLine();
				leftList.setElementAt(newValue, (Integer.parseInt(prompt1)-1));	
				}	
			} 
		catch (IOException e) {
			e.printStackTrace();
			}
		}
	
	}