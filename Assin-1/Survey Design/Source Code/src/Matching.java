import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;

public class Matching extends Ranking {

	
	private static final long serialVersionUID = 1L;
	private Vector<String> rightList;

	public Matching() {
		rightList= new Vector<String>();
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
		System.out.println("Enter choice for left side");
		// loop for scanner twice and add choices 
		for(int i=0;i<n;i++){
			System.out.println("Enter choice " + (i+1));
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
		System.out.println("Enter choice for right side");
		for(int j=0;j<n;j++){
			System.out.println("Enter choice " + (j+1));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String choices_;
			try {
				choices_ = br.readLine();
				rightList.add(choices_);
				} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}	
			}
		}

	public Matching(String prompt, Vector<String> leftList, Vector<String> rightList) { 
		this.leftList = leftList;
		this.rightList = rightList;
		}

	public Vector<String> getRightList() {
		return this.rightList;
		}

	public void setRightList(Vector<String> rightList) {
		this.rightList = rightList;
		}

	public void display(IO IO) {
		IO.display(prompt);
		for (int i = 0; i < leftList.size(); i++){
			IO.display(Character.toString((char) (i+65))+") "+leftList.get(i)+"     "+(i+1)+") "+rightList.get(i));			
			}
		//Character.toString ((char) i);
		IO.display("\n");
		}
	
	// MODIFICATION 
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
			 System.out.println(Character.toString((char) (i+65))+":"+leftList.elementAt(i)+"        "+(i+1)+":"+rightList.elementAt(i));
			}
		try {
			System.out.println("Do you wish to modify left list ?");
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

		try {
			System.out.println("Do you wish to modify right list ?");
			String res1;
			res1 = br1.readLine();
			if((res1.toLowerCase().equals("yes"))){
				System.out.println("Which choice do you want to modify? Enter option number only");
				for(int i=0;i<rightList.size();i++){
					System.out.println( "option-"+(i+1)+") " +rightList.elementAt(i)+" ");	
					}
				System.out.print("\n");
				String prompt2 = br1.readLine();
				System.out.println("Enter new value for choice");
				String	 newValue = br1.readLine();
				rightList.setElementAt(newValue, (Integer.parseInt(prompt2)-1));
				}	
			} 
		catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}