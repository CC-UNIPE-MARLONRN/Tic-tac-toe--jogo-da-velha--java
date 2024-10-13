package Configuracoes;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Controle_botoes {
    private Map<JButton,Estado_btn> referencia_botoes;

    public Controle_botoes(String localbotao, Map<JButton, Estado_btn> referencia_botoes) {
        this.referencia_botoes = new HashMap<>();
    }

    public Controle_botoes() {
        throw new UnsupportedOperationException("Not supported yet.");     
    }

    public Map<JButton, Estado_btn> getReferencia_botoes() {
        return referencia_botoes;
    }

    public void setReferencia_botoes(Map<JButton, Estado_btn> referencia_botoes) {
        this.referencia_botoes = referencia_botoes;
    }
    
    public void alterarSelecao(JButton botao, Estado_btn estado){
        this.referencia_botoes.put(botao,estado);          
    }
    
    public void alterar_estado_btn(Estado_btn estado){
        for(JButton botao: this.referencia_botoes.keySet()){
            alterarSelecao(botao, estado);
            visualizacao_btn(botao);
        }
    }
    
    public void visualizacao_btn(JButton botao){
        Estado_btn estado = this.referencia_botoes.get(botao);
        switch(estado){
                case NORMAL:
                   botao.setBackground(null);
                   botao.setEnabled(true);
                   break;
                case SELECIONADO_BOLA:
                   botao.setEnabled(false);
                    break;
                case SELECIONADO_X:
                    botao.setEnabled(false);
                    break;
                case COLUNA_ENCONTRADA:
                    botao.setEnabled(false);
                    break;
    }
    }  

}
