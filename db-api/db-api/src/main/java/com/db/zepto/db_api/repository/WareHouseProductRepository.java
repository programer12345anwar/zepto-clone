package com.db.zepto.db_api.repository;

import com.db.zepto.db_api.model.WareHouseProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface WareHouseProductRepository extends JpaRepository<WareHouseProducts, UUID> {

    @Query(value = "select * from ware_house_products where wid=:wid",nativeQuery = true)
    public List<WareHouseProducts> findAllByWarehouseId(UUID wid);

    @Query(value = "select * from warehouse_products where wid=:wid and pid=:pid",nativeQuery = true)
    public WareHouseProducts getProductByWidPid(UUID wid, UUID pid);
}
