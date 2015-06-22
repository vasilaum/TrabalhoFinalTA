package controle;

import dao.FuncionarioDAO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Funcionario;
import util.Util;

@ManagedBean(name = "controleFuncionario")
@ViewScoped
public class ControleFuncionario implements Serializable {

    @EJB
    private FuncionarioDAO dao;
    private Funcionario objeto;

    public ControleFuncionario() {

    }

    public String listar() {
        return "/funcionario/listar";
    }

    public void novo() {
        objeto = new Funcionario();
    }

    public void salvar() {
        try {
            if (objeto.getId() == null) {
                dao.persistir(objeto);
            } else {
                dao.merger(objeto);
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
            dao.remover(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto: "+e.getMessage());
        }
    }

    public Funcionario getObjeto() {
        return objeto;
    }

    public void setObjeto(Funcionario objeto) {
        this.objeto = objeto;
    }

    public FuncionarioDAO getDao() {
        return dao;
    }

    public void setDao(FuncionarioDAO dao) {
        this.dao = dao;
    }
}
