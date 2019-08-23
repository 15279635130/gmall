package com.example.gmall.service;

import com.example.gmall.beans.PmsBaseAttrInfo;
import com.example.gmall.beans.PmsBaseAttrValue;
import com.example.gmall.beans.PmsBaseSaleAttr;

import java.util.List;

public interface AttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    List<PmsBaseSaleAttr> getBaseSaleAttrList();
}
