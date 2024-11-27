package com.kenmarcos.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kenmarcos.dslist.dto.GameListDTO;
import com.kenmarcos.dslist.entities.GameList;
import com.kenmarcos.dslist.projections.GameMinProjection;
import com.kenmarcos.dslist.repositories.GameListRepository;
import com.kenmarcos.dslist.repositories.GameRepository;

@Service
public class GameListService {

  @Autowired
  private GameListRepository gameListRepository;

  @Autowired
  GameRepository gameRepository;

  @Transactional(readOnly = true)
  public List<GameListDTO> findAll() {
    List<GameList> result = gameListRepository.findAll();
    List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
    return dto;
  }

  @Transactional
  public void move(Long gameListId, int sourceIndex, int destinationIndex) {
    List<GameMinProjection> gameList = gameRepository.searchByList(gameListId);

    GameMinProjection game = gameList.remove(sourceIndex);
    gameList.add(destinationIndex, game);

    int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
    int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

    for (int i = min; i <= max; i++) {
      gameListRepository.updateBelongingPosition(gameListId, gameList.get(i).getId(), i);
    }
  }
}
