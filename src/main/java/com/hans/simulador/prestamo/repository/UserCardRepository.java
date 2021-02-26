package com.hans.simulador.prestamo.repository;

import com.hans.simulador.prestamo.model.UserCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCardRepository extends JpaRepository<UserCard,Long> {

    Optional<UserCard> findByUsuarioIdAndTarjetaId(Integer cardId, Integer userId);

}
