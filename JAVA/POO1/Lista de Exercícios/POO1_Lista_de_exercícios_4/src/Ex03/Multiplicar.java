/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex03;

/**
 *
 * @author thaly
 */
public class Multiplicar {
    public static int Multiplica(int x, int y)
    {
       if(y == 0) return 0;
        return x + Multiplica(x, y - 1);
    }
}
