package br.com.ada.compra.moeda.cotacao;

import br.com.ada.compra.moeda.comum.Moeda;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/cotacao")
public class CotacaoController {
    private final CotacaoService cotacaoService;

    public CotacaoController(CotacaoService cotacaoService) {
        this.cotacaoService = cotacaoService;
    }
    @GetMapping("/{moeda}")
    public CotacaoDTO consultarValor(@PathVariable String moeda){
        System.out.println(moeda);
        if (!moeda.equals("USD") && !moeda.equals("EUR")) {
            throw new IllegalArgumentException("Moeda inválida!");
        }
        return cotacaoService.getCotacao(Moeda.valueOf(moeda));
    }

}
