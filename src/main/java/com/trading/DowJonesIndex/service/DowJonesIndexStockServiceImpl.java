package com.trading.DowJonesIndex.service;

import com.trading.DowJonesIndex.model.DowJonesIndexStock;
import com.trading.DowJonesIndex.repository.DowJonesIndexStockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author chaa060
 */

@Service
public class DowJonesIndexStockServiceImpl implements DowJonesIndexStockService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static String ERROR_LOAD_MSG = "An error occurred while processing the CSV file: ";

    @Autowired
    private DowJonesIndexStockRepository dowJonesIndexStockDAO;

    String fileName = "dow_jones_index.csv";

    public void loadDowJonesIndexData() {
        List<DowJonesIndexStock> dowJonesIndexStocks = CsvHelper.loadObjectList(DowJonesIndexStock.class, fileName);
        if (dowJonesIndexStocks.isEmpty()) {
            logger.info(ERROR_LOAD_MSG.concat(fileName));
        } else {
            try {
                dowJonesIndexStockDAO.saveAll(dowJonesIndexStocks);
                logger.info("loading data done successfully");
            } catch (DataAccessException dataAccessException) {
                logger.error(dataAccessException.getMessage());
            }
        }
    }

    @Override
    public List<DowJonesIndexStock> findDowJonesIndexByStock(String stock) {

        try {
            if (stock == null) {
                logger.info("stock is null");
                return Collections.emptyList();
            }
            List<DowJonesIndexStock> dowJonesIndexStocks = dowJonesIndexStockDAO.findByStock(stock);
            if(dowJonesIndexStocks.isEmpty())
                logger.info("no item matches your search");
            return dowJonesIndexStocks;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    public DowJonesIndexStock createDowJonesIndex(DowJonesIndexStock dowJonesIndexStock) {
        try {
            if(dowJonesIndexStock == null){
                logger.info("can't insert null ");
                return null;
            }
            return dowJonesIndexStockDAO.save(dowJonesIndexStock);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }
}
