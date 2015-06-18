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
@Table(name = "cliente")
public class Cliente extends Pessoa implements Serializable{
    
    @Column(name = "endereco", length = 100, nullable = false)
    @Length(min = 3, max = 100, message = "Entre {max} e {min} caracteres")
    @NotEmpty(message = "Endereço obrigatório")
    private String endereco;

    @Column(name = "bairro", length = 50, nullable = false)
    @Length(min = 3, max = 100, message = "Entre {max} e {min} caracteres")
    @NotEmpty(message = "Bairro obrigatório")
    private String bairro;
    
    @Column(name = "cep", nullable = false)
    @NotEmpty(message = "CEP obrigatório")
    @Length(max = 9, min = 9, message = "O CEP deve ter {max} caracteres")
    private String cep;
    
    @Column(name = "data_cadastro", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Data de cadastro obrigatória")
    private Calendar dataCadastro;
    
    public Cliente() {
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}
