package com.db.zepto.db_api.repository;

import com.db.zepto.db_api.model.WareHouseProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface WareHouseProductRepository extends JpaRepository<WareHouseProducts, UUID> {

    List<WareHouseProducts> findAllByWarehouseId(UUID wid);
}
