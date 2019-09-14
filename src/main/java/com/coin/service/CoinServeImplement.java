package com.coin.service;
import com.coin.entity.Coin;
import com.coin.responsitory.CoinResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Calendar;

@Service
public class CoinServeImplement implements CoinService {

    @Autowired
    private CoinResponsitory coinResponsitory;


    @Override
    public Page<Coin> getList(int page, int limit){
        return coinResponsitory.findByStatusAndCreatedAtGreaterThanEqual(1, 1568084234001L,
                PageRequest.of(page -1, limit, Sort.by("createdAt").descending()));


    }


    @Override
    public Coin getDetail(String name) {
        return coinResponsitory.findById(name).orElse(null);
    }



    @Override
    public Coin register(Coin coin) {
        coin.setId(Calendar.getInstance().getTimeInMillis());
        coin.setUpdateAt(Calendar.getInstance().getTimeInMillis());
        coin.setCreateAt(Calendar.getInstance().getTimeInMillis());
        coin.setStatus(1);
        return coinResponsitory.save(coin);
    }



}
