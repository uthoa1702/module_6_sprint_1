package com.example.thi_thu.repository;

import com.example.thi_thu.model.Penalty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPenaltyRepository extends JpaRepository<Penalty, Long> {

    @Query(value = "SELECT *\n" +
            "FROM penalty\n" +
            "         INNER JOIN player_model PM ON penalty.player_model_id = PM.id\n" +
            "WHERE is_delete = FALSE\n" +
            "  AND PM.name LIKE :name",nativeQuery = true)
    Page<Penalty> findAllPen(Pageable pageable, @Param("name") String name);


    @Modifying
    @Query(value = "UPDATE penalty SET is_delete = TRUE WHERE id = :id",nativeQuery = true)
    void deletePen(@Param("id") Long id);
}
