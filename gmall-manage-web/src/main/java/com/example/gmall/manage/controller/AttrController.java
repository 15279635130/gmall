package com.example.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.gmall.beans.PmsBaseAttrInfo;
import com.example.gmall.beans.PmsBaseAttrValue;
import com.example.gmall.beans.PmsBaseSaleAttr;
import com.example.gmall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class AttrController {

    @Reference
    private AttrService attrService;

    // 获取销售属性列表
    @RequestMapping("/baseSaleAttrList")
    @ResponseBody
    public List<PmsBaseSaleAttr> getBaseSaleAttrList() {
        return attrService.getBaseSaleAttrList();
    }

    // 获取spu列表
    @RequestMapping("/getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        List<PmsBaseAttrValue> attrValues = attrService.getAttrValueList(attrId);
        return attrValues;
    }

    // 保存属性和属性值
    @RequestMapping("/saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo) {
        String success = attrService.saveAttrInfo(pmsBaseAttrInfo);
        return "success";
    }

    // 获取属性列表
    @RequestMapping("/attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        List<PmsBaseAttrInfo> attrInfos = attrService.attrInfoList(catalog3Id);
        return attrInfos;
    }
}
