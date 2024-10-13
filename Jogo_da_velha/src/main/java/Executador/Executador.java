package Executador;

import Tela_de_jogo.Tela_Menu;
import Tela_de_jogo.Tela_Jogo;

public class Executador {
    
      public static void main(String[] args) {
        Tela_Jogo jogo = new Tela_Jogo();
        Tela_Menu menu = new Tela_Menu(jogo);
    }
    
}