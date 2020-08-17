package com.trading.DowJonesIndex.service;

import com.trading.DowJonesIndex.model.DowJonesIndexStock;
import com.trading.DowJonesIndex.repository.DowJonesIndexStockRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

/**
 * @author chaa060
 */


@SpringBootTest
class DowJonesIndexStockServiceImplTest {

    @Mock
    private DowJonesIndexStockRepository dowJonesIndexStockDAO;

    @InjectMocks
    DowJonesIndexStockServiceImpl dowJonesIndexStockService;

    @Test
    void getDowJonesIndexByStock() {
        String stock = "RY";
        DowJonesIndexStock dowJonesIndexStock = getDowJonesIndexStock();
        Mockito.when(dowJonesIndexStockDAO.findByStock((stock)))
                .thenReturn(Arrays.asList(dowJonesIndexStock));

        List<DowJonesIndexStock> dowJonesIndexStockList = dowJonesIndexStockService.findDowJonesIndexByStock(stock);

        assertThat(dowJonesIndexStockList.get(0).getStock())
                .isEqualTo(stock);
    }

    @Test
    void getDowJonesIndexByNullStock_Should_return_empty_collections() {
        List<DowJonesIndexStock> dowJonesIndexStockList = dowJonesIndexStockService.findDowJonesIndexByStock(null);
        assertTrue(dowJonesIndexStockList.isEmpty());
        Mockito.verify(dowJonesIndexStockDAO, times(0)).findByStock(null);
    }

    @Test
    void add() {
        DowJonesIndexStock dowJonesIndexStock = getDowJonesIndexStock();
        Mockito.when(dowJonesIndexStockDAO.save((dowJonesIndexStock)))
                .thenReturn(dowJonesIndexStock);

        DowJonesIndexStock dowJonesIndexSaved = dowJonesIndexStockService.createDowJonesIndex(dowJonesIndexStock);

        assertNotNull(dowJonesIndexSaved);

    }

    @Test
    void add_with_null_object_should_return_null() {
        DowJonesIndexStock dowJonesIndexSaved = dowJonesIndexStockService.createDowJonesIndex(null);
        assertNull(dowJonesIndexSaved);
        Mockito.verify(dowJonesIndexStockDAO, times(0)).save(dowJonesIndexSaved);
    }

    private DowJonesIndexStock getDowJonesIndexStock() {
        DowJonesIndexStock dowJonesIndexStock = new DowJonesIndexStock();
        dowJonesIndexStock.setQuarter("1");
        dowJonesIndexStock.setStock("RY");
        return dowJonesIndexStock;
    }


}