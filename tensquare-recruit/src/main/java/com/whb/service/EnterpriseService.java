package com.whb.service;

import com.whb.dao.EnterpriseDao;
import com.whb.entity.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseDao enterpriseDao;
    public List<Enterprise> search() {
        return enterpriseDao.findByIshot("1");
    }
}
