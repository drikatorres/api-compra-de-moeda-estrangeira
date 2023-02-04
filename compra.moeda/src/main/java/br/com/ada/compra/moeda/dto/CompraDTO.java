package br.com.ada.compra.moeda.dto;

import br.com.ada.compra.moeda.model.Compra;
import br.com.ada.compra.moeda.model.Moeda;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CompraDTO {
    private String id;
    private String cpf;
    private Moeda moeda;
    private BigDecimal valor;
    private String agencia;

    public static CompraDTO of(Compra compra) {
        CompraDTO dto = new CompraDTO();
        dto.setCpf(compra.getCpf());
        dto.setId(compra.getId());
        dto.setMoeda(compra.getMoeda());
        dto.setValor(compra.getValor());
        dto.setAgencia(compra.getAgencia());
        return dto;
    }

    public Compra toEntity() {
        Compra compra = new Compra();
        compra.setId(id);
        compra.setCpf(cpf);
        compra.setMoeda(moeda);
        compra.setValor(valor);
        compra.setAgencia(agencia);
        return compra;
    }
}
