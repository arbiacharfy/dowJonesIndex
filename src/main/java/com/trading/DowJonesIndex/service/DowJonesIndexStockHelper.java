package com.trading.DowJonesIndex.service;

import com.trading.DowJonesIndex.model.DowJonesIndexStock;

/**
 * @author chaa060
 */
public class DowJonesIndexStockHelper {
    public static DowJonesIndexStock getDowJonesIndexStock (String[] data) {

        DowJonesIndexStock dowJonesIndexStock = null;
        if(data!= null && data.length>15){
            dowJonesIndexStock = new DowJonesIndexStock();
            dowJonesIndexStock.setQuarter(data[0]);
            dowJonesIndexStock.setStock(data[1]);
            dowJonesIndexStock.setDate(data[2]);
            dowJonesIndexStock.setOpen(data[3]);
            dowJonesIndexStock.setHigh(data[4]);
            dowJonesIndexStock.setLow(data[5]);
            dowJonesIndexStock.setClose(data[6]);
            dowJonesIndexStock.setVolume(data[7]);
            dowJonesIndexStock.setPercent_change_price(data[8]);
            dowJonesIndexStock.setPercent_chagne_volume_over_last_wek(data[9]);
            dowJonesIndexStock.setPrevious_weeks_volume(data[10]);
            dowJonesIndexStock.setNext_weeks_open(data[11]);
            dowJonesIndexStock.setNext_weeks_close(data[12]);
            dowJonesIndexStock.setPercent_change_next_weeks_price(data[13]);
            dowJonesIndexStock.setDays_to_next_dividend(data[14]);
            dowJonesIndexStock.setPercent_return_next_dividend(data[15]);
        }

        return dowJonesIndexStock;
    }

}
