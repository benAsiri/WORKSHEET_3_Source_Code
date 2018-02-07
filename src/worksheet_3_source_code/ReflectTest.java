/**
 * Used in Practical 3: Reflection.
 *
 * @author David Cooper
 */

import worksheet_3_source_code.Elephant;

public class ReflectTest extends Elephant 
{
    public String name ;
    
    private String age;
    public String s;
    public  String a="1";
    
    public static void arthurDent(int n)
    {
        if(n == 42)
        {
            while(true)
            {
                System.out.print("The mice did it. ");
            }
        }
        else
        {
            System.out.println("I seem to be having tremendous difficulty with my lifestyle.");
        }
    }

//     public static hanlon()
//     {
//         Systemm.out.println("Never attribute to malice that which is adequately explained by stupidity.");
//     }

    public static String bottleOfBeer(int n)
    {
        String s;

        if(n < 0)
        {
            throw new IndexOutOfBoundsException("Negative beer not allowed.");
        }

        switch(n)
        {
            case 0:
                s = "no bottles";
                break;

            case 1:
                s = "1 bottle";
                break;

            default:
                s = n + " bottles";
        }

        return s + " of beer on the wall";
    }

    private static int sum = 0;
    public static int add(int n)
    {
        sum += n;
        return sum;
    }

    public static void colour(int n)
    {
        n += 1;
        int high = n / 8;
        int low = (n % 8) + 30;
        System.out.print("\033[" + high + ";" + low + "m");
    }
}
