package com.principal.home;

import com.principal.home.models.Funcionario;
import com.principal.home.servicos.ServicoFuncionario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final ServicoFuncionario sf;

    public FuncionarioController(ServicoFuncionario sf) {
        this.sf = sf;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Funcionario>> getAllFuncionario(){
        List<Funcionario> funcionarios=sf.findAllFuncionario();
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable("id") Long id){
        Funcionario funcionario=sf.findFuncionarioByID(id);
        return new ResponseEntity<>(funcionario, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Funcionario> addFuncionario(@RequestBody Funcionario funcionario){
        Funcionario novoFuncionario=sf.addFuncionario(funcionario);
        return new ResponseEntity<>(novoFuncionario,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Funcionario> updateFuncionario(@RequestBody Funcionario funcionario){
        Funcionario updateFuncionario=sf.updateFuncionario(funcionario);
        return new ResponseEntity<>(updateFuncionario,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFuncionario(@PathVariable("id") Long id){
        sf.deleteFuncionario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
