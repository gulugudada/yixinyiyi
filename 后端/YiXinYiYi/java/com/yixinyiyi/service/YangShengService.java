package com.yixinyiyi.service;

import com.yixinyiyi.entity.Reason;
import com.yixinyiyi.entity.YangSheng;

import java.util.List;

public interface YangShengService {
    public List<YangSheng> findAllYangSheng();
    public List<YangSheng> findYangSheng(YangSheng yangSheng);
    public List<Reason> findAllReason();
    public String findReason(String season);
    public String findImage(String season);
}
