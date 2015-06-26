package controle;

import dao.FuncionarioDAO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Funcionario;
import util.Util;

@ManagedBean(name = "controleLogin")
@SessionScoped
public class ControleLogin implements Serializable{
    @EJB
    private FuncionarioDAO<Funcionario> dao;
    private Funcionario funcionarioLogado;
    private String funcionario;
    private String senha;

    public ControleLogin() {
    }
    
    public String paginaLogin(){
        return "/login?faces-redirect=true";
    }
    
    public String efetuarLogin(){
        if(dao.login(funcionario, senha)){
            funcionarioLogado = dao.localizarFuncionarioPorNome(funcionario);
            Util.mensagemInformacao("Logado com sucesso");
            return "/index";
        }
        else{
            Util.mensagemErro("Usuário ou senha inválidos");
            funcionarioLogado = null;
            return "/login";
        }
    }

    public String efetuarLogout(){
        funcionarioLogado = null;
        Util.mensagemInformacao("Deslgoado com sucesso");
        return "/login";
    }
    
    public FuncionarioDAO<Funcionario> getDao() {
        return dao;
    }

    public void setDao(FuncionarioDAO<Funcionario> dao) {
        this.dao = dao;
    }

    public Funcionario getFuncionarioLogado() {
        return funcionarioLogado;
    }

    public void setFuncionarioLogado(Funcionario funcionarioLogado) {
        this.funcionarioLogado = funcionarioLogado;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}

