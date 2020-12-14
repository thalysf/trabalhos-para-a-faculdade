package Aplicacao;

import Entidades.Trabalhador;
import static Interface.TerminalMenu.menuTrab;
import java.text.ParseException;

public class App {

    public static void main(String[] args) throws ParseException {
      Trabalhador trab01 = menuTrab();
    }
}
