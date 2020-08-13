package com.trading.DowJonesIndex.service;

import com.trading.DowJonesIndex.model.DowJonesIndexStock;
import com.trading.DowJonesIndex.repository.DowJonesIndexStockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chaa060
 */

@Service
public class DowJonesIndexStockServiceImpl implements DowJonesIndexStockService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DowJonesIndexStockRepository dowJonesIndexStockDAO;

    String line = "";


    public void loadDowJonesIndexData() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("src/main/resources/dow_jones_index.csv"));
            bufferedReader.readLine(); // consume first line (header) and ignore
            line = bufferedReader.readLine();

            List<DowJonesIndexStock> dowJonesIndexStocks = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                dowJonesIndexStocks.add(DowJonesIndexStockHelper.getDowJonesIndexStock(data));
            }
            dowJonesIndexStockDAO.saveAll(dowJonesIndexStocks);
        } catch (IOException e) {
            logger.info("log -> {}", line);
            e.printStackTrace();
        }
    }

    @Override
    public List<DowJonesIndexStock> findDowJonesIndexByStock(String stock) {
        List<DowJonesIndexStock> dowJonesIndexStocks = dowJonesIndexStockDAO.findByStock(stock);
        return dowJonesIndexStocks;
    }


    public DowJonesIndexStock createDowJonesIndex(DowJonesIndexStock dowJonesIndexStock) {
        return dowJonesIndexStockDAO.save(dowJonesIndexStock);
    }


}
