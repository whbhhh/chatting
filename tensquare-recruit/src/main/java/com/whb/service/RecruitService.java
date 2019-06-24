package com.whb.service;

import com.whb.dao.RecruitDao;
import com.whb.entity.Recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitService {

    @Autowired
    private RecruitDao recruitDao;

    public List<Recruit> findTop4ByState() {
        return recruitDao.findTop4ByStateOrderByCreateTimeDesc("2");
    }

    public List<Recruit> findTop12ByStateNot() {
        return recruitDao.findTop12ByStateNotOrderByCreateTimeDesc("0");
    }
}
