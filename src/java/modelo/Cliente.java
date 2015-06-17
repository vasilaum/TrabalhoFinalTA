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
    @Length(min = 3, max = 100, message = "Entre 3 e 100 caracteres")
    @NotEmpty(message = "Campo endereço nulo")
    private String endereco;

    @Column(name = "bairro", length = 50, nullable = false)
    @Length(min = 3, max = 100, message = "Entre 3 e 100 caracteres")
    @NotEmpty(message = "Campo bairro nulo")
    private String bairro;
    
    @Column(name = "data_cadastro", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Informe o dia de cadastro do cliente")
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
