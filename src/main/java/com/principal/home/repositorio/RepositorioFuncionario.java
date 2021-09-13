package com.principal.home.repositorio;

import com.principal.home.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositorioFuncionario extends JpaRepository<Funcionario, Long> {
    void deleteFuncionarioById(Long id);

    Optional<Funcionario> findFuncionarioById(Long id);
}
