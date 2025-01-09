package com.soccer.service;

import com.soccer.entity.Player;
import com.soccer.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public List<Player> findAll() {
        return this.playerRepository.findAll();
    }

    public Optional<Player> findById(Long id) {
        return this.playerRepository.findById(id);
    }

    public String save(Player player) {
        return this.playerRepository.save(player);
    }
    public String updateById(Long id, Player player){
        return this.playerRepository.updateById(id, player);
    }
    public String deleteById(Long id) {
        return this.playerRepository.deleteById(id);
    }
}
