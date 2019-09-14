package com.coin.controller;


import com.coin.entity.Coin;
import com.coin.entity.RESTPagination;
import com.coin.entity.RESTResponse;
import com.coin.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/coin")
public class CoinController {

    @Autowired
    private CoinService coinService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> list(
            @RequestParam(defaultValue = "1", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int limit) {

        Page<Coin> accountPage = coinService.getList(page, limit);

        return new ResponseEntity<>(new RESTResponse.Success().addDatas(accountPage.getContent())
                .setPagination(new RESTPagination(page, limit, accountPage.getTotalPages(), accountPage.getNumberOfElements())).setMessage("Action success")
                .setStatus(HttpStatus.OK.value()).buildDatas(), HttpStatus.OK);


    }

    @RequestMapping(method = RequestMethod.GET, value = "/{name}")
    public ResponseEntity<Object> detail (@PathVariable String name) {
        Coin account = coinService.getDetail(name);
        if (account == null) {
            return new ResponseEntity<>(new RESTResponse.SimpleError().setCode(HttpStatus.NOT_FOUND.value())
                    .setMessage("Not fount coin").build(), HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>(new RESTResponse.Success().addData(account).setMessage("Coin Success!")
                .setStatus(HttpStatus.OK.value()).build(),HttpStatus.OK
        );
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> store (@RequestBody Coin coin){
        return new ResponseEntity<>(new RESTResponse.Success().addData(coinService.register(coin)).setMessage("Save Success")
                .setStatus(HttpStatus.CREATED.value()).build(), HttpStatus.CREATED
        );
    }


}
