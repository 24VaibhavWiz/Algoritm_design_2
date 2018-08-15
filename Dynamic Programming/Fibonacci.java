package programming_projects;
import java.util.*;
//Fibonacci Series using Recursion
class fibo
{
	static int MAX = 1000;
	static int f[];
	static int fib1(int n)
	{
		if (n <= 1)
			return n;
		return fib1(n-1) + fib1(n-2);
	}
// using dynamic programming
	
	static int fib2(int n)
    {
		int f[] = new int[n+2];
		int i;
		f[0] = 0;
		f[1] = 1;
		for (i = 2; i <= n; i++)
		{
			f[i] = f[i-1] + f[i-2];
		} 
      	return f[n];
     }

// Java program for Fibonacci Series using Space
// Optimized Method

	static int fib3(int n)
    {
		int a = 0, b = 1, c;
        if (n == 0)
              return a;
        for (int i = 2; i <= n; i++)
        {
             c = a + b;
             a = b;
             b = c;
         }
         return b;
      }

    static int fib4(int n)
    {
    int F[][] = new int[][]{{1,1},{1,0}};
    if (n == 0)
        return 0;
    power1(F, n-1);
     
       return F[0][0];
    }
      
     /* Helper function that multiplies 2 matrices F and M of size 2*2, and
     puts the multiplication result back to F[][] */
    
    static void multiply(int F[][], int M[][])
    {
    	int x =  F[0][0]*M[0][0] + F[0][1]*M[1][0];
    	int y =  F[0][0]*M[0][1] + F[0][1]*M[1][1];
    	int z =  F[1][0]*M[0][0] + F[1][1]*M[1][0];
    	int w =  F[1][0]*M[0][1] + F[1][1]*M[1][1];
      
    	F[0][0] = x;
    	F[0][1] = y;
    	F[1][0] = z;
    	F[1][1] = w;
    }
 
    /* Helper function that calculates F[][] raise to the power n and puts the
    result in F[][]
    Note that this function is designed only for fib() and won't work as general
    power function */
    
    static void power1(int F[][], int n)
    {
    	int i;
    	int M[][] = new int[][]{{1,1},{1,0}};
     
    // n - 1 times multiply the matrix to {{1,0},{0,1}}
    
    	for (i = 2; i <= n; i++)
    		multiply(F, M);
    }


//Fibonacci Series using  Optimized Method

  /* function that returns nth Fibonacci number */
  static int fib5(int n)
  {
	  int F[][] = new int[][]{{1,1},{1,0}};
	  if (n == 0)
		  return 0;
	  power1(F, n-1);
    
	  return F[0][0];
  }
    
  static void multiply1(int F[][], int M[][])
  {
	  int x =  F[0][0]*M[0][0] + F[0][1]*M[1][0];
	  int y =  F[0][0]*M[0][1] + F[0][1]*M[1][1];
	  int z =  F[1][0]*M[0][0] + F[1][1]*M[1][0];
	  int w =  F[1][0]*M[0][1] + F[1][1]*M[1][1];
   
	  F[0][0] = x;
	  F[0][1] = y;
	  F[1][0] = z;
	  F[1][1] = w;
  }
    
  /* Optimized version of power() in method 4 */
  static void power(int F[][], int n)
  {
	  if( n == 0 || n == 1)
		  return;
	  int M[][] = new int[][]{{1,1},{1,0}};
    
	  power1(F, n/2);
	  multiply(F, F);
    
	  if (n%2 != 0)
		  multiply(F, M);
  }

//Java Program to find n'th fibonacci 
  
 // Returns n'th fibonacci number using 
 // table f[]
 public static int fib6(int n)
 {
     // Base cases
     if (n == 0)
         return 0;
          
     if (n == 1 || n == 2)
         return (f[n] = 1);
   
     // If fib(n) is already computed
     if (f[n] != 0)
         return f[n];
   
     int k = (n & 1) == 1? (n + 1) / 2
                         : n / 2;
   
     // Applyting above formula [Note value
     // n&1 is 1 if n is odd, else 0.
     f[n] = (n & 1) == 1? (fib6(k) * fib6(k) + 
                     fib6(k - 1) * fib6(k - 1))
                    : (2 * fib6(k - 1) + fib6(k)) 
                    * fib6(k);  
     return f[n];
 }
 public static void selection()
 {
		System.out.println("Please enter your choice for the following Fibonacii Methods (using)");
		System.out.println();
		System.out.println("1.Recursion");
		System.out.println("2.Dynamic Programming");
		System.out.println("3.Space Optimized");
		System.out.println("4.Poweer of the Matrix");
		System.out.println("5.Optimized");
		System.out.println("6.O(Log(n))");
		System.out.println();
		System.out.println("Your choice:-");
		System.out.println();
 }
	public static void main(String []args)
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (System.in);
		while(true)
		{	
			selection();
			int ch=sc.nextInt();
			if(ch==1)
			{
				System.out.println();
				System.out.println("Please enter your range of fibonacii");
				System.out.println();
				int n=sc.nextInt();
				System.out.println();
				System.out.println(" Answer is "+fib1(n));
				System.out.println();
				System.out.println("Do you want to continue (y/n)");
				System.out.println();
				char ch2=sc.next().charAt(0);
				if(ch2=='y')
				{
					System.out.println();
					selection();
					ch=sc.nextInt();
				}
				else
					System.exit(0);
			}
			else if(ch==2)
			{
				System.out.println();
				System.out.println("Please enter your range of fibonacii");
				System.out.println();
				int n=sc.nextInt();
				System.out.println();
				System.out.println("Answer is "+fib2(n));
				System.out.println();
				System.out.println("Do you want to continue (y/n)");
				System.out.println();
				char ch2=sc.next().charAt(0);
				if(ch2=='y')
				{
					System.out.println();
					selection();
					ch=sc.nextInt();
				}
				else
					System.exit(0);
			}
			else if(ch==3)
			{
				System.out.println();
				System.out.println("Please enter your range of fibonacii");
				System.out.println();
				int n=sc.nextInt();
				System.out.println();
				System.out.println("Answer is "+fib3(n));
				System.out.println();
				System.out.println("Do you want to continue (y/n)");
				System.out.println();
				char ch2=sc.next().charAt(0);
				if(ch2=='y')
				{
					System.out.println();
					selection();
					ch=sc.nextInt();
				}
				
				else
					System.exit(0);
			}
			else if(ch==4)
			{
				System.out.println();
				System.out.println("Please enter your range of fibonacii");
				System.out.println();
				int n=sc.nextInt();
				System.out.println();
				System.out.println("Answer is "+fib4(n));
				System.out.println();
				System.out.println("Do you want to continue (y/n)");
				System.out.println();
				char ch2=sc.next().charAt(0);
				if(ch2=='y')
				{
					System.out.println();
					selection();
					ch=sc.nextInt();
				}
				else
					System.exit(0);
			}
			else if(ch==5)
			{
				System.out.println();
				System.out.println("Please enter your range of fibonacii");
				System.out.println();
				int n=sc.nextInt();
				System.out.println();
				System.out.println("Answer is "+fib5(n));
				System.out.println();
				System.out.println("Do you want to continue (y/n)");
				System.out.println();
				char ch2=sc.next().charAt(0);
				if(ch2=='y')
				{
					System.out.println();
					selection();
					ch=sc.nextInt();
				}
				else
					System.exit(0);
			}
			else if(ch==6)
			{
				System.out.println();
				System.out.println("Please enter your range of fibonacii");
				System.out.println();
				int n=sc.nextInt();
				f= new int[MAX];
				System.out.println();
				System.out.println("Answer is "+fib6(n));
				System.out.println();
				System.out.println("Do you want to continue (y/n)");
				System.out.println();
				char ch2=sc.next().charAt(0);
				if(ch2=='y')
				{
					System.out.println();
					selection();
					ch=sc.nextInt();
				}
				else
					System.exit(0);
			}
			else 
			{
				System.out.println();
				System.out.println("Sorry Wrong choice");
				System.exit(0);
			}		
		}
	}
}
