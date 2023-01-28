package br.com.ada.compra.moeda.model;

import lombok.*;
import javax.persistence.Id;
import java.time.LocalDate;
@Data
public class Pessoa {
    @Id
    private final String cpf;
    private final String nome;
    private LocalDate nascimento;
    private String estadoCivil;
    private String sexo;
}
