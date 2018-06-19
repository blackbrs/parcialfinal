package sv.edu.ues.fia.eisi.base;

public class Materia {
    private String nommateria;
    private String codmateria;
    private String unidadesval;

    public Materia() {
    }

    public Materia(String nommateria, String codmateria, String unidadesval) {
        this.nommateria = nommateria;
        this.codmateria = codmateria;
        this.unidadesval = unidadesval;
    }

    public String getNommateria() {
        return nommateria;
    }

    public void setNommateria(String nommateria) {
        this.nommateria = nommateria;
    }

    public String getCodmateria() {
        return codmateria;
    }

    public void setCodmateria(String codmateria) {
        this.codmateria = codmateria;
    }

    public String getUnidadesval() {
        return unidadesval;
    }

    public void setUnidadesval(String unidadesval) {
        this.unidadesval = unidadesval;
    }
}
