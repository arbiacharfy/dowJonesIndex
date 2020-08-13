package com.trading.DowJonesIndex.repository;

import com.trading.DowJonesIndex.model.DowJonesIndexStock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chaa060
 */

@Repository
public interface DowJonesIndexStockRepository extends CrudRepository<DowJonesIndexStock, Integer> {

    @Query("SELECT p FROM DowJonesIndexStock p WHERE LOWER(p.stock) = LOWER(:stock)")
    List<DowJonesIndexStock> findByStock(String stock);
}
