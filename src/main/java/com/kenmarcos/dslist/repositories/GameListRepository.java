package com.kenmarcos.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kenmarcos.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
