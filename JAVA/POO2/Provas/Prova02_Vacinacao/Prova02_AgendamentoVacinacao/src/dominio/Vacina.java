package dominio;

import java.util.Objects;


public class Vacina {
    private Long idVacina;
    private String nomeVacina;
    private Integer qtdeDoses;
    private TipoVacina tipoVacina;

    public Vacina(Long idVacina, String nomeVacina, Integer qtdeDoses, TipoVacina tipoVacina) {
        this.idVacina = idVacina;
        this.nomeVacina = nomeVacina;
        this.qtdeDoses = qtdeDoses;
        this.tipoVacina = tipoVacina;
    }

    public Vacina() {
        
    }

    public Long getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(Long idVacina) {
        this.idVacina = idVacina;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public Integer getQtdeDoses() {
        return qtdeDoses;
    }

    public void setQtdeDoses(Integer qtdeDoses) {
        this.qtdeDoses = qtdeDoses;
    }

    public TipoVacina getTipoVacina() {
        return tipoVacina;
    }

    public void setTipoVacina(TipoVacina tipoVacina) {
        this.tipoVacina = tipoVacina;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.idVacina);
        hash = 47 * hash + Objects.hashCode(this.nomeVacina);
        hash = 47 * hash + Objects.hashCode(this.qtdeDoses);
        hash = 47 * hash + Objects.hashCode(this.tipoVacina);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vacina other = (Vacina) obj;
        if (!Objects.equals(this.nomeVacina, other.nomeVacina)) {
            return false;
        }
        if (!Objects.equals(this.idVacina, other.idVacina)) {
            return false;
        }
        if (!Objects.equals(this.qtdeDoses, other.qtdeDoses)) {
            return false;
        }
        if (!Objects.equals(this.tipoVacina, other.tipoVacina)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomeVacina;
    }
}
