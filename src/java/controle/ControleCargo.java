package controle;

import dao.CargoDAO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Cargo;
import util.Util;

@ManagedBean(name = "controleCargo")
@ViewScoped
public class ControleCargo implements Serializable {

    @EJB
    private CargoDAO<Cargo> dao;
    private Cargo objeto;

    public ControleCargo() {

    }

    public String listar() {
        return "/cargo/listar";
    }

    public void novo() {
        objeto = new Cargo();
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


    public Cargo getObjeto() {
        return objeto;
    }

    public void setObjeto(Cargo objeto) {
        this.objeto = objeto;
    }

    public CargoDAO<Cargo> getDao() {
        return dao;
    }

    public void setDao(CargoDAO<Cargo> dao) {
        this.dao = dao;
    }

}
