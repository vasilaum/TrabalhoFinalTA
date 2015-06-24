package controle;

import dao.FilmeDAO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Filme;
import util.Util;

@ManagedBean(name = "controleFilme")
@ViewScoped
public class ControleFilme implements Serializable {

    @EJB
    private FilmeDAO<Filme> dao;
    private Filme objeto;

    public ControleFilme() {

    }

    public String listar() {
        return "/filme/listar";
    }

    public void novo() {
        objeto = new Filme();
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


    public Filme getObjeto() {
        return objeto;
    }

    public void setObjeto(Filme objeto) {
        this.objeto = objeto;
    }

    public FilmeDAO<Filme> getDao() {
        return dao;
    }

    public void setDao(FilmeDAO<Filme> dao) {
        this.dao = dao;
    }

}
