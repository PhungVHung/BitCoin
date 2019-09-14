package com.coin.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coin {
    @Id
    private long id;
    private String name;
    private String description;
    private String baseAsset;
    private String quoteAsset;
    private long lastPrice;
    private long volumn24h;
    private long marketId;
    private long createdAt;
    private long updatedAt;
    private int status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBaseAsset() {
        return baseAsset;
    }

    public void setBaseAsset(String baseAsset) {
        this.baseAsset = baseAsset;
    }

    public String getQuoteAsset() {
        return quoteAsset;
    }

    public void setQuoteAsset(String quoteAsset) {
        this.quoteAsset = quoteAsset;
    }

    public long getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(long lastPrice) {
        this.lastPrice = lastPrice;
    }

    public long getVolumn24h() {
        return volumn24h;
    }

    public void setVolumn24h(long volumn24h) {
        this.volumn24h = volumn24h;
    }

    public long getMarketId() {
        return marketId;
    }

    public void setMarketId(long marketId) {
        this.marketId = marketId;
    }

    public long getCreateAt() {
        return createdAt;
    }

    public void setCreateAt(long createAt) {
        this.createdAt = createAt;
    }

    public long getUpdateAt() {
        return updatedAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updatedAt = updateAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

