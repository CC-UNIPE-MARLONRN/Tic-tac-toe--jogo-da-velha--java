package Tela_de_jogo;

import java.util.Random;
import javax.swing.JOptionPane;

public class Tela_Contra_IA extends Tela_de_jogo.Tela_Jogo {

    // Construtor da classe
    public Tela_Contra_IA() {
        super(); // Chama o construtor da classe pai (Tela_Jogo)
    }

//    // Método para que a IA faça uma jogada
//    protected void jogadaIA() {
//        // Verifica se o jogo já acabou
//        if (todosBotoesPreenchidos() || houveVitoria()) {
//            return;
//        }
//
//        // Lógica da jogada da IA
//        int posicao = escolherPosicao();
//
//        // Define o símbolo da IA na posição escolhida
//        botao[posicao].setText("O");
//
//        // Verifica se houve vitória após a jogada da IA
//        if (houveVitoria()) {
//            // Mostra a mensagem de vitória da IA
//            JOptionPane.showMessageDialog(this, "A IA Venceu!", "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);      
//            return;
//        }
//
//        // Verifica se todos os botões foram preenchidos após a jogada da IA
//        if (todosBotoesPreenchidos()) {
//            // Mostra a mensagem de empate
//             JOptionPane.showMessageDialog(this, "Velha!", "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
//             reiniciarJogo();
//             return;
//        }
//    }
//
//    // Método para escolher a posição da jogada da IA
//    private int escolherPosicao() {
//        // Verifica se é possível fazer uma jogada vencedora
//        for (int i = 0; i < 9; i++) {
//            if (botao[i].getText().isEmpty() && jogadaVencedora('O', i)) {
//                return i;
//            }
//        }
//
//        // Verifica se é possível bloquear uma jogada do jogador
//        for (int i = 0; i < 9; i++) {
//            if (botao[i].getText().isEmpty() && jogadaVencedora('X', i)) {
//                return i;
//            }
//        }
//
//        // Escolhe uma posição aleatória se não houver jogada vencedora
//        Random random = new Random();
//        int posicaoAleatoria;
//        do {
//            posicaoAleatoria = random.nextInt(9);
//        } while (!botao[posicaoAleatoria].getText().isEmpty());
//
//        return posicaoAleatoria;
//    }
//
//    // Método para verificar se uma jogada em uma posição específica é vencedora
//    private boolean jogadaVencedora(char jogador, int posicao) {
//        String textoBotao = botao[posicao].getText();
//        if (textoBotao.isEmpty()) {
//            return false;
//        }
//
//        // Verifica se a jogada vence na linha horizontal
//        int linha = posicao / 3;
//        int colunaInicial = linha * 3;
//        int colunaFinal = colunaInicial + 2;
//        for (int i = colunaInicial; i <= colunaFinal; i++) {
//            if (textoBotao.charAt(0) != jogador) {
//                return false;
//            }
//            if (i == colunaFinal) {
//                return true;
//            }
//        }
//
//        // Verifica se a jogada vence na coluna vertical
//        int coluna = posicao % 3;
//        int linhaInicial = coluna;
//        int linhaFinal = linhaInicial + 6;
//        for (int i = linhaInicial; i <= linhaFinal; i += 3) {
//            if (textoBotao.charAt(0) != jogador) {
//                return false;
//            }
//            if (i == linhaFinal) {
//                return true;
//            }
//        }
//
//        // Verifica se a jogada vence na diagonal principal
//        if (posicao % 4 == 0) {
//            for (int i = 0; i < 9; i += 4) {
//                if (textoBotao.charAt(0) != jogador) {
//                    return false;
//                }
//                if (i == 8) {
//                    return true;
//                }
//            }
//        }
//
//        // Verifica se a jogada vence na diagonal secundária
//        if (posicao == 2 || posicao == 4 || posicao == 6) {
//            for (int i = 2; i <= 6; i += 2) {
//                if (textoBotao.charAt(0) != jogador) {
//                    return false;
//                }
//                if (i == 6) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
//
//    // Método para verificar se houve vitória
//    private boolean houveVitoria() {
//        // Verifica se houve vitória na horizontal, vertical ou diagonal
//        return (
//                linhaVitoriosa() || colunaVitoriosa() || diagonalVitoriosa()
//        );
//    }
//
//    // Método para verificar se houve vitória em alguma linha
//    private boolean linhaVitoriosa() {
//        for (int i = 0; i < 9; i += 3) {
//            String textoBotao1 = botao[i].getText();
//            String textoBotao2 = botao[i + 1].getText();
//            String textoBotao3 = botao[i + 2].getText();
//            if (!textoBotao1.isEmpty() &&
//                    textoBotao1.equals(textoBotao2) &&
//                    textoBotao1.equals(textoBotao3)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    // Método para verificar se houve vitória em alguma coluna
//    private boolean colunaVitoriosa() {
//        for (int i = 0; i < 3; i++) {
//            String textoBotao1 = botao[i].getText();
//            String textoBotao2 = botao[i + 3].getText();
//            String textoBotao3 = botao[i + 6].getText();
//            if (!textoBotao1.isEmpty() &&
//                    textoBotao1.equals(textoBotao2) &&
//                    textoBotao1.equals(textoBotao3)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    // Método para verificar se houve vitória em alguma diagonal
//    private boolean diagonalVitoriosa() {
//        String textoBotao1 = botao[0].getText();
//        String textoBotao2 = botao[4].getText();
//        String textoBotao3 = botao[8].getText();
//        String textoBotao4 = botao[2].getText();
//        String textoBotao5 = botao[6].getText();
//        return (!textoBotao1.isEmpty() && textoBotao1.equals(textoBotao2) && textoBotao1.equals(textoBotao3)) ||
//                (!textoBotao4.isEmpty() && textoBotao4.equals(textoBotao2) && textoBotao4.equals(textoBotao5));
//    }
//
//    public static void main(String[] args) {
//        Tela_Contra_IA jogoContraIA = new Tela_Contra_IA();
//        jogoContraIA.Exibir_tela(true);
//    }
}
