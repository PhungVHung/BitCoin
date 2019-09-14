package com.coin.responsitory;
import com.coin.entity.Coin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoinResponsitory   extends JpaRepository<Coin, String> {
    Page<Coin> findByStatusAndCreatedAtGreaterThanEqual(int status, long createdAt, Pageable pageable);



}


