import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class MainTest
{

    @Test
    public void testMain()
    {
        double eps = 0.001;
        double delta = 0.0005;

        double[][] testSet = {
                {8, -36, 54, -27},
                {8, 12, 6, 1},
                {1, 9, 27, 27},
                {1, 4, -3, -18},
                {1, -2, -16, 32},
                {3, 9, 1, 3},
                {2, -7, 4, -14},
                {-1, -5, 4, 20},
                {3, -3, -0.75, 0.75},
                {1, 5, 3, -9},
                {1, -21, 111, -91}
        };

        double[][] ansSet = {
                {1.5},
                {-0.5},
                {-3},
                {2, -3},
                {4, -4, 2},
                {-3},
                {3.5},
                {-5, 2, -2},
                {-0.5, 1, 0.5},
                {1, -3},
                {1, 13, 7},
        };

        System.out.println("Tests with eps="+eps+" and delta="+delta);

        boolean ok = true;
        for(int i = 0;i < testSet.length;i++)
        {
            var sol = Main.getSolution(eps, delta, testSet[i][0], testSet[i][1], testSet[i][2], testSet[i][3]);
            var ans = getList(ansSet[i]);
            System.out.print(sol);
            System.out.print(" vs ");
            System.out.print(ans);
            if(!equalLists(eps, Main.getSolution(eps, delta, testSet[i][0], testSet[i][1], testSet[i][2], testSet[i][3]), getList(ansSet[i])))
            {
                ok = false;
                System.out.println(" - false");
                break;
            }
            System.out.println(" - ok");
        }

        Assert.assertEquals(ok, true);
    }

    public List<Double> getList(double[] arr)
    {
        return DoubleStream.of(arr).boxed().collect(Collectors.toList());
    }

    public boolean equalLists(double eps, List<Double> one, List<Double> two)
    {
        if (one == null && two == null)
            return true;

        if(one.size() != two.size())
            return false;

        //to avoid messing the order of the lists we will use a copy
        //as noted in comments by A. R. S.
        one = new ArrayList<>(one);
        two = new ArrayList<>(two);

        Collections.sort(one);
        Collections.sort(two);

        boolean ok = false;
        for(int i = 0; i < two.size(); i++)
        {
            for(int j = 0; j < one.size(); j++)
                if(Math.abs(one.get(i) - two.get(i)) < eps*2)
                {
                    ok = true;
                    break;
                }

            if(ok)
                ok = false;
            else
                return false;
        }

        return true;
    }
}