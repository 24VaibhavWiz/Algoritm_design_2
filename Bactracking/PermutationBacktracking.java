package programming_projects;
import java.util.*;
//import java.awt.Color;
//import java.awt.event.ActionEvent;
/*class color {

	private javax.swing.JLabel label1;
	private Color cl1 = Color.red;
	private Color cl2 = Color.blue;
	private int count;
	
	public color(javax.swing.JLabel label1)
	{
		this.label1 = label1;
	}
	
	public void action(ActionEvent e)
	{
		if(count % 2 == 0)
			label1.setForeground(cl1);
		else
			label1.setForeground(cl2);
		count++;
	}
}*/
@SuppressWarnings("resource")
public class PermutationBacktracking {

	public static void main(String args[]) throws InterruptedException
	{
		Scanner sc = new Scanner (System.in);
		System.out.print("Please enter your String : ");
		String str =sc.nextLine();
		int n = str.length();
		System.out.println("Permuting given String : ");
		Thread.sleep(2000);
		PermutationBacktracking permute = new PermutationBacktracking();
		permute.perm(str, 0, n-1);
	}
	
	public void perm(String str, int x, int y)
	{	
		if(x==y)
			System.out.println(" "+str);
		else
		{
			for (int i = 0; i < y; i++) {
				str = swap(str,x,i);
				perm(str,x+1,y);
				str = swap(str,x,i);
			}
		}
	}
	
	public String swap(String str, int a, int b)
	{
		char temp;
		char[] charArr = str.toCharArray();
		temp = charArr[a];
		charArr[a] = charArr[b];
		charArr[b] = temp;
		return
				String.valueOf(charArr);
	}
}
