package com.example.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.gmall.beans.PmsBaseAttrInfo;
import com.example.gmall.beans.PmsBaseAttrValue;
import com.example.gmall.beans.PmsBaseSaleAttr;
import com.example.gmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.example.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.example.gmall.manage.mapper.PmsBaseSaleAttrMapper;
import com.example.gmall.service.AttrService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    private PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;

    @Autowired
    private PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Autowired
    private PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;

    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> attrInfos = pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);
        return attrInfos;
    }

    @Override
    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        // 根据ID判断是新增还是修改数据
        String id = pmsBaseAttrInfo.getId();
        if (StringUtils.isBlank(id)) {
            // 新增属性
            pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);

            // 新增属性值
            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
            }
        } else {
            // 修改属性
            Example example = new Example(PmsBaseAttrInfo.class);
            example.createCriteria().andEqualTo("id", pmsBaseAttrInfo.getId());
            pmsBaseAttrInfoMapper.updateByExample(pmsBaseAttrInfo, example);

            // 修改属性值（先删除后添加）
            PmsBaseAttrValue pmsBaseAttrValueDel = new PmsBaseAttrValue();
            pmsBaseAttrValueDel.setAttrId(pmsBaseAttrInfo.getId());
            pmsBaseAttrValueMapper.delete(pmsBaseAttrValueDel);

            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
            }

        }
        return "success";
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        List<PmsBaseAttrValue> attrValues = pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
        return attrValues;
    }

    @Override
    public List<PmsBaseSaleAttr> getBaseSaleAttrList() {
        List<PmsBaseSaleAttr> saleAttrs = pmsBaseSaleAttrMapper.selectAll();
        return saleAttrs;
    }
}
