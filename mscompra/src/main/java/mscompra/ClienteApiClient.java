package mscliente;

@RequiredArgsConstructor
public class PessoaApiClient {
    private final static String endpoint = "http://localhost:8081/";

    private final RestTemplate restTemplate;

    public boolean existePessoa(String cpf) {

    }
