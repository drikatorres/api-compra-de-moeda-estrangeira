package mscompra;

import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class PessoaApiClient {
    private final static String endpoint = "http://localhost:8082/";

    private final RestTemplate restTemplate;

    public boolean existePessoa(String cpf) {

        return false;
    }
}
