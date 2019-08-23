package com.example.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.gmall.beans.PmsProductInfo;
import com.example.gmall.manage.mapper.PmsProductInfoMapper;
import com.example.gmall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private PmsProductInfoMapper pmsProductInfoMapper;

    @Override
    public List<PmsProductInfo> getSpuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        List<PmsProductInfo> productInfos = pmsProductInfoMapper.select(pmsProductInfo);
        return productInfos;
    }
}
