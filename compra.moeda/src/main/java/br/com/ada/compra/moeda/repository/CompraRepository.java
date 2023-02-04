package br.com.ada.compra.moeda.repository;

import br.com.ada.compra.moeda.model.Compra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends CrudRepository<Compra, String> {
}
