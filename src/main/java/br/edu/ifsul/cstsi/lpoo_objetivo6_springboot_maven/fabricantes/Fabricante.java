package br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.fabricantes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fabricantes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fabricante {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Override
    public String toString() {
        return "Fabricante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
