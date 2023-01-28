package br.com.ada.compra.moeda.controller;

import br.com.ada.compra.moeda.dto.PessoaDTO;
import br.com.ada.compra.moeda.model.Pessoa;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {
   // private final PessoaService service;
    private final CrudRepository<Pessoa, String> service;
    @GetMapping("{cpf}")
    public ResponseEntity<PessoaDTO> getByCpf(@PathVariable String cpf) {
        if (cpf == null || cpf.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado um CPF!");
        }
        String clearCpf = cpf.replaceAll("[\\.-]", "");
        //Optional<Pessoa> encontrado = service.getById(cpf);
        //Pessoa entity = encontrado.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi localizada uma pessoa com o CPF informado!"));
        //return ResponseEntity.ok(PessoaDTO.of(entity));
        return null;
    }

    @PostMapping()
    public ResponseEntity<Void> add(@RequestBody PessoaDTO pessoa) {
        if (pessoa == null || pessoa.getCpf() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma pessoa válida");
        }
        String clearCpf = pessoa.getCpf().replaceAll("[\\.-]", "");
        if (clearCpf.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma pessoa com CPF válido");
        }
        if (pessoa.getNome() == null || pessoa.getNome().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma pessoa com Nome válido");
        }
       /* try {
            service.adicionar(pessoa.toEntity());
        } catch (EntidadeDuplicadaException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe uma pessoa com o CPF informado");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro desconhecido");
        } */
        return ResponseEntity.created(URI.create("/api/pessoa/" + clearCpf)).build();
    }
}

