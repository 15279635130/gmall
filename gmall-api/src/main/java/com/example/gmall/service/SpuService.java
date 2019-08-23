package com.example.gmall.service;

import com.example.gmall.beans.PmsProductInfo;

import java.util.List;

public interface SpuService {
    List<PmsProductInfo> getSpuList(String catalog3Id);
}
