import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        if (args.length < 6)
        {
            System.out.println("Wrong arg size!");
            return;
        }

        for(String arg : args)
            if(getNum(arg) == null)
            {
                System.out.println("Wrong argument: " + arg);
                return;
            }

        double eps = Math.abs(getNum(args[0]));
        double delta = Math.abs(getNum(args[1]));

        Equation mainEq = Equation.getDefaultCubicEquation(getNum(args[3]) / getNum(args[2]),getNum(args[4]) / getNum(args[2]),getNum(args[5]) / getNum(args[2]));
        Equation derivative = Equation.getDerivative(mainEq);
        double dis = derivative.getDiscriminant();

        if(dis < 0)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("I found that derivative of equation is always positive, \n" +
                                "so root maybe one, or equation haven't root. I will try \n" +
                                "find root on interval (-oo, 0]. You are agree?(y/n)");
            char ans = ' ';

            while(ans  != 'y' && ans != 'n')
                ans = scan.next().charAt(0);

            if(ans == 'y')
                System.out.println("Root is " + RangeFinder.findRootAt(mainEq, eps, delta, Double.NEGATIVE_INFINITY, 0));
            else
                System.out.println("Well:c");
        }else if(dis == 0)
        {
            double derCalc = mainEq.calc(0);

            if(Math.abs(derCalc) < eps)
                System.out.println("Root is " + derCalc);
            else if(derCalc < -eps)
                System.out.println("Root is " + RangeFinder.findRootAt(mainEq, eps, delta, 0, Double.POSITIVE_INFINITY));
            else if(derCalc > eps)
                System.out.println("Root is " + RangeFinder.findRootAt(mainEq, eps, delta, Double.NEGATIVE_INFINITY, 0));
        }else if(dis > 0)
        {
            double x1 = (-derivative.getC() + Math.sqrt(dis)) / derivative.getB();
            double x2 = (-derivative.getC() - Math.sqrt(dis)) / derivative.getB();

            System.out.println(mainEq.calc(x1) + " " + mainEq.calc(x2));

            if(mainEq.calc(x1) > eps && mainEq.calc(x2) > eps) // f(x1) > e & f(x2) > e
                System.out.println("Root is " + RangeFinder.findRootAt(mainEq, eps, delta, Double.NEGATIVE_INFINITY, x1));
            else
                if(mainEq.calc(x1) < -eps && mainEq.calc(x2) < -eps) // f(x1) < -e & f(x2) < -e
                System.out.println("Root is " + RangeFinder.findRootAt(mainEq, eps, delta, x2, Double.POSITIVE_INFINITY));
            else
                if(mainEq.calc(x1) > eps && Math.abs(mainEq.calc(x2)) < eps) // f(x1) > e & |f(x2)| < e
                System.out.println("Root is " + x2 + " and " + RangeFinder.findRootAt(mainEq, eps, delta, Double.NEGATIVE_INFINITY, x1));
            else
                if(mainEq.calc(x2) < -eps && Math.abs(mainEq.calc(x1)) < eps) // f(x2) < -e & |f(x1)| < e
                System.out.println("Root is " + x1 + " and " + RangeFinder.findRootAt(mainEq, eps, delta, x2, Double.POSITIVE_INFINITY));
            else
                if(mainEq.calc(x1) > eps && mainEq.calc(x2) < -eps) // f(x1) > e & f(x2) < -e
                System.out.println("Root is " + RangeFinder.findRootAt(mainEq, eps, delta, x2, Double.POSITIVE_INFINITY));
            else
                if(Math.abs(mainEq.calc(x2)) < eps && Math.abs(mainEq.calc(x1)) < eps) // |f(x1)| < e & |f(x2)| < e
                System.out.println("Root is " + (x2 + x1) / 2);
        }
    }

    public static Double getNum(String str)
    {
        try
        {
            return Double.parseDouble(str);
        } catch (NumberFormatException e)
        {
            return null;
        }
    }
}
