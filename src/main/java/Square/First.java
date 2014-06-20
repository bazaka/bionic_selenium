package Square;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 16.06.14
 * Time: 19:18
 * To change this template use File | Settings | File Templates.
 */
public class First  {

    static Scanner reader = new Scanner(System.in);
    public static void main (String[] args) {

            System.out.println("Введите коэффициенты квадратного уравнения");

            int a = reader.nextInt();
            int b = reader.nextInt();
            int c = reader.nextInt();

            Double d = Math.sqrt(b*b - 4*c);

            Double x1 = ((-b-d) / 2*a);
            Double x2 = ((-b+d) / 2*a);

            if (d>0) System.out.println(x1 + " ," + x2);

            else if (d==0) System.out.println("Уравнение имеет два одинаковых корня:" + x1);
            else System.out.println("Уравнение не имеет корней");

        }
}
