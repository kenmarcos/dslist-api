package com.kenmarcos.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kenmarcos.dslist.dto.GameListDTO;
import com.kenmarcos.dslist.dto.GameMinDTO;
import com.kenmarcos.dslist.services.GameListService;
import com.kenmarcos.dslist.services.GameService;

@RestController
@RequestMapping(value = "/gameLists") // configurar a rota
public class GameListController {

  @Autowired
  private GameListService gameListService;

  @Autowired
  private GameService gameService;

  @GetMapping
  public List<GameListDTO> findAll() {
    List<GameListDTO> result = gameListService.findAll();

    return result;
  }

  @GetMapping(value = "/{gameListId}/games")
  public List<GameMinDTO> findByGameList(@PathVariable Long gameListId) {
    List<GameMinDTO> result = gameService.findByGameList(gameListId);

    return result;
  }
}
