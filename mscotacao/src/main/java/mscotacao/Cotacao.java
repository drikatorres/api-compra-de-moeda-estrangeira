package mscotacao;

import br.com.ada.compra.moeda.comum.Moeda;

import javax.persistence.Entity;
import java.math.BigDecimal;


public class Cotacao {
    private Moeda moeda;
    private BigDecimal valor;
}
