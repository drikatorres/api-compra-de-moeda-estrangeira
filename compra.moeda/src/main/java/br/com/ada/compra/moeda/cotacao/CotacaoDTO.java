package br.com.ada.compra.moeda.cotacao;


public class CotacaoDTO {

    private String code;
    private Double high;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }
}
