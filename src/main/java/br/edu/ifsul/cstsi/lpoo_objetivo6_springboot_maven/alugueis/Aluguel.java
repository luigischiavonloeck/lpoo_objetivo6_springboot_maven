package br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.alugueis;

import br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.apolices.ApoliceSeguro;
import br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.carros.Carro;
import br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.pessoas.Motorista;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "alugueis")
public class Aluguel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Calendar dataPedido;
    private Date dataEntrega;
    private Date dataDevolucao;
    private BigDecimal valorTotal;
    @ManyToOne
    @JoinColumn(name = "motorista_id", referencedColumnName = "id")
    private Motorista motorista;
    @Embedded
    private ApoliceSeguro apolice;
    @ManyToOne
    @JoinColumn(name = "carro_id", referencedColumnName = "id")
    private Carro carro;
}
