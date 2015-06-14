package modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
    @Length(max = 15, min = 10, message = "Entre 10 e 15 caracteres")
    @NotEmpty(message = "Número da carteira de trabalho nulo")
    private String numeroCarteiraTrab;
    
    @Column(name = "salario", nullable = false)
    @NotNull(message = "Informe um salário")
    private Double salario;
    
    @Column(name = "data_contratacao", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Informe o dia da contratação")
    private Calendar dataContratacao;
    
    @Column(name = "ativo", nullable = false)
    @NotNull(message = "Ativo nulo")
    private Boolean ativo;

    public Funcionario() {
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
    
    
}
