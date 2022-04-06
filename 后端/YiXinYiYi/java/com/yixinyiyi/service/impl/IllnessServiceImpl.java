package com.yixinyiyi.service.impl;

import com.yixinyiyi.dao.IllnessMapper;
import com.yixinyiyi.entity.Illness;
import com.yixinyiyi.service.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IllnessServiceImpl implements IllnessService {

    @Autowired
    IllnessMapper illnessMapper;

    @Override
    public List<Illness> findAllIllness() {
        return illnessMapper.findAllIllness();
    }

    @Override
    public Illness findIllness(String illnessname) {
        return illnessMapper.findIllness(illnessname);
    }
}
