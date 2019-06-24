package com.whb.dao;

import com.whb.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface LabelRepository extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {

    List<Label> findByRecommend(String recommend);
}
