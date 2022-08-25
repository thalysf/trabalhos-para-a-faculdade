package dominio;

import java.util.Date;
import java.util.Objects;

public class Paciente {

    private Long idPaciente;
    private String nomePaciente;
    private String cpf;
    private Date dtDose1;
    private Date dtDose2;
    private Integer precisaDose2;
    private Vacina vacina;

    public Paciente(Long idPaciente, String nomePaciente, String cpf, Date dtDose1, Date dtDose2, Integer precisaDose2, Vacina vacina) {
        this.idPaciente = idPaciente;
        this.nomePaciente = nomePaciente;
        this.cpf = cpf;
        this.dtDose1 = dtDose1;
        this.dtDose2 = dtDose2;
        this.precisaDose2 = precisaDose2;
        this.vacina = vacina;
    }

    public Paciente() {

    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDtDose1() {
        return dtDose1;
    }

    public void setDtDose1(Date dtDose1) {
        this.dtDose1 = dtDose1;
    }

    public Date getDtDose2() {
        return dtDose2;
    }

    public void setDtDose2(Date dtDose2) {
        this.dtDose2 = dtDose2;
    }

    public Integer getPrecisaDose2() {
        return precisaDose2;
    }

    public void setPrecisaDose2(Integer precisaDose2) {
        this.precisaDose2 = precisaDose2;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idPaciente);
        hash = 79 * hash + Objects.hashCode(this.nomePaciente);
        hash = 79 * hash + Objects.hashCode(this.cpf);
        hash = 79 * hash + Objects.hashCode(this.dtDose1);
        hash = 79 * hash + Objects.hashCode(this.dtDose2);
        hash = 79 * hash + Objects.hashCode(this.precisaDose2);
        hash = 79 * hash + Objects.hashCode(this.vacina);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.nomePaciente, other.nomePaciente)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.idPaciente, other.idPaciente)) {
            return false;
        }
        if (!Objects.equals(this.dtDose1, other.dtDose1)) {
            return false;
        }
        if (!Objects.equals(this.dtDose2, other.dtDose2)) {
            return false;
        }
        if (!Objects.equals(this.precisaDose2, other.precisaDose2)) {
            return false;
        }
        if (!Objects.equals(this.vacina, other.vacina)) {
            return false;
        }
        return true;
    }
    public Object[] toArray() {
        return new Object[]{idPaciente, nomePaciente, cpf, vacina.getNomeVacina(), dtDose1, dtDose2, precisaDose2};
    }
}
