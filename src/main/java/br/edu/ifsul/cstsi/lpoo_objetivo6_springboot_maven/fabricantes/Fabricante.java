package br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.fabricantes;

import jakarta.persistence.*;

@Entity
@Table(name = "fabricantes")
public class Fabricante {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
}
