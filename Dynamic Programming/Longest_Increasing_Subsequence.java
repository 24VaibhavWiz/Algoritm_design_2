// Uasing Dynamic Programming 
// Time Complexity O(n^2)

package programming_projects;
import java.util.*;
public class Longest_Increasing_Subsequence {
	static int lis(int arr[],int n)
	{
		int lis[] = new int[n];
		int max=0;
		for (int i = 0; i < n; i++) {
			lis[i]=1;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && lis[i] < lis[j] +1)
					lis[i]=lis[j]+1;
			}
		}
		for (int i = 0; i < n; i++) {
			if(max < lis[i])
				max = lis[i];
		}
		return max;
	}
	@SuppressWarnings("resource")
	public static void main(String args[])
	{
		int size;
		Scanner sc = new Scanner (System.in);
		System.out.println("Please enter your Array size");
		size=sc.nextInt();
		int arr[] = new int[size];
		System.out.println();
		System.out.println("Please enter your Array");
		for (int i = 0; i < size; i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println();
		System.out.println("The Length of Longest Increasing Subsequence(LIS) is "+lis(arr, size));
		
	}
}
