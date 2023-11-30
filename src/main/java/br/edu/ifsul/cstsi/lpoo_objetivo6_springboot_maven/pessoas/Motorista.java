package br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.pessoas;

import br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.pessoas.Pessoa;
import br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.alugueis.Aluguel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@PrimaryKeyJoinColumn(name = "pessoa_id")
@Table(name = "motoristas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Motorista extends Pessoa {
    private String numeroCNH;
    @OneToMany(mappedBy = "motorista",fetch = FetchType.EAGER)
    private List<Aluguel> alugueis;

    @Override
    public String toString() {
        return "\nMotorista{" +
                "numeroCNH='" + numeroCNH + '\'' +
                ", alugueis=" + alugueis +
                "} " + super.toString();
    }
}
