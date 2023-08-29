package com.example.thi_thu.repository;

import com.example.thi_thu.model.TeamModel;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeamRepository extends JpaRepository<TeamModel, Long> {
}
