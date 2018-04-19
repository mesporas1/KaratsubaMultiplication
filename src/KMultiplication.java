import java.math.BigInteger;

public class KMultiplication {

    public static void main(String[] args) {
       // BigInteger a = new BigInteger("31415926535897932384626433832795");
     //   BigInteger b = new BigInteger("02884197169399375105820974944592");
     //   BigInteger c = new BigInteger("27182818284590452353602874713526");
    //    BigInteger d = new BigInteger("62497757247093699959574966967627");
       // String dead = "62497757247093699959574966967627";
     //   String e = "12345678";
      //  String f = "56789101";
        //  System.out.println(e.substring(0,2));
        //  System.out.println(e.substring(2));
        String test1 = "3141592653589793238462643383279502884197169399375105820974944592";
       // String b = "02884197169399375105820974944592";
        String test2 = "2718281828459045235360287471352662497757247093699959574966967627";
      //  String d = "62497757247093699959574966967627");
       // String test = "5";
        //String test2 = "12";
        BigInteger z = product(test1, test2);
        System.out.println("The product is " + z.toString());

    }

    public static BigInteger product(String x, String y) {
        // BigInteger one = new BigInteger("1");
        //Beginning Variables
        int m;
        m = x.length();
        BigInteger result = BigInteger.ZERO, m1 = BigInteger.TEN, m2 = BigInteger.TEN;
        m1 = m1.pow(m); // this is 10 ^ n
        m2 =  m2.pow(m/2); // this is 10 ^ (n/2)
        BigInteger ac, bd, ab, cd, abcd, ad, bc;
        String a, b, c, d;

        if (m > 1) {
            a = x.substring(0, m / 2);
            b = x.substring(m / 2);
            c = y.substring(0, m / 2);
            d = y.substring(m / 2);


            //Calculate a*c
            ac = product(a, c);
            System.out.println("The value of ac is " + ac);

            //calculate b*d
            bd = product(b, d);
            System.out.println("The value of bd is " + bd);

            //calculate (a+b)*(c+d) - ac -bd // ac + ad +bc + bd
         /*   ab = new BigInteger(a).add(new BigInteger(b));
            cd = new BigInteger(c).add(new BigInteger(d));
            abcd = product(ab.toString(), cd.toString());
            abcd = abcd.subtract(ac);
            abcd = abcd.subtract(bd); */

            ad = product(a,d);
            bc = product(b,c);
            abcd = ad.add(bc);

            //Calculate (10^n) * ac + (10^((n/2)) * (ad+bc) + bd;
            result = result.add(m1.multiply(ac));
            result = result.add(m2.multiply(abcd));
            result = result.add(bd);


        } else if (m == 1) {
            BigInteger p1, p2;
            p1 = new BigInteger(x);
            p2 = new BigInteger(y);
            System.out.println("The product of the last digits is " + p1.multiply(p2));
            return (p1.multiply(p2));

        }


        return result;
    }
}
 /*   if (y.compareTo(x) == 1) {
            return product(y, x);
        } else if (!y.equals(BigInteger.ZERO)) {
            System.out.println(y.toString());
            return (x.add(product(x, y.subtract(BigInteger.ONE))));
        } else {
            return (BigInteger.ZERO);
        }*/
