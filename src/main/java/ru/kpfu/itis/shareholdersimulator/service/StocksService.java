package ru.kpfu.itis.shareholdersimulator.service;

public interface StocksService {

    double getCurrentStockValue();

    boolean isRaise();

    Double getDifference();

}
