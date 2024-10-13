package Tela_de_jogo;

import Configuracoes.Controle_botoes;
import Configuracoes.Estado_btn;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.border.LineBorder;

public class Tela_Jogo extends JFrame {
    private JPanel painel;
    private JButton[] botao;
    private JLabel label;
    private JLabel label_texto;
    private JLabel label_x;
    private JLabel label_o;
    private JLabel label_vs;
    private JLabel label_vez;
    private JLabel Lb_Pontuacao_x;
    private JLabel Lb_Pontuacao_o;
    private JLabel LinhaHorizontal1;
    private JLabel LinhaHorizontal2;
    private JLabel LinhaVertical1;
    private JLabel LinhaVertical2;

    private List<Controle_botoes> listaControle;

    private ActionListener acaoBotoes;

    private static char jogadorAtual = 'X';
    
    private int pontuacao_x = 0;
    private int pontuacao_O = 0;

    public Tela_Jogo() {
        super("Jogo da Velha - JAVA");
        
        listaControle = new ArrayList<>();

        acaoBotoes = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton botaoClicado = (JButton) e.getSource();

                // Verifica se o botão está vazio
                if (botaoClicado.getText().isEmpty()) {
                    // Define o texto do botão com base no jogador atual
                    botaoClicado.setText(String.valueOf(jogadorAtual));
                    botaoClicado.setFont(new Font("Arial", Font.BOLD, 21));
                    // Obtém o controle associado ao botão clicado
                    Controle_botoes controle = null;
                    for (Controle_botoes c : listaControle) {
                        if (c.getReferencia_botoes().containsKey(botaoClicado)) {
                            controle = c;
                            break;
                        }
                    }

                    // Define o estado do botão com base no jogador atual
                    if (jogadorAtual == 'X') {
                        // Se o jogador atual for X, define o estado como SELECIONADO_X
                        controle.alterarSelecao(botaoClicado, Estado_btn.SELECIONADO_X);
                    } else {
                        // Se o jogador atual não for X, define o estado como SELECIONADO_BOLA
                        controle.alterarSelecao(botaoClicado, Estado_btn.SELECIONADO_BOLA);
                    }

                    // Verifica se houve vitória ou empate
                    verificarVitoria();

                    // Alterna para o próximo jogador
                    jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
                    label_vez.setText("Vez do jogador: " + jogadorAtual);
                }
            }
        };

        botao = new JButton[9];
        
        //Cria o painel e adiciona suas definições
        painel = new JPanel();
        this.add(painel);
        painel.setLayout(null);
        this.setSize(500, 300);
        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(Color.BLACK, 1),
                        new LineBorder(Color.GRAY, 8) 
                ),
                new LineBorder(Color.BLACK, 1)
        ));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Cria a figura do Jogo da velha
        LinhaHorizontal1 = new JLabel();
        LinhaHorizontal1.setOpaque(true);
        LinhaHorizontal1.setBackground(Color.GRAY);
        LinhaHorizontal1.setBounds(30, 95, 210, 10);
        
        LinhaHorizontal2 = new JLabel();
        LinhaHorizontal2.setOpaque(true);
        LinhaHorizontal2.setBackground(Color.GRAY);
        LinhaHorizontal2.setBounds(30, 165, 210, 10);
        
        LinhaVertical1 = new JLabel();
        LinhaVertical1.setOpaque(true);
        LinhaVertical1.setBackground(Color.GRAY);
        LinhaVertical1.setBounds(95, 30, 10, 210);
        
        LinhaVertical2 = new JLabel();
        LinhaVertical2.setOpaque(true);
        LinhaVertical2.setBackground(Color.GRAY);
        LinhaVertical2.setBounds(165, 30, 10, 210);
        
        painel.add(LinhaHorizontal1);
        painel.add(LinhaHorizontal2);
        painel.add(LinhaVertical1);
        painel.add(LinhaVertical2);
        
        //Exibe a label onde tem a pontuação
        label = new JLabel();
        label.setBounds(254, 10, 220, 241);
        label.setBackground(Color.lightGray);
        label.setOpaque(true);

        label_texto = new JLabel();
        label_texto.setBounds(305, 30, 150, 50);
        label_texto.setFont(new Font("Arial", Font.BOLD, 20));
        label_texto.setForeground(Color.BLACK);
        label_texto.setText("PONTUAÇÃO");
        
        label_x = new JLabel();
        label_x.setBounds(280, 80, 50, 50);
        label_x.setFont(new Font("Arial", Font.BOLD, 20));
        label_x.setHorizontalAlignment(SwingConstants.CENTER);
        label_x.setText("X");
        label_x.setForeground(Color.BLACK);
        label_x.setOpaque(false);
        
        label_o = new JLabel();
        label_o.setBounds(405, 80, 50, 50);
        label_o.setFont(new Font("Arial", Font.BOLD, 20));
        label_o.setHorizontalAlignment(SwingConstants.CENTER);
        label_o.setText("O");
        label_o.setForeground(Color.BLACK);
        label_o.setOpaque(false);
        
        label_vs = new JLabel();
        label_vs.setBounds(340, 120, 50, 50);
        label_vs.setFont(new Font("Arial", Font.BOLD, 20));
        label_vs.setHorizontalAlignment(SwingConstants.CENTER);
        label_vs.setText("VS");
        label_vs.setForeground(Color.BLACK);
        label_vs.setOpaque(false);
        
        Lb_Pontuacao_x = new JLabel();
        Lb_Pontuacao_x.setBounds(280, 120, 50, 50);
        Lb_Pontuacao_x.setFont(new Font("Arial", Font.BOLD, 20));
        Lb_Pontuacao_x.setHorizontalAlignment(SwingConstants.CENTER);
        Lb_Pontuacao_x.setForeground(Color.BLACK);
        Lb_Pontuacao_x.setOpaque(true);
        
        Lb_Pontuacao_o = new JLabel();
        Lb_Pontuacao_o.setBounds(405, 120, 50, 50);
        Lb_Pontuacao_o.setFont(new Font("Arial", Font.BOLD, 20));
        Lb_Pontuacao_o.setHorizontalAlignment(SwingConstants.CENTER);
        Lb_Pontuacao_o.setForeground(Color.BLACK);
        Lb_Pontuacao_o.setOpaque(true);
      
        label_vez = new JLabel();
        label_vez.setBounds(285, 200, 150, 50);
        label_vez.setFont(new Font("Arial", Font.BOLD, 15));
        label_vez.setHorizontalAlignment(SwingConstants.CENTER);
        label_vez.setText("Vez do jogador: X "); // Sempre começa com X
        label_vez.setForeground(Color.BLACK);
        label_vez.setOpaque(false);
        
        painel.add(label_texto);
        painel.add(label_x);
        painel.add(label_o);
        painel.add(label_vs);
        painel.add(Lb_Pontuacao_x);
        painel.add(Lb_Pontuacao_o);
        painel.add(label_vez);
        painel.add(label);
     
        
        // Inicializa os botões e os controles
        for (int i = 0; i < 9; i++) {
            botao[i] = new JButton("");
            botao[i].setBounds(40 + (i % 3) * 70, 40 + (i / 3) * 70, 50, 50);
            botao[i].setBackground(Color.WHITE);
            botao[i].setBorderPainted(false);
            botao[i].setContentAreaFilled(false); 
            botao[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            painel.add(botao[i]);
            botao[i].addActionListener(acaoBotoes);
            Controle_botoes controle = new Controle_botoes(Integer.toString(i), new HashMap<>());
            controle.alterarSelecao(botao[i], Estado_btn.NORMAL);
            listaControle.add(controle);
        }

        atualizarPontuacaoNaTela();
    }

    private void verificarVitoria() {
        // Combinações de vitória: linhas, colunas e diagonais
        int[][] combinacoes = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},  // Linhas
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},  // Colunas
                {0, 4, 8}, {2, 4, 6}              // Diagonais
        };

        // Verifica todas as combinações de vitória
        for (int[] combinacao : combinacoes) {
            JButton primeiroBotao = botao[combinacao[0]];
            JButton segundoBotao = botao[combinacao[1]];
            JButton terceiroBotao = botao[combinacao[2]];

            // Verifica se os botões estão preenchidos e têm o mesmo texto
            if (!primeiroBotao.getText().isEmpty() &&
                primeiroBotao.getText().equals(segundoBotao.getText()) &&
                segundoBotao.getText().equals(terceiroBotao.getText())) {
                char jogadorVencedor = primeiroBotao.getText().charAt(0);
                JOptionPane.showMessageDialog(this, "Jogador " + primeiroBotao.getText() + " venceu!", "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
                
               if (jogadorVencedor == 'X') {
                   pontuacao_x ++;
               } else {
                   pontuacao_O++;
               }
                // Atualiza a exibição da pontuação na tela
                atualizarPontuacaoNaTela();
                
                reiniciarJogo();
                return;
            }
        }

        // Se todos os botões estiverem preenchidos e não houver vencedor, é empate
        if (todosBotoesPreenchidos()) {
            JOptionPane.showMessageDialog(this, "Velha!", "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
            reiniciarJogo();
        }
    }
    
    private void atualizarPontuacaoNaTela() {
        Lb_Pontuacao_x.setText("" + pontuacao_x);
        Lb_Pontuacao_o.setText("" + pontuacao_O);
    }

    private boolean todosBotoesPreenchidos() {
        for (JButton botao : botao) {
            if (botao.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void reiniciarJogo() {
        // Limpar os textos dos botões
        for (JButton button : botao) {
            button.setText("");
        }
    }
    public void Exibir_tela(boolean visivel) {
        setVisible(visivel);
    }
}
