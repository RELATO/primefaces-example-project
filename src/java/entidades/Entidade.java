package entidades;

import java.io.Serializable;
import javax.persistence.Transient;

public abstract class Entidade implements Serializable {

    @Transient
    public boolean flagRemover;

    public abstract Serializable getId();

    public Boolean getFlagRemover() {
        return flagRemover;
    }

    public void setFlagRemover(Boolean flagRemover) {
        this.flagRemover = flagRemover;
    }
}