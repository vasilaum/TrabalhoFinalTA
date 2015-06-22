package modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "funcionario")
public class Funcionario extends Pessoa implements Serializable{
    
    @Column(name = "numero_carteira_trab", length = 20, nullable = false)
    @Length(max = 15, min = 10, message = "Entre {min} e {max} caracteres")
    @NotEmpty(message = "Número da carteira de trabalho obrigatório")
    private String numeroCarteiraTrab;
    
    @Column(name = "salario", nullable = false)
    @NotNull(message = "Salário obrigatório")
    private Double salario;
    
    @Column(name = "data_contratacao", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Data da contratação obrigatória")
    private Calendar dataContratacao;
    
    @Column(name = "login", length = 100, nullable = false, unique = true)
    @Length(max = 30, message = "Login deve ter no máximo {max} caracteres")
    private String login; 
    
    @Column(name = "senha", length = 100, nullable = false)
    @Length(max = 20, message = "Senha deve ter no máximo {max} caracteres")
    private String senha;
    
    @Column(name = "ativo", nullable = false)
    @NotNull(message = "Campo ativo está nulo")
    private Boolean ativo;
    
    @ManyToOne
    @JoinColumn(name = "cargo", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Cargo obrigatório")
    private Cargo cargo;

    public Funcionario() {
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
   
    public String getNumeroCarteiraTrab() {
        return numeroCarteiraTrab;
    }

    public void setNumeroCarteiraTrab(String numeroCarteiraTrab) {
        this.numeroCarteiraTrab = numeroCarteiraTrab;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Calendar getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Calendar dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
