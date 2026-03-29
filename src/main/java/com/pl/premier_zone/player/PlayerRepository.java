package com.pl.premier_zone.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    void deleteByPlayer(String playerName);
    Optional<Player> findByPlayer(String player);//Optional handles cases where player might not be found.

}
