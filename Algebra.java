public class Algebra {
    public static void main(String args[]) {
        // Tests some of the operations
        System.out.println(times(30, 1));  // -- works, == works
        System.out.println(times(-3, 5)); 
        System.out.println(times(-3, -5));      
        System.out.println(times(3, -5));           // 3^5 good
        System.out.println(mod(25, 7));   // 25 % 7 good
        System.out.println(mod(120, 6));  // 120 % 6    0
        System.out.println(sqrt(36));
        System.out.println(sqrt(263169));
        System.out.println(sqrt(76123));
    }

    public static int abs(int x) { // a method that will help me in the future - absolute value
        if (x < 0) {
            return times(x, -1);
        } else {
            return x;
        }
    }

    // Returns x1 + x2
    public static int plus(int x1, int x2) {
        if ((x1 > 0) && (x2 > 0)) {
            for (int i = 0; i < x2; i++) {
                x1++;
            }
        }
        if ((x1 < 0) && (x2 < 0)) {
            for (int i = 0; i > x2; i--) {
                x1--;
            }
        }
        if ((x1 < 0) && (x2 > 0)) {
            for (int i = 0; i < x2; i++) {
                x1++;
            }
        }
        if ((x1 > 0) && (x2 < 0)) {
            for (int i = 0; i > x2; i--) {
                x1--;
            }
        }
        return x1;
    }

    // Returns x1 - x2
    public static int minus(int x1, int x2)
     {
        if(x1==x2) return 0;
        if (x2 > 0) { // Decrement x1 by x2 times
            while (x2 > 0) {
                x1--;
                x2--;
            }
        } else if (x2 < 0) { // Increment x1 by (-x2) times
            while (x2 < 0) {
                x1++;
                x2++;
            }
        }
        return x1;
    }

    // Returns x1 * x2
    public static int times(int x1, int x2) {
        int x3 = 0;
        if((x1==0)||(x2==0)) return 0;
        if((x1>0)&&(x2>0))
        {
            for(int i =0;i<x1;i++)
            {
                for(int j=0;j<x2;j++)
                {
                    x3++;
                }
            }
        }
        if((x1<0)&&(x2<0)) // minus *minus
        {
            for(int i =0;i>x1;i--)
            {
                for(int j=0;j>x2;j--)
                {
                    x3++;
                }
            }
        }
        if((x1<0)&&(x2>0)) // minus *plus
        {
            for(int i =0;i>(x1);i--)
            {
                for(int j=0;j<(x2);j++)
                {
                    x3--;
                }
            }
        }
        if((x1>0)&&(x2<0)) // minus *plus
        {
            for(int i =0;i<(x1);i++)
            {
                for(int j=0;j>(x2);j--)
                {
                    x3--;
                }
            }
        }
        return x3; // 
    }

    // Returns x^n (for n >= 0)
    public static int pow(int x, int n) {
        int x1 = 1;
        for (int i = 0; i < n; i++) {
            x1 = times(x1, x);
        }
        if(n<0)
        {

        }
        return x1;
    }

    // Returns the integer part of x1 / x2
    public static int div(int x1, int x2) {
        int x3 = 0;
        int sum=0;
        int i=0;
        if(abs(x1)==abs(x2)) return 1;
        if((x1>0)&&(x2<0)||(x1<0)&&(x2>0))//checking ++ or --
        {
            while(sum<x1)
            {
                sum=times(x2,i);
                x3++;
                i++;
            }
            x3=times(-1,x3);
       }
        if((x1>0)&&(x2>0)||(x1<0)&&(x2<0))//checking ++ or --
        {
            if(abs(x1)<abs(x2)) //returning 0 if the divisor is bigger
            {
                return 0;
            }
            while(sum<x1)
            {
                sum=times(x2,i);
                x3++;
                i++;
            }
        }
        return x3;
    }

    // Returns x1 % x2
    public static int mod(int x1,int x2)
	{
		return x1;
    }

    // Returns the integer part of sqrt(x)
    public static int sqrt(int x) {
        for (int i = 0; i <= x; i++) {
            if (pow(i, 2) == x) {
                return i;
            }
        }
        return 0;
    }
}
