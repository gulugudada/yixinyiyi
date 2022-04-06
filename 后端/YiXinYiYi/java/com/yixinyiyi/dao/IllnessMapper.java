package com.yixinyiyi.dao;

import com.yixinyiyi.entity.Illness;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IllnessMapper {
    public List<Illness> findAllIllness();
    public Illness findIllness(String illnessname);
}
