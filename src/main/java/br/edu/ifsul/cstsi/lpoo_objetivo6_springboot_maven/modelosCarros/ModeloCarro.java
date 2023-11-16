package br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.modelosCarros;

import br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.fabricantes.Fabricante;
import jakarta.persistence.*;

@Entity
@Table(name = "modelos_carros")
public class ModeloCarro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "fabricante_id", referencedColumnName = "id")
    private Fabricante fabricante;
}

// herança
// enumeration
// embedded
// muitos para muitos