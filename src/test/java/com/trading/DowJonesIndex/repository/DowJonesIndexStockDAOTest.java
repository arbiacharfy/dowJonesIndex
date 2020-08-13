package com.trading.DowJonesIndex.repository;

import com.trading.DowJonesIndex.model.DowJonesIndexStock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author chaa060
 */

@DataJpaTest
class DowJonesIndexStockDAOTest {
    @Autowired
    private DowJonesIndexStockRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    DowJonesIndexStock dowJonesIndexStock1;
    DowJonesIndexStock dowJonesIndexStock2;

    @BeforeEach
    void setUp() {
        dowJonesIndexStock1 = getDowJonesIndexStock("5", "RY", "10000000");
        dowJonesIndexStock2 = getDowJonesIndexStock("4", "RY", "20000000");
        DowJonesIndexStock dowJonesIndexStock3 = getDowJonesIndexStock("4", "AAPL", "30000000");

        entityManager.persist(dowJonesIndexStock1);
        entityManager.persist(dowJonesIndexStock2);
        entityManager.persist(dowJonesIndexStock3);

    }

    @Test
    public void testFindByStockHappyPath() {

        List<DowJonesIndexStock> dowJonesIndexStocks = repository.findByStock("RY");

        assertThat(dowJonesIndexStocks).hasSize(2).contains(dowJonesIndexStock1, dowJonesIndexStock2);
        assertThat(dowJonesIndexStocks.get(0)).hasFieldOrPropertyWithValue("stock", "RY");
        assertThat(dowJonesIndexStocks.get(1)).hasFieldOrPropertyWithValue("stock", "RY");


    }

    @Test
    public void testSaveHappyPath() {

        DowJonesIndexStock dowJonesIndexStock4 = getDowJonesIndexStock("14", "AAPL", "20000000");
        repository.save(dowJonesIndexStock4);
        assertThat(repository.findAll()).hasSize(4).contains(dowJonesIndexStock4);
    }

    @Test
    public void testSaveAllHappyPath() {
        DowJonesIndexStock dowJonesIndexStock4 = getDowJonesIndexStock("4", "AAPL", "20000000");
        DowJonesIndexStock dowJonesIndexStock5 = getDowJonesIndexStock("4", "AMZN", "50000000");

        List<DowJonesIndexStock> dowJonesIndexStocks = new ArrayList<>();
        dowJonesIndexStocks.add(dowJonesIndexStock4);
        dowJonesIndexStocks.add(dowJonesIndexStock5);

        dowJonesIndexStocks.addAll(dowJonesIndexStocks);

        repository.saveAll(dowJonesIndexStocks);
        assertThat(repository.findAll()).hasSize(5).contains(dowJonesIndexStock4, dowJonesIndexStock5);
    }

    private DowJonesIndexStock getDowJonesIndexStock(String quarter, String stock, String volume) {
        DowJonesIndexStock dowJonesIndexStock = new DowJonesIndexStock();
        dowJonesIndexStock.setStock(stock);
        dowJonesIndexStock.setVolume(volume);
        dowJonesIndexStock.setQuarter(quarter);
        return dowJonesIndexStock;
    }
}