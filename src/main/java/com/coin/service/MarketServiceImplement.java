package com.coin.service;

import com.coin.entity.Market;
import com.coin.responsitory.MarketResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;


@Service
public class MarketServiceImplement implements MarketService {

    @Autowired
    private MarketResponsitory marketResponsitory;




    @Override
    public Market getDetail(String name) {
        return marketResponsitory.findById(name).orElse(null);
    }



    @Override
    public Market register(Market market) {
        // thuc hien ma~ hoa password khi can
        market.setId(Calendar.getInstance().getTimeInMillis());
        market.setCreateAt(Calendar.getInstance().getTimeInMillis());
        market.setUpdate(Calendar.getInstance().getTimeInMillis());
        market.setStatus(1);
        return marketResponsitory.save(market);
    }

    @Override
    public Page<Market> getList(int page, int limit) {
        return marketResponsitory.findByStatusAndCreatedAtGreaterThanEqual(1, 1568084234001L,
                PageRequest.of(page - 1, limit, Sort.by("createdAt").descending()));


    }


}
