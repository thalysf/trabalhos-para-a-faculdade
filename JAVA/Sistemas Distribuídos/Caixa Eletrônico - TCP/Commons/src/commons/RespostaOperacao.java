package commons;

import java.io.Serializable;


public class RespostaOperacao implements Serializable{
    private boolean sucesso;
    private int valorAtualizado;

    public RespostaOperacao() {
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public int getValorAtualizado() {
        return valorAtualizado;
    }

    public void setValorAtualizado(int valorAtualizado) {
        this.valorAtualizado = valorAtualizado;
    }

}
