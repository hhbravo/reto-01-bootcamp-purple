package com.hans.simulador.prestamo.repository;

import com.hans.simulador.prestamo.model.Parametro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametroRepository extends JpaRepository<Parametro, Long> {
}
