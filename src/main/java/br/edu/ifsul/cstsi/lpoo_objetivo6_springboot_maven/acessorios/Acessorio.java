package br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.acessorios;

import br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.carros.Carro;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "acessorios")
public class Acessorio {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    @ManyToMany(mappedBy = "acessorios")
    private List<Carro> carros;
}
