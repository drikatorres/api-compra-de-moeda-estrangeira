package br.com.ada.compra.moeda.service;

import br.com.ada.compra.moeda.dto.CotacaoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class CotacaoService {
    private WebClient webClient;
    private final String url = "https://economia.awesomeapi.com.br/";

    public CotacaoService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(url).build();
    }

    public CotacaoDTO getCotacao(String moeda){
        if(!moeda.equals("EUR") && !moeda.equals("USD")){
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
