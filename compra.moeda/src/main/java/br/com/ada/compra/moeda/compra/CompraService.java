package br.com.ada.compra.moeda.compra;

import br.com.ada.compra.moeda.comum.EntidadeDuplicadaException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class CompraService {
    private final CrudRepository<Compra, String> repository;

    public Optional<Compra> getById(String id) {
        return repository.findById(id);
    }
    public void adicionar(Compra entity) throws EntidadeDuplicadaException {
        if (repository.existsById(entity.getId())) {
            throw new EntidadeDuplicadaException();
        }
        repository.save(entity);
    }
}