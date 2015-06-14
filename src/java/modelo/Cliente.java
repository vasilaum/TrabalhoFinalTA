package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
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
    
    
}
