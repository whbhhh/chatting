package com.whb.dao;

import com.whb.entity.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RecruitDao extends JpaRepository<Recruit,String>, JpaSpecificationExecutor<Recruit> {

    List<Recruit> findTop4ByStateOrderByCreateTimeDesc(String state);
    List<Recruit> findTop12ByStateNotOrderByCreateTimeDesc(String state);
}
