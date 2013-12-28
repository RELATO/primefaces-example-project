package entidades;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Autor extends Pessoa implements Serializable {

    public Autor() {
    }
}