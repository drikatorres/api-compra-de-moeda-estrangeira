package br.com.ada.compra.moeda.repository;

import br.com.ada.compra.moeda.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, String> {
}
