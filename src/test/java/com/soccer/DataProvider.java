package com.soccer;

import com.soccer.entity.Player;

import java.util.List;

public class DataProvider {

    public static List<Player> playerListMock() {
        return List.of(
                new Player(1L, "Suki Rodriguez", "Milan", "Goalkeeper"),
                new Player(2L, "Tutsis Rodriguez", "Milan", "Striker"),
                new Player(3L, "Lokis Medina", "Paris Saint-Germain", "Defensive"),
                new Player(4L, "Bolo Navarro", "Paris Saint-Germain", "Defensive"),
                new Player(5L, "Narita Medina", "Manchester City", "Center"),
                new Player(6L, "Camila Navarro", "Liverpool", "Center")
        );
    }

    public static Player playerMock(){
        return new Player(1L, "Suki Rodriguez", "Milan", "Goalkeeper");
    }

    public static Player newPlayerMock(){
        return new Player(10L, "Lokis Medina", "Striker", "Liverpool");
    }

    public static Player updatePlayerMock(){
        return new Player(1L, "Suki Rodriguez", "America", "Goalkeeper");
    }
}
