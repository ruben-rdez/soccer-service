package com.soccer.service;

import com.soccer.DataProvider;
import com.soccer.entity.Player;
import com.soccer.repository.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    @Test
    public void testFindAll(){
        when(playerRepository.findAll()).thenReturn(DataProvider.playerListMock());
        List<Player> result = playerService.findAll();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals("Suki Rodriguez", result.get(0).getName());
        assertEquals("Milan", result.get(0).getTeam());
        assertEquals("Goalkeeper", result.get(0).getPosition());
        verify(this.playerRepository).findAll();
    }

    @Test
    public void testFindById(){
        Long id = 1L;
        when(this.playerRepository.findById( anyLong() )).thenReturn(Optional.of(DataProvider.playerMock()));
        Optional<Player> player = this.playerService.findById(id);

        assertNotNull(player);
        assertEquals("Suki Rodriguez", player.get().getName());
        assertEquals("Milan", player.get().getTeam());
        assertEquals("Goalkeeper", player.get().getPosition());
        verify(this.playerRepository).findById( anyLong() );
    }

    @Test
    public void testSave(){
        Player player = DataProvider.newPlayerMock();
        this.playerService.save(player);

        ArgumentCaptor<Player> playerArgumentCaptor = ArgumentCaptor.forClass(Player.class);
        verify(this.playerRepository).save( any(Player.class) );
        verify(this.playerRepository).save( playerArgumentCaptor.capture() );
        assertEquals(10L, playerArgumentCaptor.getValue().getId());
        assertEquals("Lokis Medina", playerArgumentCaptor.getValue().getName());
    }

    @Test
    public void testDeleteById(){
        Long id = 1L;
        this.playerService.deleteById(id);

        ArgumentCaptor<Long> longArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(this.playerRepository).deleteById( anyLong() );
        verify(this.playerRepository).deleteById( longArgumentCaptor.capture() );
        assertEquals(1L, longArgumentCaptor.getValue());
    }

    @Test
    public void testUpdateById(){
        Long id = 1L;
        Player player = DataProvider.updatePlayerMock();
        this.playerService.updateById(id, player);

        ArgumentCaptor<Player> playerArgumentCaptor = ArgumentCaptor.forClass(Player.class);
        verify(this.playerRepository).updateById(anyLong(), any(Player.class) );
        verify(this.playerRepository).updateById(anyLong(), playerArgumentCaptor.capture() );
        assertEquals(1L, playerArgumentCaptor.getValue().getId());
        assertEquals("Suki Rodriguez", playerArgumentCaptor.getValue().getName());
        assertEquals("Goalkeeper", playerArgumentCaptor.getValue().getPosition());
        assertEquals("America", playerArgumentCaptor.getValue().getTeam());
    }
}