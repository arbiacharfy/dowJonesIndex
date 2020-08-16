package com.trading.DowJonesIndex.service;

import com.trading.DowJonesIndex.model.DowJonesIndexStock;
import com.trading.DowJonesIndex.repository.DowJonesIndexStockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chaa060
 */

@Service
public class DowJonesIndexStockServiceImpl implements DowJonesIndexStockService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static String ERROR_MSG = "An error occurred while processing the CSV file: ";

    @Autowired
    private DowJonesIndexStockRepository dowJonesIndexStockDAO;

    String fileName = "dow_jones_index.csv";

    public void loadDowJonesIndexData() {
        List<DowJonesIndexStock> dowJonesIndexStocks = CsvHelper.loadObjectList(DowJonesIndexStock.class, fileName);
        if (dowJonesIndexStocks.isEmpty()) {
            logger.error(ERROR_MSG.concat(fileName));
        } else {
            try{
                dowJonesIndexStockDAO.saveAll(dowJonesIndexStocks);
            }catch (DataAccessException dataAccessException){
                logger.error(dataAccessException.getMessage());
            }
        }
    }

    @Override
    public List<DowJonesIndexStock> findDowJonesIndexByStock(String stock) {
        return dowJonesIndexStockDAO.findByStock(stock);
    }


    public DowJonesIndexStock createDowJonesIndex(DowJonesIndexStock dowJonesIndexStock) {
        return dowJonesIndexStockDAO.save(dowJonesIndexStock);
    }

}
