package br.com.ada.compra.moeda.dto;

import br.com.ada.compra.moeda.model.Cliente;
import lombok.*;

import java.time.LocalDate;

@Data
public class ClienteDTO {
    private final String cpf;
    private final String nome;
    private LocalDate nascimento;
    private String estadoCivil;
    private String sexo;

    public static ClienteDTO of(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO(cliente.getNome(), cliente.getCpf());
        dto.nascimento = cliente.getNascimento();
        dto.estadoCivil = cliente.getEstadoCivil();
        dto.sexo = cliente.getSexo();
        return dto;
    }

    public Cliente toEntity() {
        Cliente entity = new Cliente();
        entity.setNome(nome);
        entity.setCpf(cpf);
        entity.setNascimento(nascimento);
        entity.setEstadoCivil(estadoCivil);
        entity.setSexo(sexo);
        return entity;
    }
}
