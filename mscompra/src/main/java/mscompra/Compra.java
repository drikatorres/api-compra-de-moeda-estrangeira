package mscompra;


import lombok.Data;
import mscomum.Moeda;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class Compra {
    @Id
    private String id;
    private String cpf;
    private Moeda moeda;
    private BigDecimal valor;
    private String agencia;
}
