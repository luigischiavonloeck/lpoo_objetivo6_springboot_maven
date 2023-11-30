package br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.pessoas;

import br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.fabricantes.Fabricante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository rep;

    public List<Motorista> getMotoristas() {return rep.findAll();}

    public Motorista getMotoristaById(Long id){
        Optional<Motorista> optional = rep.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    public List<Motorista> getMotoristaByName(String name){
        return new ArrayList<>(rep.findByNome(name + "%"));
    }

    public Motorista getMotoristaByCnh(String cnh){
        return rep.findByCnh(cnh);
    }

    public List<Motorista> getMotoristaBySex(Sexo sex){
        return new ArrayList<>(rep.findBySexo(sex));
    }

    public Motorista insert(Motorista motorista){
        Assert.isNull(motorista.getId(),"Erro ao inserir motorista");
        return rep.save(motorista);
    }

    public Motorista update(Motorista motorista){
        Assert.notNull(motorista.getId(),"Erro ao atualizar o motorista");

        Optional<Motorista> optional = rep.findById(motorista.getId());
        if(optional.isPresent()){
            Motorista db = optional.get();
            db.setNome(motorista.getNome());
            db.setCpf(motorista.getCpf());
            db.setDataNascimento(motorista.getDataNascimento());
            db.setSexo(motorista.getSexo());
            db.setNumeroCNH(motorista.getNumeroCNH());
            db.setAlugueis(motorista.getAlugueis());
            rep.save(db);
            return db;
        } else {
            return null;
        }
    }

    public void delete(Long id){rep.deleteById(id);}
}
