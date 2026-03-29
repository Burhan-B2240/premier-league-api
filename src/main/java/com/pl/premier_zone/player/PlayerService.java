package com.pl.premier_zone.player;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    public List<Player> getPlayersFromTeam(String team){
        return playerRepository.findAll().stream()
                .filter(player -> team.equalsIgnoreCase(player.getTeam()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByName(String searchText){
        return playerRepository.findAll().stream()
                .filter(player -> player.getPlayer().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByPosition(String pos){
        return playerRepository.findAll().stream()
                .filter(player -> pos.equalsIgnoreCase(player.getPos()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByNation(String nation){
        return playerRepository.findAll().stream()
                .filter(player -> player.getPlayer().toLowerCase().contains(nation.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByTeamAndPosition(String team, String pos){
        return playerRepository.findAll().stream()
                .filter(player -> pos.equalsIgnoreCase(player.getPos()) && team.equalsIgnoreCase(player.getTeam()))
                .collect(Collectors.toList());
    }

    public Player addPlayer(Player player){
        playerRepository.save(player);
        return player;
    }

    public Player updatePlayer(Player updatedPlayer, Long id){
        Optional<Player> existingPlayer = playerRepository.findById(id);

        if(existingPlayer.isPresent()){
            Player playerToUpdate = existingPlayer.get();

            playerToUpdate.setPlayer(updatedPlayer.getPlayer());
            playerToUpdate.setNation(updatedPlayer.getNation());
            playerToUpdate.setPos(updatedPlayer.getPos());
            playerToUpdate.setAge(updatedPlayer.getAge());
            playerToUpdate.setMp(updatedPlayer.getMp());
            playerToUpdate.setStarts(updatedPlayer.getStarts());
            playerToUpdate.setMinutes(updatedPlayer.getMinutes());
            playerToUpdate.setGls(updatedPlayer.getGls());
            playerToUpdate.setAst(updatedPlayer.getAst());
            playerToUpdate.setPk(updatedPlayer.getPk());
            playerToUpdate.setCrdy(updatedPlayer.getCrdy());
            playerToUpdate.setCrdr(updatedPlayer.getCrdr());
            playerToUpdate.setXg(updatedPlayer.getXg());
            playerToUpdate.setXag(updatedPlayer.getXag());
            playerToUpdate.setTeam(updatedPlayer.getTeam());

            playerRepository.save(playerToUpdate);
            return updatedPlayer;
        }
        return null;
    }

    //Transactional guarantees that the method either completely succeeds and saves the changes (a commit),
    // or if an error happens, it completely undoes everything (a rollback) so your database doesn't get corrupted.
    @Transactional
    public void deletePlayer(Long id){
        playerRepository.deleteById(id);
    }
}
