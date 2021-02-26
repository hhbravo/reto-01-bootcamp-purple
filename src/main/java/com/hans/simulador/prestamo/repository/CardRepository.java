package com.hans.simulador.prestamo.repository;

import com.hans.simulador.prestamo.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CardRepository extends JpaRepository<Card,Long> {

    Optional<Card> findCardByValue(String card);

}
