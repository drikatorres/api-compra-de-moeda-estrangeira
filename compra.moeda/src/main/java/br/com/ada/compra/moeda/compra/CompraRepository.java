package br.com.ada.compra.moeda.compra;

import br.com.ada.compra.moeda.compra.Compra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends CrudRepository<Compra, String> {
}
