public class RangeFinder
{
    /**
     * Dichotomy method.
     * @param eq - our equation
     * @param eps - required accuracy
     * @param delta - step of moving on infinite interval
     * @param a - left interval edge
     * @param b - right interval edge
     * @return - root of equation on interval
     */
    public static double findRootAt(Equation eq, double eps, double delta, double a, double b)
    {
        if(Double.isInfinite(a) && Double.isInfinite(b))
            return Double.NaN;

        double root = Double.NaN;
        double na = a, nb = b;

        if(Double.isInfinite(a) && Double.isFinite(b))
        {
            if(a == Double.POSITIVE_INFINITY)
                throw new IllegalArgumentException("Left edge of interval is POSITIVE_INFINITY");

            while(true)
                if(eq.calc(nb - delta) < 0)
                    return findRootAt(eq, eps, delta, nb - delta, nb);
                else
                    nb -= delta;

        }else if(Double.isFinite(a) && Double.isInfinite(b))
        {
            if(b == Double.NEGATIVE_INFINITY)
                throw new IllegalArgumentException("Right edge of interval is NEGATIVE_INFINITY");

            while(true)
                if(eq.calc(na + delta) > 0)
                    return findRootAt(eq, eps, delta, na, na + delta);
                else
                    na += delta;

        }else if(Double.isFinite(a) && Double.isFinite(b))
        {
            double mid;

            if(eq.calc(na) > eq.calc(nb))
            {
                var tmp = na;
                na = nb;
                nb = tmp;
            }

            while(Double.isNaN(root))
            {
                mid = (na + nb) / 2;

                if(Math.abs(eq.calc(mid)) < eps)
                    root = mid;
                else if(eq.calc(mid) > eps)
                    nb = mid;
                else if(eq.calc(mid) < -eps)
                    na = mid;
            }
        }

        return root;
    }
}
