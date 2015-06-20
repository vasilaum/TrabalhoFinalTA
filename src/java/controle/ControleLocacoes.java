package controle;
import dao.ClienteDAO;
import dao.FilmeDAO;
import dao.LocacoesDAO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Cliente;
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
    private ClienteDAO daoCidade;
    private Filme filme;
    @EJB
    private FilmeDAO daoFilme;

    public ControleLocacoes() {

    }

    public String listar() {
        return "/privado/locacoes/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Locacoes();
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
            objeto = dao.debugList(id);
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: " + e.getMessage());
        }
    }

    public void remover(Integer id) {
        try {
            objeto = dao.debugList(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto: "+e.getMessage());
        }
    }
    
    public void adicionarFilme(){
        objeto.adicionarFilmes(filme);
        Util.mensagemInformacao("Filme adicionado com sucesso");
    }
    
    public void removerDesejo(Filme obj){
        objeto.removerFilmes(obj);
        Util.mensagemInformacao("Filme removido com sucesso");
    }

    public LocacoesDAO getDao() {
        return dao;
    }

    public void setDao(LocacoesDAO dao) {
        this.dao = dao;
    }

    public Locacoes getObjeto() {
        return objeto;
    }

    public void setObjeto(Locacoes objeto) {
        this.objeto = objeto;
    }
    
    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public FilmeDAO getDaoProduto() {
        return daoFilme;
    }

    public void setDaoFilme(FilmeDAO daoFilme) {
        this.daoFilme = daoFilme;
    }
}
