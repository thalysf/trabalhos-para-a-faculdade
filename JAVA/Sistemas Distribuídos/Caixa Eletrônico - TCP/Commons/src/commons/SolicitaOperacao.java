package commons;

import java.io.Serializable;
import java.util.Date;

public class SolicitaOperacao implements Serializable{
    private int codigo;
    private String ip;
    private String tipo;
    private String nomeThread;
    private Date dataHora;

    public SolicitaOperacao() {
    }

    public SolicitaOperacao(int codigo, String ip, String tipo, String nomeThread, Date dataHora) {
        this.codigo = codigo;
        this.ip = ip;
        this.tipo = tipo;
        this.nomeThread = nomeThread;
        this.dataHora = dataHora;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomeThread() {
        return nomeThread;
    }

    public void setNomeThread(String nomeThread) {
        this.nomeThread = nomeThread;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
}
