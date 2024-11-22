package com.kenmarcos.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenmarcos.dslist.dto.GameMinDTO;
import com.kenmarcos.dslist.entities.Game;
import com.kenmarcos.dslist.repositories.GameRepository;

@Service
public class GameService {

  // injetar uma instância do GameRepository dentro do GameService
  @Autowired
  private GameRepository gameRepository;

  public List<GameMinDTO> findAll() {
    List<Game> result = gameRepository.findAll();
    List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
    return dto;
  }
}
