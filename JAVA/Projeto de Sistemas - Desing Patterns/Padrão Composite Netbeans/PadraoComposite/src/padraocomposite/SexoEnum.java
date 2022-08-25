package padraocomposite;

public enum SexoEnum {
    M("Masculino"), F("Feminino");
    
    protected final String label;

    private SexoEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
    
}
