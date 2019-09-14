package com.coin.service;
import com.coin.entity.Market;
import org.springframework.data.domain.Page;

public interface MarketService {

    Market getDetail(String name);

    Market register(Market market);

    Page<Market> getList(int page, int limit);
}
