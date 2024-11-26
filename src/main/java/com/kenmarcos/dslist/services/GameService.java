package com.kenmarcos.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kenmarcos.dslist.dto.GameDTO;
import com.kenmarcos.dslist.dto.GameMinDTO;
import com.kenmarcos.dslist.entities.Game;
import com.kenmarcos.dslist.projections.GameMinProjection;
import com.kenmarcos.dslist.repositories.GameRepository;

@Service
public class GameService {

  // injetar uma instância do GameRepository dentro do GameService
  @Autowired
  private GameRepository gameRepository;

  @Transactional(readOnly = true)
  public GameDTO findById(Long gameId) {
    Game result = gameRepository.findById(gameId).get();
    GameDTO dto = new GameDTO(result);
    return dto;
  }

  @Transactional(readOnly = true)
  public List<GameMinDTO> findAll() {
    List<Game> result = gameRepository.findAll();
    List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
    return dto;
  }

  @Transactional(readOnly = true)
  public List<GameMinDTO> findByGameList(Long gameListId) {
    List<GameMinProjection> result = gameRepository.searchByList(gameListId);
    List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
    return dto;
  }
}
