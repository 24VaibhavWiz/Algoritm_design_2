// Uasing Dynamic Programming 
// Time Complexity O(nlogn)

package programming_projects;

import java.util.Scanner;

public class LIS {
	static int index(int arr[],int l,int r,int key)
	{
		while((r-l) > 1)
		{
			int m = (r+l)/2;
			if(arr[m] >= key)
				r=m;
			else
				l=m;
		}
		return r;
	}
	static int Longest_Increasing_Subsequence(int arr[],int size)
	{
		int[] Table   = new int[size];
        int length;
 
        Table[0] = arr[0];
        length = 1;
        for (int i = 1; i < size; i++)
        {
            if (arr[i] < Table[0])
                Table[0] = arr[i];
 
            else if (arr[i] > Table[length-1])
                Table[length++] = arr[i];
 
            else
                Table[index(Table, -1, length-1, arr[i])] = arr[i];
        }
 
        return length;
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
		System.out.println("The Length of Longest Increasing Subsequence(LIS) is "+Longest_Increasing_Subsequence(arr, size));
		
	}
}

