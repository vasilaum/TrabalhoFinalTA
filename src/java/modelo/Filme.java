package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "filme")
public class Filme implements Serializable{
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_filme", sequenceName = "seq_filme_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_filme", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Length(min = 3, max = 50, message = "O nome deve ter entre {min} e {max} caracteres")
    @NotEmpty(message = "O nome deve ser informada")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @Length(min = 3, max = 50, message = "A descrição deve ter entre {min} e {max} caracteres")
    @NotEmpty(message = "A descrição deve ser informada")
    @Column(name = "descricao", length = 50, nullable = false)
    private String descricao;
    
    @Column(name = "data_lancamento", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Informe o dia de lançamento do filme")
    private Calendar dataLancamento;
       
    @Column(name = "classificacao", nullable = false)
    @NotNull(message = "A classificação deve ser informada")
    private Integer classificacao;
    
    @Column(name = "disponivel", nullable = false)
    @NotNull(message = "Campo disponível estpa nulo")
    private Boolean disponivel;
    
    @ManyToOne
    @JoinColumn(name = "categoria",referencedColumnName = "id",nullable = false)
    @NotNull(message = "A categoria deve ser informado")
    private Categoria categoria;
    
    @ManyToMany
    @JoinTable(name = "filmes_locacoes",
            // joinColumn se refere a coluna que armazena o id desta entidade
            joinColumns = 
            @JoinColumn(name = "filme", referencedColumnName = "id"),
            // inverseJoinColumns se refere a coluna que armazena o id 
            //da entidade do outro lado da relação
            inverseJoinColumns = 
            @JoinColumn(name = "locacoes",referencedColumnName = "id"))    
    private List<Locacoes> locacoes = new ArrayList<>();
    
    public Filme() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Calendar dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Integer getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Integer classificacao) {
        this.classificacao = classificacao;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Filme other = (Filme) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    public List<Locacoes> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(List<Locacoes> locacoes) {
        this.locacoes = locacoes;
    }
    
    
}
