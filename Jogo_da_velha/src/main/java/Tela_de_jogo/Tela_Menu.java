package Tela_de_jogo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Tela_Menu extends JFrame {
    
    private JPanel menu;
    private JLabel label_logo;
    private JButton btn_jogar;
    private JButton btn_creditos;
    
    public Tela_Menu(Tela_Jogo jogo) {
        super("Menu");

        //Define o painel da tela menu e adiciona ele a tela
        menu = new JPanel();
        this.add(menu);
        menu.setLayout(null);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        menu.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(Color.BLACK, 1),
                        new LineBorder(Color.GRAY, 8) 
                ),
                new LineBorder(Color.BLACK, 1)
        ));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Textos da pagina de menu
        label_logo = new JLabel("Jogo da Velha");
        label_logo.setBounds(100, 20, 200, 50);
        label_logo.setFont(new Font("verdana", Font.BOLD, 20));
        label_logo.setForeground(Color.BLACK);
        label_logo.setHorizontalAlignment(SwingConstants.CENTER);
        menu.add(label_logo);
        
        // Carrega a imagem
        ImageIcon logoIcon = new ImageIcon("../resources/Imagens/Logo_java.png");
        Image image = logoIcon.getImage(); 
        Image newImage = image.getScaledInstance(100, 56, Image.SCALE_SMOOTH);
        ImageIcon newLogoIcon = new ImageIcon(newImage);

        // JLabel da imagem
        JLabel imagelabel = new JLabel();
        imagelabel.setIcon(newLogoIcon);
        imagelabel.setBounds(140, 30, 150, 150); // Define a posição e tamanho do JLabel
        menu.add(imagelabel);
        
        // Botões da página
        btn_jogar = new JButton("Jogar");
        btn_jogar.setBounds(140, 150, 100, 40);
        btn_jogar.setFont(new Font("verdana", Font.BOLD, 14));
        btn_jogar.setForeground(Color.BLACK);
        menu.add(btn_jogar);
        
        // ActionListener jogar
        btn_jogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {           
                ImageIcon customIcon = new ImageIcon("Jogo_da_velha\\Logo_java.png");
                Image custom_img = logoIcon.getImage(); 
                Image newImage = image.getScaledInstance(48, 24, Image.SCALE_SMOOTH);
                ImageIcon newCustomIcon = new ImageIcon(newImage);
                // Cria as opções de botões para o JOptionPane
                Object[] options = {"Jogar com a IA", "Jogar com amigo"};

                // Exibe o JOptionPane com os botões de opção
                int choice = JOptionPane.showOptionDialog(
                    null,
                    "Escolha o tipo de jogo:", 
                    "Tipo de Jogo",
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, 
                    newCustomIcon,
                    options, 
                    options[0] 
                );

                // Verifica qual opção foi selecionada
                if (choice == JOptionPane.YES_OPTION) {
                    Tela_Contra_IA telaContraIA = new Tela_Contra_IA();
                    JOptionPane.showMessageDialog(menu, "EM BREVE", "Jogar contra IA", JOptionPane.INFORMATION_MESSAGE, newCustomIcon);
                    //telaContraIA.setVisible(true);
                    //setVisible(false);
                    
                } else if (choice == JOptionPane.NO_OPTION) {
                   setVisible(false);
                   jogo.setVisible(true);
                }
            }
        });

        
        btn_creditos = new JButton("Créditos");
        btn_creditos.setBounds(140, 200, 100, 40);
        btn_creditos.setFont(new Font("verdana", Font.BOLD, 12));
        btn_creditos.setForeground(Color.BLACK);
        menu.add( btn_creditos);
        
         // ActionListener créditos
        btn_creditos.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                 JPanel panel = new JPanel();
                 panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                 
                JLabel namegit = new JLabel("CC-UNIPE-MARLONRN");
                namegit.setAlignmentX(Component.CENTER_ALIGNMENT);
                namegit.setHorizontalAlignment(SwingConstants.CENTER);
                namegit.setFont(new Font("Arial", Font.ITALIC, 20));
                namegit.setForeground(Color.BLACK);
                namegit.setCursor(new Cursor(Cursor.HAND_CURSOR));

                // Adiciona uma ação ao clicar no nome do git para ser enviado a minha página
                namegit.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (Desktop.isDesktopSupported()) {
                            try {
                                Desktop.getDesktop().browse(new java.net.URI("https://github.com/CC-UNIPE-MARLONRN"));
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });

                panel.add(namegit);
 
                 ImageIcon githubImage = new ImageIcon("../resources/Imagens/github.png");
                 Image img = githubImage.getImage(); 
                 Image newImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                 ImageIcon scaledGithubImage = new ImageIcon(newImg);
                 JLabel githubLabel = new JLabel(scaledGithubImage);
                 githubLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                 panel.add(githubLabel);

                 // JOptionPane créditos
                 JOptionPane.showMessageDialog(
                     null, 
                     panel, 
                     "Créditos", 
                     JOptionPane.PLAIN_MESSAGE 
                 );
             }
         });

        this.setVisible(true);
    }
}
