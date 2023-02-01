package br.com.ada.compra.moeda.dto;

import br.com.ada.compra.moeda.model.Compra;
import br.com.ada.compra.moeda.model.Moeda;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CompraDTO {
    private final String cpf;
    private Moeda moeda;
    private BigDecimal valor;
    private String agencia;

    public static CompraDTO of(Compra compra) {
        CompraDTO dto = new CompraDTO(compra.getCpf());
        dto.moeda = compra.getMoeda();
        dto.valor = compra.getValor();
        dto.agencia = compra.getAgencia();
        return dto;
    }

    public Compra toEntity() {
        Compra entity = new Compra();
        entity.setCpf(cpf);
        entity.setMoeda(moeda);
        entity.setValor(valor);
        entity.setAgencia(agencia);
        return entity;
    }
}
