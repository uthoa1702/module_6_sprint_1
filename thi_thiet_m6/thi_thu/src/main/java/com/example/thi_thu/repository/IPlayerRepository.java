package com.example.thi_thu.repository;

import com.example.thi_thu.dto.IPlayerDTO;
import com.example.thi_thu.model.PlayerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlayerRepository extends JpaRepository<PlayerModel, Long> {
    @Query(value = "SELECT tm.name AS teamModel, player_model.id AS id, player_model.name AS name, COUNT(player_model_id) AS scoreTimes\n" +
            "FROM player_model\n" +
            "         INNER JOIN penalty P ON player_model.id = P.player_model_id\n" +
            "         INNER JOIN team_model TM ON player_model.team_model_id = TM.id\n" +
            "WHERE P.is_delete = FALSE\n" +
            "  AND p.result = TRUE\n" +
            "GROUP BY P.player_model_id\n" +
            "ORDER BY SCORETIMES DESC\n" +
            "LIMIT 5;",nativeQuery = true)
    List<IPlayerDTO> getList();
}
