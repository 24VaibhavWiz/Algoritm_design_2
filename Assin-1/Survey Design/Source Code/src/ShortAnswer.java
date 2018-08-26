import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ShortAnswer extends Essay {

	private static final long serialVersionUID = 1L;
	private int wordlimit;

	public ShortAnswer() {
		
		}
		
	public void createques(){
		try {
			super.getPrompt();
			} 
		catch (IOException e) {
			e.printStackTrace();
			}
		System.out.println("Enter wordlimit in character/s below for the user;eg- 50 means 50 charaters");
		Scanner reader1 = new Scanner(System.in);
		int n = reader1.nextInt();
		wordlimit=n;
		}

	public ShortAnswer(int parameter) {
		
		}

	public int getWordlimit() {
		return this.wordlimit;
		}

	public void setWordlimit(int wordlimit) {
		this.wordlimit = wordlimit;
		}

	public void display(IO IO) {
		IO.display(prompt);
		IO.display("word limit is -"+wordlimit);
		IO.display("\n");
		}
	
	public void modifyy(){
		System.out.println(this.prompt);
		System.out.println("Do you wish to modify the prompt?");
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		try {
			String prompt = br1.readLine();
			if(prompt.toLowerCase().equals("yes"))
				super.editPrompt();
			System.out.println("Do you want to change word limit");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			prompt = br.readLine();
			if(prompt.toLowerCase().equals("yes")){ 
				Scanner in = new Scanner(System.in);
				int nlimit = in.nextInt();
				this.wordlimit=nlimit;
				}
			} 
		catch (IOException e) {
			modifyy();
			}
		}

	}