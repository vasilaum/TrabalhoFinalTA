package controle;

import dao.FilmeDAO;
import dao.LocacoesDAO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Filme;
import modelo.Locacoes;
import util.Util;

@ManagedBean(name = "controleLocacoes")
@ViewScoped
public class ControleLocacoes implements Serializable {

    @EJB
    private LocacoesDAO<Locacoes> dao;
    private Locacoes objeto;
    @EJB
    private FilmeDAO<Filme> daoFilme;
    private Filme filme;

    public ControleLocacoes() {

    }

    public String listar() {
        return "privado/locacoes/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Locacoes();
    }

    public FilmeDAO<Filme> getDaoFilme() {
        return daoFilme;
    }

    public void setDaoFilme(FilmeDAO<Filme> daoFilme) {
        this.daoFilme = daoFilme;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
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
            Util.mensagemErro("Erro ao remover objeto: " + e.getMessage());
        }
    }

    public Locacoes getObjeto() {
        return objeto;
    }

    public void setObjeto(Locacoes objeto) {
        this.objeto = objeto;
    }

    public LocacoesDAO<Locacoes> getDao() {
        return dao;
    }

    public void setDao(LocacoesDAO<Locacoes> dao) {
        this.dao = dao;
    }

    public void adicionarFilme() {
        objeto.adicionarFilmes(filme);
        Util.mensagemInformacao("Filme adicionado com sucesso");
    }

    public void removerFilme(Filme obj) {
        objeto.removerFilmes(obj);
        Util.mensagemInformacao("Filme removido com sucesso");
    }

}
