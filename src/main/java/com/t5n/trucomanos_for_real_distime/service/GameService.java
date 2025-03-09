package com.t5n.trucomanos_for_real_distime.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.t5n.trucomanos_for_real_distime.exception.InvalidGameException;
import com.t5n.trucomanos_for_real_distime.exception.InvalidParamException;
import com.t5n.trucomanos_for_real_distime.exception.NotFoundException;
import com.t5n.trucomanos_for_real_distime.model.Game;
import com.t5n.trucomanos_for_real_distime.model.GameStatus;
import com.t5n.trucomanos_for_real_distime.model.Player;
import com.t5n.trucomanos_for_real_distime.storage.GameStorage;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GameService {
    public Game createGame(Player player) {
        Game game = new Game();
        game.setId(UUID.randomUUID().toString());
        game.setPlayer1(player);
        game.setStatus(GameStatus.NEW);
        GameStorage.getInstance().setGame(game);
        return game;
    }

    public Game connectToGame(Player player2, String gameId) throws InvalidParamException, InvalidGameException {
        if (!GameStorage.getInstance().getGames().containsKey(gameId)) {
            throw new InvalidParamException("Game with provided id doesn't exist, seu bobão");
        }

        Game game = GameStorage.getInstance().getGames().get(gameId);

        if (game.getPlayer2() != null) {
            throw new InvalidGameException("Game já startou");
        }

        game.setPlayer2(player2);
        game.setStatus(GameStatus.ONGOING);
        GameStorage.getInstance().setGame(game);

        return game;

    }

    public Game connectToRandomGame(Player player2) throws NotFoundException {
        Game game = GameStorage.getInstance().getGames().values().stream()
                .filter(it -> it.getStatus().equals(GameStatus.NEW)).findFirst()
                .orElseThrow(() -> new NotFoundException("Não tem jogo aberto, cria um ai"));

        game.setPlayer2(player2);
        game.setStatus(GameStatus.ONGOING);
        GameStorage.getInstance().setGame(game);
        return game;
    }
}
