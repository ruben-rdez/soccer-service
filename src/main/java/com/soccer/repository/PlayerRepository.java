package com.soccer.repository;

import com.soccer.entity.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PlayerRepository {

    private final List<Player> players = new ArrayList<>();

    public List<Player> findAll(){
        return this.players;
    }

    public Optional<Player> findById(Long id){
        return this.players.stream()
                .filter(player -> player.getId() == id)
                .findFirst();
    }

    public String save(Player player){
        this.players.add(player);
        return "Player has been saved";
    }

    public String updateById(Long id, Player updatedPlayer) {
        return findById(id).map(player -> {
            players.remove(player);
            players.add(updatedPlayer);
            return "Player has been updated";
        }).orElse("Player not found");
    }

    public String deleteById(Long id){
        return findById(id).map(player -> {
            players.remove(player);
            return "Player has been deleted";
        }).orElse("Player not found");
    }
}
