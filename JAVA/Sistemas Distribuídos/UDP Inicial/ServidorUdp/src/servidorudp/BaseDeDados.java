/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorudp;


import java.util.ArrayList;


public class BaseDeDados {
    private ArrayList lista = null;
    
    public BaseDeDados () {
        lista = new ArrayList();
    }
    
    public void insere(String msg){
        lista.add(msg.trim());
    }
    
    public String le(){
        String s = "\n";
        int fim = lista.size();
        
        for(int pos = 0; pos < fim; pos ++){
            s = s + "[" + (pos + 1) + "] " + (String) lista.get(pos) + "\n";
        }
        System.out.println(s);
        return s;
    }
}
