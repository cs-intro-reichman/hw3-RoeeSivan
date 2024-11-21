public class Algebra {
    public static void main(String args[]) {
        // Tests some of the operations
        System.out.println(plus(2, 3));   // 2 + 3 good
        System.out.println(minus(7, 2));  // 7 - 2 good
        System.out.println(minus(2, 7));  // 2 - 7 good
        System.out.println(times(3, 4));  // 3 * 4  good
        System.out.println(plus(2, times(4, 2)));  // 2 + 4 * 2 good
        System.out.println(pow(5, 3));      // 5^3 good
        System.out.println(pow(3, 5));      // 3^5 good
        System.out.println(div(12, 3));   // 12 / 3  good  
        System.out.println(div(5, 5));    // 5 / 5  good
        System.out.println(div(25, 7));   // 25 / 7 good
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
            for (int i = 0; i < x2; i++) {
                x1--;
            }
        }
        if ((x1 < 0) && (x2 > 0)) {
            for (int i = 0; i < x2; i++) {
                x1++;
            }
        }
        if ((x1 > 0) && (x2 < 0)) {
            for (int i = 0; i < x2; i++) {
                x1--;
            }
        }
        return x1;
    }

    public static double plus(double x1, double x2) {
        for (int i = 0; i < x2; i++) {
            x1++;
        }
        return x1;
    }

    // Returns x1 - x2
    public static int minus(int x1, int x2) {
        if ((x1 > 0) && (x2 > 0)) {
            for (int i = 0; i < x2; i++) {
                x1--;
            }
        }
        if ((x1 < 0) && (x2 < 0)) {
            for (int i = 0; i < abs(x2); i++) {
                x1++;
            }
        }
        if ((x1 < 0) && (x2 > 0)) {
            for (int i = 0; i < x2; i++) {
                x1++;
            }
        }
        if ((x1 > 0) && (x2 < 0)) {
            for (int i = 0; i < abs(x2); i++) {
                x1++;
            }
        }
        return x1;
    }

    // Returns x1 * x2
    public static int times(int x1, int x2) {
        int x3 = 0;
        if ((x1 > 0) && (x2 > 0)) {
            for (int i = 0; i < x1; i++) {
                x3++;
                for (int j = 1; j < x2; j++) {
                    x3++;
                }
            }
            return x3;
        }
        if ((x1 < 0) && (x2 < 0)) {
            for (int i = 0; i < x1; i++) {
                x3++;
                for (int j = 1; j < x2; j++) {
                    x3++;
                }
            }
            return x3;
        }
        if ((x1 < 0) || (x2 < 0)) {
            for (int i = 0; i < x1; i++) {
                x3++;
            }
            return times(-1, x3);
        }
        return x3; // Default return in case logic fails
    }

    // Returns x^n (for n >= 0)
    public static int pow(int x, int n) {
        int x1 = 1;
        for (int i = 0; i < n; i++) {
            x1 = times(x1, x);
        }
        return x1;
    }

    // Returns the integer part of x1 / x2
    public static int div(int x1, int x2) {
        int x3 = 0;
        int sum = 0;
        int i = 1;
        if (x1 < x2) return 0;
        while (sum <= minus(x1, x2)) {
            x3++;
            sum = times(x2, i);
            i++;
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
