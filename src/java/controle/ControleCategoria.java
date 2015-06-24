package controle;

import dao.CategoriaDAO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Categoria;
import util.Util;

@ManagedBean(name = "controleCategoria")
@ViewScoped
public class ControleCategoria implements Serializable {

    @EJB
    private CategoriaDAO<Categoria> dao;
    private Categoria objeto;

    public ControleCategoria() {

    }

    public String listar() {
        return "/categoria/listar";
    }

    public void novo() {
        objeto = new Categoria();
    }

    public void salvar() {
        try {
            if (objeto.getId() == null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir: " + e.getMessage());
        }
    }

    public void editar(Integer id) {
        try {
            objeto = dao.getObjectById(id);
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: " + e.getMessage());
        }
    }

    public void remover(Integer id) {
        try {
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto: "+e.getMessage());
        }
    }


    public Categoria getObjeto() {
        return objeto;
    }

    public void setObjeto(Categoria objeto) {
        this.objeto = objeto;
    }

    public CategoriaDAO<Categoria> getDao() {
        return dao;
    }

    public void setDao(CategoriaDAO<Categoria> dao) {
        this.dao = dao;
    }

}
