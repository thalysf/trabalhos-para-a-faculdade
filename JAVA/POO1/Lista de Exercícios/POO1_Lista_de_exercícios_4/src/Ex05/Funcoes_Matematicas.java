package Ex05;

public class Funcoes_Matematicas {
    public static double divisao(int x, int y)
    {
        return (double) ((double) x / (double) y);
    }
    public static int subtracao(int x, int y)
    {
        return (x - y);
    }
    public static int adicao(int x, int y)
    {
        return (x + y);
    }
    public static int multiplica(int x, int y)
    {
       if(y == 0) return 0;
        return x + multiplica(x, y - 1);
    }
    public static int potencia(int x, int y)
    {
        int res = x;
       for(int i = y - 1; i >= 1; i--){
           res = multiplica(res, x);
        }
      return res;
    }
}
