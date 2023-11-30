package br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.alugueis;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AluguelRepository extends JpaRepository<Aluguel,Long> {
}
