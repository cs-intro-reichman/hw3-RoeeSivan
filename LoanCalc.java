// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) {	
		// Replace the following statement with your code
		double sum=0;
		sum =loan;
		for(int i=0;i<n;i++)
		{
			sum=(sum - payment)*(1+rate/100);
		}
		return sum;
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		//
		iterationCounter=0;
		double g = loan/n; // first current guess
		double f = endBalance(loan, rate, n, g);
		while(f>0)
		{
			g=g+epsilon;
			f = endBalance(loan, rate, n, g);
			iterationCounter++;
		}
		return g;
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
        // Replace the following statement with your code
		iterationCounter=0;
		double h= loan*(1+rate)/n;
		double fl=endBalance(loan, rate, n, 1),fh=endBalance(loan, rate, n, h);// setting the upper and lower bounds
		double l =0;
		double g = (l+h)/2.0; //inital start for g;
		double fg=0;
		while((h-l)>epsilon) // checking the length of our interval
		{	
			g=(l+h)/2.0; //update 
			fg =  endBalance(loan, rate, n, g);
			if( fg==0 || ((h-l)<=epsilon))
			{
				iterationCounter++;
				return g;
			}	
			if(fg*fl>=0)
			{
				l=g;
				iterationCounter++;
				fl= fg; //updating the lower end
			}
			else
			{
				h=g;
				iterationCounter++;
				fh=fg; //updating the upper end;
			}
	}
	iterationCounter+=3;
		return g;
    }

}