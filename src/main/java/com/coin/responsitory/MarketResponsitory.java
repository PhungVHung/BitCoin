package com.coin.responsitory;
import com.coin.entity.Market;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MarketResponsitory  extends JpaRepository<Market, String> {
    Page<Market> findByStatusAndCreatedAtGreaterThanEqual(int status, long createdAt, Pageable pageable);



}
