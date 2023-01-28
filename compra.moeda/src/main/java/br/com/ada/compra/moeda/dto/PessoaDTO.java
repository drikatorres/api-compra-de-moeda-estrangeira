package br.com.ada.compra.moeda.dto;

import br.com.ada.compra.moeda.model.Pessoa;
import lombok.*;

import java.time.LocalDate;

@Data
public class PessoaDTO {
    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String estadoCivil;
    private String sexo;

    public static PessoaDTO of(Pessoa pessoa) {
        PessoaDTO dto = new PessoaDTO();
        dto.nome = pessoa.getNome();
        dto.cpf = pessoa.getCpf();
        dto.nascimento = pessoa.getNascimento();
        dto.estadoCivil = pessoa.getEstadoCivil();
        dto.sexo = pessoa.getSexo();
        return dto;
    }

    public Pessoa toEntity() {
        Pessoa entity = new Pessoa();
        entity.setNome(nome);
        entity.setCpf(cpf);
        entity.setNascimento(nascimento);
        entity.setEstadoCivil(estadoCivil);
        entity.setSexo(sexo);
        return entity;
    }
}
