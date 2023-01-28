package br.com.ada.compra.moeda.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Pessoa {
    @Id
    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String estadoCivil;
    private String sexo;
}
