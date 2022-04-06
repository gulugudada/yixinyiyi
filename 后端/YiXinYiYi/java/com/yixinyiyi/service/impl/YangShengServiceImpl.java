package com.yixinyiyi.service.impl;

import com.yixinyiyi.dao.YangShengMapper;
import com.yixinyiyi.entity.Reason;
import com.yixinyiyi.entity.YangSheng;
import com.yixinyiyi.service.YangShengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YangShengServiceImpl implements YangShengService {

    @Autowired
    YangShengMapper yangShengMapper;

    @Override
    public List<YangSheng> findAllYangSheng() {
        return yangShengMapper.findAllYangSheng();
    }

    @Override
    public List<YangSheng> findYangSheng(YangSheng yangSheng) {
        return yangShengMapper.findYangSheng(yangSheng);
    }

    @Override
    public List<Reason> findAllReason() {
        return yangShengMapper.findAllReason();
    }

    @Override
    public String findReason(String season) {
        return yangShengMapper.findReason(season);
    }

    @Override
    public String findImage(String season) {
        return yangShengMapper.findImage(season);
    }
}
