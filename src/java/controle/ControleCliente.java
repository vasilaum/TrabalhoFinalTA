package controle;

import dao.ClienteDAO;
import dao.ClienteDAO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Cliente;
import modelo.Cliente;
import util.Util;

@ManagedBean(name = "controleCliente")
@ViewScoped
public class ControleCliente implements Serializable {

    @EJB
    private ClienteDAO<Cliente> dao;
    private Cliente objeto;

    public ControleCliente() {

    }

    public String listar() {
        return "/cliente/listar";
    }

    public void novo() {
        objeto = new Cliente();
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


    public Cliente getObjeto() {
        return objeto;
    }

    public void setObjeto(Cliente objeto) {
        this.objeto = objeto;
    }

    public ClienteDAO<Cliente> getDao() {
        return dao;
    }

    public void setDao(ClienteDAO<Cliente> dao) {
        this.dao = dao;
    }

}
