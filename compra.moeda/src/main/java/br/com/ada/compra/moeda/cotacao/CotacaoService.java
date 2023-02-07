package br.com.ada.compra.moeda.cotacao;

import br.com.ada.compra.moeda.comum.Moeda;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CotacaoService {
    private WebClient webClient;
    private final String url = "https://economia.awesomeapi.com.br/";

    public CotacaoService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(url).build();
    }

    public CotacaoDTO getCotacao(Moeda moeda) {

        Mono<CotacaoDTO[]> response = webClient.get()
                .uri("{moeda}", moeda.toString().toUpperCase())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(CotacaoDTO[].class).log();
        CotacaoDTO[] cotacao = response.block();
        return cotacao[0];
    }
}
