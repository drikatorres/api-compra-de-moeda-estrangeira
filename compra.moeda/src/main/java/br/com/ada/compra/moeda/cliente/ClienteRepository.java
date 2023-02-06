package br.com.ada.compra.moeda.cliente;

import br.com.ada.compra.moeda.cliente.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String> {
}
