package br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.pessoas;

import br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.pessoas.Pessoa;
import br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.alugueis.Aluguel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "pessoa_id")
@Table(name = "motoristas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Motorista extends Pessoa {
    private String numeroCNH;
    @OneToMany(mappedBy = "motorista",fetch = FetchType.EAGER)
    private List<Aluguel> alugueis;
}
