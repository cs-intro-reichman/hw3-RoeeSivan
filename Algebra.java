
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3 good
	    System.out.println(minus(7,2));  // 7 - 2 good
   		System.out.println(minus(2,7));  // 2 - 7 good
 		System.out.println(times(3,4));  // 3 * 4  good
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2 good
   		System.out.println(pow(5,3));      // 5^3 good
   		System.out.println(pow(3,5));      // 3^5 good
   		System.out.println(div(12,3));   // 12 / 3  good  
   		System.out.println(div(5,5));    // 5 / 5  good
   		System.out.println(div(25,7));   // 25 / 7 good
   		System.out.println(mod(25,7));   // 25 % 7 good
   		System.out.println(mod(120,6));  // 120 % 6    0
   		System.out.println(sqrt(36)); //
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  
	public static int abs(int x)//a method that will help me in the future - absolute value
	{
		if(x<0)
		{
			return times(x,-1);
		}
		else
		{
			return x;
		}
	}
	public static double abs(double x)//a method that will help me in the future - absolute value
	{
		if(x<0)
		{
			return times(x,-1);
		}
		else
		{
			return x;
		}
	}

	

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// Replace the following statement with your code
		for(int i=0;i<x2;i++)
		{
			x1++;
		}
		return x1;
	}
	public static double plus(double x1, double x2) {
		// Replace the following statement with your code
		for(int i=0;i<x2;i++)
		{
			x1++;
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		for(int i=0;i<x2;i++)
		{
			x1--;
		}
		return x1;
	}
	public static double minus(double x1, double x2) {
		for(int i=0;i<x2;i++)
		{
			x1--;
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int x3=0;
		for(int i=0;i<x1;i++)
		{
			x3++;
			for(int j=1;j<x2;j++)
			{
				x3++;
			}
		}
		return x3;
	}
	public static double times(double x1, double x2) {
		double x3=0;
		for(double i=0;i<x1;i++)
		{
			x3++;
			for(double j=1;j<x2;j++)
			{
				x3++;
			}
		}
		return x3;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int x1=1;
		for(int i=0;i<n;i++)
		{
			x1=times(x1,x);
		}
		return x1;
	}

	// Returns the integer part of x1 / x2 checks home many times does x2 can be put into x1;
	public static int div(int x1, int x2)
	 {
		int x3=0;
		int sum=0;
		int i=1;
		if(x1<x2) return 0;
		while(sum<=minus(x1,x2))
		{
			x3++;
			sum =times(x2,i);
			 i++;
		}
		return x3;
  	}
	  public static double div(double x1, double x2)
	  {
		double x3=0;
		double sum=0;
		double i=1;
		 if(x1<x2) return 0;
		 while(sum<=minus(x1,x2))
		 {
			 x3++;
			 sum =times(x2,i);
			  i++;
		 }
		 return x3;
	   }
	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		 int r=0;
		 int num=0;
		 int mul=0;
		if(x1==x2) return 1;
		if(x1<x2) return x1;
		num = div(x1,x2);
		mul = times(num,x2);
		r= x1 - mul;
		return r;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) 
	{
		for(int i=0;i<=x;i++)
		{
			if (pow(i,2)==x)
			{
			return i;
			}
		}
		return 0;
	}
}