package com.trading.DowJonesIndex.controller;

import com.trading.DowJonesIndex.model.DowJonesIndexStock;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author chaa060
 */

public interface DowJonesIndexStockController {

    @RequestMapping(path = "/load")
    void loadDowJonesIndexData();

    @RequestMapping(path = "/find")
    List<DowJonesIndexStock> findDowJonesIndexByStock(@Param("stock") String stock);

    @PostMapping("/add")
    DowJonesIndexStock createDowJonesIndex(@RequestBody DowJonesIndexStock dowJonesIndexStock) ;
}
