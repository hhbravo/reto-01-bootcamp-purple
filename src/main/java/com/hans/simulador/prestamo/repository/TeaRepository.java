package com.hans.simulador.prestamo.repository;

import com.hans.simulador.prestamo.model.Tea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeaRepository extends JpaRepository<Tea, Long> {
}
