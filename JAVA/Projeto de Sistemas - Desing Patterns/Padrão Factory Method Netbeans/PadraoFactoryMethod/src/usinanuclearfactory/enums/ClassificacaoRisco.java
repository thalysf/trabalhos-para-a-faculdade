package usinanuclearfactory.enums;

public enum ClassificacaoRisco {
    BAIXO("Risco baixo"), MEDIO("Risco médio"), ALTO("Risco alto");

    protected final String label;

    ClassificacaoRisco(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
