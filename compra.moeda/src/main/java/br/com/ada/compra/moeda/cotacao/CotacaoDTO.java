package br.com.ada.compra.moeda.cotacao;


import br.com.ada.compra.moeda.comum.Moeda;
import lombok.Data;

@Data
public class CotacaoDTO {

    private String code;
    private Double bid;

}
