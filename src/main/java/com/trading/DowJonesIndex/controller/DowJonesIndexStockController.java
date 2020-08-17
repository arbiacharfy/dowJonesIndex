package com.trading.DowJonesIndex.controller;

import com.trading.DowJonesIndex.model.DowJonesIndexStock;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author chaa060
 */

@Api(tags = "Dow Jones Index Api")
@RequestMapping(path = "/api/index")
public interface DowJonesIndexStockController {

    @RequestMapping(path = "/load",
            method = RequestMethod.GET)
    @ApiOperation("Load data from csv file to h2 database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success")
    })
    void loadDowJonesIndexData();




    @ApiOperation("get list of index by stock")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success")
    })
    @RequestMapping(value = "/find",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    List<DowJonesIndexStock> findDowJonesIndexByStock(@Param("stock") String stock);




    @ApiOperation("add a new index")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success", response = DowJonesIndexStock.class)
    })
    @PostMapping(value = "/add",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    DowJonesIndexStock createDowJonesIndex(@RequestBody DowJonesIndexStock dowJonesIndexStock) ;
}
