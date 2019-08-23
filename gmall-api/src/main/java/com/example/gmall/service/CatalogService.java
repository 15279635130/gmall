package com.example.gmall.service;

import com.example.gmall.beans.PmsBaseCatalog1;
import com.example.gmall.beans.PmsBaseCatalog2;
import com.example.gmall.beans.PmsBaseCatalog3;

import java.util.List;

public interface CatalogService {

    public List<PmsBaseCatalog1> getCatalog1();

    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
