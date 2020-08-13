package com.trading.DowJonesIndex.service;

import com.trading.DowJonesIndex.model.DowJonesIndexStock;

import java.util.List;

/**
 * @author chaa060
 */
public interface DowJonesIndexStockService {
    void loadDowJonesIndexData();
    List<DowJonesIndexStock> findDowJonesIndexByStock(String stock);
    DowJonesIndexStock createDowJonesIndex(DowJonesIndexStock dowJonesIndexStock);
}
