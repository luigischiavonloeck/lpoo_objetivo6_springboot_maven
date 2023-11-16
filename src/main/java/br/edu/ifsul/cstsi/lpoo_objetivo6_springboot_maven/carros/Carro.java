package br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.carros;

import br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.modelosCarros.ModeloCarro;
import br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.acessorios.Acessorio;
import br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.alugueis.Aluguel;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "carros")
public class Carro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String chassi;
    private String cor;
    private BigDecimal valorDiaria;
    @OneToMany(mappedBy = "carro")
    private List<Aluguel> alugueis;
    @ManyToMany
    @JoinTable(
            name = "carros_acessorios",
            joinColumns = @JoinColumn(name = "carro_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "acessorio_id", referencedColumnName = "id")
    )
    private List<Acessorio> acessorios;
    @ManyToOne
    @JoinColumn(name = "modelo_id", referencedColumnName = "id")
    private ModeloCarro modelo;
}
