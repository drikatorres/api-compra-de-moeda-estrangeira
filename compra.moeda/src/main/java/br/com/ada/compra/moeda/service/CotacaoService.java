package br.com.ada.compra.moeda.service;

import br.com.ada.compra.moeda.dto.CotacaoDTO;
import br.com.ada.compra.moeda.model.Moeda;
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

    public CotacaoDTO getCotacao(String moeda) {
        if (!moeda.equals(Moeda.EUR) && !moeda.equals(Moeda.USD)) {
            throw new IllegalArgumentException();
        }
        Mono<CotacaoDTO[]> response = webClient.get()
                .uri("{moeda}", moeda)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(CotacaoDTO[].class).log();
        CotacaoDTO[] cotacao = response.block();
        return cotacao[0];
    }
}
