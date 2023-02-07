package mscompra;

import lombok.RequiredArgsConstructor;
import mscomum.EntidadeDuplicadaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/compra")
public class CompraController {
    private final CompraService service;

    @GetMapping("{id}")
    public ResponseEntity<CompraDTO> getById(@PathVariable String id) {
        if (id == null || id.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado um ID!");
        }
        Compra entity = service.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi localizada uma compra com o ID informado!"));
        return ResponseEntity.ok(CompraDTO.of(entity));
    }

    @PostMapping()
    public ResponseEntity<Void> add(@RequestBody CompraDTO compra) {
        if (compra == null || compra.getCpf() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma compra válida");
        }
        String clearCpf = compra.getCpf().replaceAll("[\\.-]", "");
        if (clearCpf.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado um cliente com CPF válido");
        }
        if (compra.getValor() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada um valor valido");
        }
        if (compra.getId() == null || compra.getId().isBlank()) {
            compra.setId(UUID.randomUUID().toString());
        }
        if (compra.getAgencia() == null || compra.getAgencia().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma agencia valida");
        }
        if (compra.getMoeda() == null ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma moeda valida");
        }
        try {
            service.adicionar(compra.toEntity());
        } catch (EntidadeDuplicadaException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe uma compra com o ID informado");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro desconhecido");
        }
        return ResponseEntity.created(URI.create("/api/compra/" + compra.getId())).build();
    }
}

