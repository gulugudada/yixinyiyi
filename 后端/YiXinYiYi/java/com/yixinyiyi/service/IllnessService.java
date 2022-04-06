package com.yixinyiyi.service;

import com.yixinyiyi.entity.Illness;

import java.util.List;

public interface IllnessService {
    public List<Illness> findAllIllness();
    public Illness findIllness(String illnessname);
}
