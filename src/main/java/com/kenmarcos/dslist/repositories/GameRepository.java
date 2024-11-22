package com.kenmarcos.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kenmarcos.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
