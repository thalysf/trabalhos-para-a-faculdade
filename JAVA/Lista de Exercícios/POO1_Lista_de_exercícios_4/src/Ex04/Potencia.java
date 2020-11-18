
package Ex04;

public class Potencia {
    public static int Multiplica(int x, int y)
    {
       if(y == 0) return 0;
        return x + Multiplica(x, y - 1);
    }
    public static int Potencia(int x, int y)
    {
        int res = x;
       for(int i = y - 1; i >= 1; i--){
           res = Multiplica(res, x);
        }
      return res;
    }
}
