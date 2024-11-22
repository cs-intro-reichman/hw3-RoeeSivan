public class Algebra {
    public static void main(String args[]) {
        // Tests some of the operations
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
        int i=0;
        boolean x1is_negative = x1<0;
        boolean x2is_negative = x2<0;
        if(x1==x2) return 1;
        if(abs(x1)==abs(x2)) return 1;
        if(abs(x2)>abs(x1)) return 0;
        if(x2==1) return x1;
        if(x2==0) return -1;
        if((x1>0)&&(x2>0)) // for plus plus
        {
        while(times(x3,x2)<=x1)
        {
            if ((times(x2, i)  <= x1))
            {
                x3++;
            }
        }
        return x3-1;
    }
        if((x1is_negative)&&(x2is_negative)) // for minus minus
        {
            for (i = 0; abs(times(x2, i)) < abs(x1); i++) 
            { 
                x3++;
            }
            return x3;
        }
        if((x1is_negative)&&(!x2is_negative)||((!x1is_negative)&&(x2is_negative))) //+-
        {
            for (i=0;abs(times(x2,i))<abs(x1);i++)
            {
                x3++;
            }
            x3=times(-1,x3);
        }
        return x3;
        }
    // Returns x1 % x2
    public static int mod(int x1,int x2)
	{
        int k = div(x1,x2);
        if((times(k,x2)==x1))   return 0;
        int r=0;
        r=minus(x1,times(k,x2));
		return r;
    }

    // Returns the integer part of sqrt(x)
    public static int sqrt(int x) {
        int result =0;
        for (int i = 0; i <= x; i++) {
            if (pow(i, 2) == x) 
            {
                return i;
            }
            else if ((pow(i,2)>x))
            {
                return i-1;
            }
        }
        return 0;
    }
}
