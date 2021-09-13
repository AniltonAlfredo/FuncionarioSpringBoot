package com.principal.home.servicos;

import com.principal.home.exception.UserNotFoundException;
import com.principal.home.models.Funcionario;
import com.principal.home.repositorio.RepositorioFuncionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServicoFuncionario {
    private final RepositorioFuncionario rf;

    @Autowired
    public ServicoFuncionario(RepositorioFuncionario rf){
        this.rf=rf;
    }

    public Funcionario addFuncionario(Funcionario funcionario){
        funcionario.setCodigoFuncionario(UUID.randomUUID().toString());
        return rf.save(funcionario);
    }

    public List<Funcionario> findAllFuncionario(){
        return rf.findAll();
    }

    public Funcionario updateFuncionario(Funcionario funcionario){
        return rf.save(funcionario);
    }

    public Funcionario findFuncionarioByID(Long id){
        return rf.findFuncionarioById(id).orElseThrow(()
                -> new UserNotFoundException("Funcionario por id "+id+"não foi encontrado"));
    }

    public void deleteFuncionario(Long id){
        rf.deleteFuncionarioById(id);
    }

}
