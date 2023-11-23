package br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.fabricantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FabricanteService {

    @Autowired
    private FabricanteRepository rep;

    public List<Fabricante> getFabricantes(){
        return rep.findAll();
    }

    public Fabricante getFabricanteById(Long id){
        Optional<Fabricante> optional = rep.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    public List<Fabricante> getFabricanteByName(String name){
        return new ArrayList<>(rep.findByNome(name + "%"));
    }

    public Fabricante insert(Fabricante fabricante){
        Assert.isNull(fabricante.getId(),"Erro ao inserir fabricante");
        return rep.save(fabricante);
    }

    public Fabricante update(Fabricante fabricante){
        Assert.notNull(fabricante.getId(),"Erro ao atualizar o fabricante");

        Optional<Fabricante> optional = rep.findById(fabricante.getId());
        if(optional.isPresent()){
            Fabricante db = optional.get();
            db.setNome(fabricante.getNome());
            rep.save(db);
            return db;
        } else {
            return null;
        }
    }

    public void delete(Long id){
        rep.deleteById(id);
    }
}
