package br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.pessoas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MotoristaRepository extends JpaRepository<Motorista,Long> {
    @Query(value = "select m from Motorista m where m.nome like ?1")
    List<Motorista> findByNome(String nome);

    @Query(value = "select m from Motorista m where m.numeroCNH = ?1")
    Motorista findByCnh(String numeroCNH);

    @Query(value = "select m from Motorista m where m.sexo = ?1")
    List<Motorista> findBySexo(Sexo sexo);
}
