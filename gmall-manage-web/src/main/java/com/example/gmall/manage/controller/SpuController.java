package com.example.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.gmall.beans.PmsProductInfo;
import com.example.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@CrossOrigin
public class SpuController {

    @Reference
    private SpuService spuService;

    @RequestMapping("/fileUpload")
    @ResponseBody
    public String fileUpload(MultipartFile file) {

        // 将图片保存到FastDFS图片服务器
        String imgUrl = "http://img14.360buyimg.com/n0/jfs/t11266/172/3136897597/311385/898550cb/5ce41430N7bb10f75.jpg";
        return imgUrl;
    }

    @RequestMapping("/saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo) {

        return "success";
    }

    @RequestMapping("/spuList")
    @ResponseBody
    public List<PmsProductInfo> getSpuList(String catalog3Id) {
        List<PmsProductInfo> productInfos = spuService.getSpuList(catalog3Id);
        return productInfos;
    }
}
