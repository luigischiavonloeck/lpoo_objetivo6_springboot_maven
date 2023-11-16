package br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.pessoas;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pessoas")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
}
