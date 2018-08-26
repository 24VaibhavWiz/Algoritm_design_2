import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Question implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	protected String prompt;

	public void setPrompt(String prompt) {
		this.prompt = prompt;
		}

	public void getPrompt() throws IOException {
		System.out.println("Enter prompt for question");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String abc=br.readLine();
		this.setPrompt(abc);	
		}

	public void display(IO iO) {
		
		}

	public void createques() {
		
		}
	
	public void editPrompt() {
		
		System.out.println("Enter a new Prompt");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String prompt=this.prompt;
		try {
			prompt = br.readLine();
			} 
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("invalid format");
			}
			this.prompt = prompt;
		}
	
	public void modifyy() {
		
		}

	public void displayPrompt() {
		System.out.println(this.prompt);
		}
	
	}