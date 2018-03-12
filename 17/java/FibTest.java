// Java program to compute n-th Fibonacci
// number where n may be large.
import java.io.*;
import java.util.*;
import java.math.*;

public class FibTest
{
    // Returns n-th Fibonacci number
    static BigInteger fib(int n)
    {
        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger c = BigInteger.valueOf(1);
        for (int j=0 ; j<n ; j++)
        {
            c =  a.add(b);
            a = b;
            b = c;
        }

        return (a);
    }

    public static void main(String[] args)
    {
        int n = 54675;
        System.out.println("Fibonacci of " + n +
            "th term" + " " +"is" +" " + fib(n));

            int[] arr = getArr(fib(n));
            int sum = 0;
            for(int i : arr)
                sum+=i;
            System.out.println(sum);


            System.out.println("question 4");
            factorial(n);

    }
    public static int[] getArr(BigInteger num)
    {
        String str = num.toString();
        int[] arr = new int[str.length()];
        for (int i=0; i<arr.length; i++)
             arr[i] = str.charAt(i)-'0';
        return arr;
    }
    public static BigInteger factorial(int n){
        BigInteger factorial = BigInteger.ONE;
        int count = 0;
        for(int i = n; i > 0; i --){
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        String str1 = factorial.toString();
        for(int j = str1.length() - 1; j > -1; j--) {
            if(Character.digit(str1.charAt(j), 10) != 0) {
                System.out.println(count);
                break;
            } else {
                count++;
            }
        }
        System.out.println(count);
        return factorial;
    }
}
