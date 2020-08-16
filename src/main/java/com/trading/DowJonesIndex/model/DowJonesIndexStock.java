package com.trading.DowJonesIndex.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author chaa060
 */

@Entity
public class DowJonesIndexStock implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String quarter;
    private String stock;
    private String date;
    private String open ;
    private String high;
    private String low;
    private String close;
    private String volume;
    private String percent_change_price;
    private String percent_change_volume_over_last_wk;
    private String previous_weeks_volume;
    private String next_weeks_open;
    private String next_weeks_close;
    private String percent_change_next_weeks_price;
    private String days_to_next_dividend;
    private String percent_return_next_dividend;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPercent_change_price() {
        return percent_change_price;
    }

    public void setPercent_change_price(String percent_change_price) {
        this.percent_change_price = percent_change_price;
    }

    public String getPercent_change_volume_over_last_wk() {
        return percent_change_volume_over_last_wk;
    }

    public void setPercent_change_volume_over_last_wk(String percent_change_volume_over_last_wk) {
        this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
    }

    public String getPrevious_weeks_volume() {
        return previous_weeks_volume;
    }

    public void setPrevious_weeks_volume(String previous_weeks_volume) {
        this.previous_weeks_volume = previous_weeks_volume;
    }

    public String getNext_weeks_open() {
        return next_weeks_open;
    }

    public void setNext_weeks_open(String next_weeks_open) {
        this.next_weeks_open = next_weeks_open;
    }

    public String getNext_weeks_close() {
        return next_weeks_close;
    }

    public void setNext_weeks_close(String next_weeks_close) {
        this.next_weeks_close = next_weeks_close;
    }

    public String getPercent_change_next_weeks_price() {
        return percent_change_next_weeks_price;
    }

    public void setPercent_change_next_weeks_price(String percent_change_next_weeks_price) {
        this.percent_change_next_weeks_price = percent_change_next_weeks_price;
    }

    public String getDays_to_next_dividend() {
        return days_to_next_dividend;
    }

    public void setDays_to_next_dividend(String days_to_next_dividend) {
        this.days_to_next_dividend = days_to_next_dividend;
    }

    public String getPercent_return_next_dividend() {
        return percent_return_next_dividend;
    }

    public void setPercent_return_next_dividend(String percent_return_next_dividend) {
        this.percent_return_next_dividend = percent_return_next_dividend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DowJonesIndexStock that = (DowJonesIndexStock) o;
        return id == that.id &&
                Objects.equals(quarter, that.quarter) &&
                Objects.equals(stock, that.stock) &&
                Objects.equals(date, that.date) &&
                Objects.equals(open, that.open) &&
                Objects.equals(high, that.high) &&
                Objects.equals(low, that.low) &&
                Objects.equals(close, that.close) &&
                Objects.equals(volume, that.volume) &&
                Objects.equals(percent_change_price, that.percent_change_price) &&
                Objects.equals(percent_change_volume_over_last_wk, that.percent_change_volume_over_last_wk) &&
                Objects.equals(previous_weeks_volume, that.previous_weeks_volume) &&
                Objects.equals(next_weeks_open, that.next_weeks_open) &&
                Objects.equals(next_weeks_close, that.next_weeks_close) &&
                Objects.equals(percent_change_next_weeks_price, that.percent_change_next_weeks_price) &&
                Objects.equals(days_to_next_dividend, that.days_to_next_dividend) &&
                Objects.equals(percent_return_next_dividend, that.percent_return_next_dividend);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quarter, stock, date, open, high, low, close, volume, percent_change_price, percent_change_volume_over_last_wk, previous_weeks_volume, next_weeks_open, next_weeks_close, percent_change_next_weeks_price, days_to_next_dividend, percent_return_next_dividend);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DowJonesIndexStock.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("quarter='" + quarter + "'")
                .add("stock='" + stock + "'")
                .add("date='" + date + "'")
                .add("open='" + open + "'")
                .add("high='" + high + "'")
                .add("low='" + low + "'")
                .add("close='" + close + "'")
                .add("volume='" + volume + "'")
                .add("percent_change_price='" + percent_change_price + "'")
                .add("percent_change_volume_over_last_wk='" + percent_change_volume_over_last_wk + "'")
                .add("previous_weeks_volume='" + previous_weeks_volume + "'")
                .add("next_weeks_open='" + next_weeks_open + "'")
                .add("next_weeks_close='" + next_weeks_close + "'")
                .add("percent_change_next_weeks_price='" + percent_change_next_weeks_price + "'")
                .add("days_to_next_dividend='" + days_to_next_dividend + "'")
                .add("percent_return_next_dividend='" + percent_return_next_dividend + "'")
                .toString();
    }
}
