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

@Entity
@Table(name = "locacoes")
public class Locacoes implements Serializable {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_locacoes", sequenceName = "seq_locacoes_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_locacoes", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "data_locacao", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Data de locação obrigatória")
    private Calendar dataLocacao;

    @Column(name = "data_entrega", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Data da entrega obrigatória")
    private Calendar dataEntrega;
    
    @Column(name = "valor_locacao", nullable = false)
    @NotNull(message = "Valor da locação obrigatório")
    private Double valorLocacao;
    
    @Column(name = "entregue", nullable = false)
    @NotNull(message = "Campo entregue está nulo")
    private Boolean entregue;
    
    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id",nullable = false)
    @NotNull(message = "Cliente obrigatório")
    private Cliente cliente;
    
    @ManyToMany
    @JoinTable(name = "filmes_locacoes",          
            joinColumns = 
                @JoinColumn(name = "locacoes", referencedColumnName = "id"),    
            inverseJoinColumns = 
                @JoinColumn(name = "filme",referencedColumnName = "id"))    
    private List<Filme> filmes = new ArrayList<>();

    public Locacoes() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Calendar dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public Calendar getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Calendar dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(Double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public Boolean getEntregue() {
        return entregue;
    }

    public void setEntregue(Boolean entregue) {
        this.entregue = entregue;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final Locacoes other = (Locacoes) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return cliente.getNome();
    }
    
    public void adicionarFilmes(Filme obj){
        if (!this.getFilmes().contains(obj)){
            this.getFilmes().add(obj);
        }
    }
    
    public void removerFilmes(Filme obj){
        this.getFilmes().remove(obj);
    }
}
