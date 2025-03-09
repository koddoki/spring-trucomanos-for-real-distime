package com.t5n.trucomanos_for_real_distime.model;

import lombok.Data;

@Data
public class Game {
    String id;
    Player player1;
    Player player2;
    GameStatus status;
}
