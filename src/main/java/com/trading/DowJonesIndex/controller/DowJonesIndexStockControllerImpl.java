package com.trading.DowJonesIndex.controller;

import com.trading.DowJonesIndex.model.DowJonesIndexStock;
import com.trading.DowJonesIndex.service.DowJonesIndexStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chaa060
 */

@RestController
public class DowJonesIndexStockControllerImpl implements DowJonesIndexStockController {

    @Autowired
    private DowJonesIndexStockService dowJonesIndexStockService;

    public void loadDowJonesIndexData() {
        dowJonesIndexStockService.loadDowJonesIndexData();
    }

    @Override
    public List<DowJonesIndexStock> findDowJonesIndexByStock(String stock) {
        return dowJonesIndexStockService.findDowJonesIndexByStock(stock);
    }

    public DowJonesIndexStock createDowJonesIndex(DowJonesIndexStock dowJonesIndexStock) {
        return dowJonesIndexStockService.createDowJonesIndex(dowJonesIndexStock);
    }

}
