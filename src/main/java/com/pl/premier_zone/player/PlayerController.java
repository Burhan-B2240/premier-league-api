package com.pl.premier_zone.player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    // GET /api/v1/player
    @GetMapping
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

    // GET /api/v1/player?team=Arsenal
    @GetMapping(params = "team")
    public List<Player> getPlayersFromTeam(@RequestParam String team) {
        return playerService.getPlayersFromTeam(team);
    }

    // GET /api/v1/player?name=Saka
    @GetMapping(params = "name")
    public List<Player> getPlayersByName(@RequestParam("name") String searchText) {
        return playerService.getPlayersByName(searchText);
    }

    // GET /api/v1/player?pos=FW
    @GetMapping(params = "pos")
    public List<Player> getPlayersByPosition(@RequestParam String pos) {
        return playerService.getPlayersByPosition(pos);
    }

    // GET /api/v1/player?nation=ENG
    @GetMapping(params = "nation")
    public List<Player> getPlayersByNation(@RequestParam String nation) {
        return playerService.getPlayersByNation(nation);
    }

    // GET /api/v1/player?team=Arsenal&pos=FW
    @GetMapping(params = {"team", "pos"})
    public List<Player> getPlayersByTeamAndPosition(
            @RequestParam String team,
            @RequestParam String pos) {
        return playerService.getPlayersByTeamAndPosition(team, pos);
    }

    // POST /api/v1/player
    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player savedPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
    }

    // PUT /api/v1/player
    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@RequestBody Player updatedPlayer,
                                               @PathVariable Long id) {
        Player player = playerService.updatePlayer(updatedPlayer, id);
        if (player != null) {
            return new ResponseEntity<>(player, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE /api/v1/player/{id} (Resource Identification via Path Parameter)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return new ResponseEntity<>("Player deleted succesfully",HttpStatus.OK);
    }
}