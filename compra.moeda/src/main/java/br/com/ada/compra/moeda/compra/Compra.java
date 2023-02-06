package br.com.ada.compra.moeda.compra;

import br.com.ada.compra.moeda.comum.Moeda;
import lombok.*;

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
