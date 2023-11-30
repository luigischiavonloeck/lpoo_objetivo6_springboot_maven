package br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.alugueis;

import br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.fabricantes.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository rep;

    public Aluguel getAluguelById(Long id){
        Optional<Aluguel> optional = rep.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }
}
