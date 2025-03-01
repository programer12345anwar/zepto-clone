package com.db.zepto.db_api.controller;

import com.db.zepto.db_api.model.WareHouseProducts;
import com.db.zepto.db_api.repository.WareHouseProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/warehouse/product")
public class WareHouseProductController {
    private WareHouseProductRepository wareHouseProductRepository;
    @Autowired
    public WareHouseProductController(WareHouseProductRepository wareHouseProductRepository) {
        this.wareHouseProductRepository=wareHouseProductRepository;
    }
    @PostMapping("/save")
    public WareHouseProducts addProducts(@RequestBody WareHouseProducts products) {
        wareHouseProductRepository.save(products);
        return products;
    }
    @GetMapping("/{wid}")
    public List<WareHouseProducts> getAllProductsByWid(@PathVariable UUID wid) {
         return wareHouseProductRepository.findAllByWarehouseId(wid);
    }
    @GetMapping("/{wid}/{pid}")
    public WareHouseProducts getProductByWidAndPid(@PathVariable UUID wid, @PathVariable UUID pid) {
        return wareHouseProductRepository.getProductByWidPid(wid, pid);
    }
}
