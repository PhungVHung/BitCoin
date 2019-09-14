package com.coin.controller;
import com.coin.entity.Market;
import com.coin.entity.RESTPagination;
import com.coin.entity.RESTResponse;
import com.coin.service.MarketService;
import com.coin.service.MarketServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/market")
public class MarketController {
    @Autowired
    private MarketService marketService;
    private MarketServiceImplement marketServiceImplement;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> list(
            @RequestParam(defaultValue = "1", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int limit) {

        Page<Market> accountPage = marketService.getList(page, limit);

        return new ResponseEntity<>(new RESTResponse.Success().addDatas(accountPage.getContent())
                .setPagination(new RESTPagination(page, limit, accountPage.getTotalPages(), accountPage.getNumberOfElements())).setMessage("Action success")
                .setStatus(HttpStatus.OK.value()).buildDatas(), HttpStatus.OK);


    }

    @RequestMapping(method = RequestMethod.GET, value = "/{name}")
    public ResponseEntity<Object> detail (@PathVariable String name) {
        Market market = marketService.getDetail(name);
        if (market == null) {
            return new ResponseEntity<>(new RESTResponse.SimpleError().setCode(HttpStatus.NOT_FOUND.value())
                    .setMessage("Not fount account").build(), HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>(new RESTResponse.Success().addData(market).setMessage("Account Success!")
                .setStatus(HttpStatus.OK.value()).build(),HttpStatus.OK
        );
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> store (@RequestBody Market market){
        return new ResponseEntity<>(new RESTResponse.Success().addData(marketService.register(market)).setMessage("Save Success")
                .setStatus(HttpStatus.CREATED.value()).build(), HttpStatus.CREATED
        );
    }


}
