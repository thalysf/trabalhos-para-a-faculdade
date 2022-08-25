package dominio;

import java.util.Objects;

public class TipoVacina {
    private Long idTipoVacina;
    private String descricao;

    public TipoVacina(Long idTipoVacina, String descricao) {
        this.idTipoVacina = idTipoVacina;
        this.descricao = descricao;
    }

    public TipoVacina() {
        
    }

    public Long getIdTipoVacina() {
        return idTipoVacina;
    }

    public void setIdTipoVacina(Long idTipoVacina) {
        this.idTipoVacina = idTipoVacina;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.idTipoVacina);
        hash = 17 * hash + Objects.hashCode(this.descricao);
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
        final TipoVacina other = (TipoVacina) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.idTipoVacina, other.idTipoVacina)) {
            return false;
        }
        return true;
    }
}
