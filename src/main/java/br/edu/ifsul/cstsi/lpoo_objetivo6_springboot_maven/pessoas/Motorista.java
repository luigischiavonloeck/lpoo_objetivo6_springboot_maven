package br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.pessoas;

import br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.pessoas.Pessoa;
import br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.alugueis.Aluguel;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "pessoa_id")
@Table(name = "motoristas")
public class Motorista extends Pessoa {
    private String numeroCNH;
    @OneToMany(mappedBy = "motorista")
    private List<Aluguel> alugueis;
}
