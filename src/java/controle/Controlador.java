package controle;

import delegate.FacadeBD;
import entidades.Entidade;
import entidades.Autor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "controlador")
@ViewScoped
public class Controlador implements Serializable {

    @ManagedProperty(value = "#{facadeBD}")
    private FacadeBD facadeBD;

    public Controlador() {
    }

    public String listaGravada() {
        String retorno = "";
        List<Autor> la = facadeBD.listar(Autor.class);
        retorno += "\n\nLista gravada:\n\n";
        if (la != null) {
            for (Autor autor : la) {
                retorno += "("+autor.getId()+") "+autor.getNome() + "\n";
            }
        }
        return retorno;
    }

    public String getResultado() {
        String retorno = "";
        Autor autor1 = new Autor();
        autor1.setNome("Stephen King");
        Autor autor2 = new Autor();
        autor2.setNome("Dan Brown");
        List<Entidade> listaAutores = new ArrayList<Entidade>();
        listaAutores.add(autor1);
        listaAutores.add(autor2);
        retorno += "\nInserindo dois autores\n";
        facadeBD.salvarLista(listaAutores);
        retorno += listaGravada();
        autor1.setFlagRemover(Boolean.TRUE);
        facadeBD.salvar(autor1);
        retorno += "\nExcluindo ("+autor1.getId()+") "+autor1.getNome()+"\n";
        retorno += listaGravada();
        Autor autor3 = new Autor();
        autor3.setNome("ray bradbury");
        listaAutores.add(autor3);
        retorno += "\nInserindo novo autor "+autor3.getNome()+"\n";
        facadeBD.salvarLista(listaAutores);
        retorno += listaGravada();
        retorno += "\nAlterando "+autor3.getNome()+"\n";
        autor3.setNome("Ray Bradbury");
        facadeBD.salvarLista(listaAutores);
        retorno += listaGravada();
        return retorno;
    }

    public FacadeBD getFacadeBD() {
        return facadeBD;
    }

    public void setFacadeBD(FacadeBD facadeBD) {
        this.facadeBD = facadeBD;
    }
}