package br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.fabricantes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FabricanteRepository extends JpaRepository<Fabricante,Long> {
    @Query(value = "select f from Fabricante f where f.nome like ?1")
    List<Fabricante> findByNome(String nome);
}
