package ru.kpfu.itis.shareholdersimulator.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.shareholdersimulator.service.StocksService;

@Slf4j
@Service
@RequiredArgsConstructor
public class StocksServiceImpl implements StocksService {

//    private final RestTemplate restTemplate;

    private Double previousStockValue;
    private Double currentStockValue = 183.85;

    @Override
    public double getCurrentStockValue() {
        return currentStockValue;
    }

    @Override
    public boolean isRaise() {
        return currentStockValue > previousStockValue;
    }

    @Override
    public Double getDifference() {
        return currentStockValue - previousStockValue;
    }

    @Scheduled(fixedDelay = 60 * 1000)
    private void setStockValue() {
        log.info("Updating stock value");
        previousStockValue = currentStockValue;
        currentStockValue += 0.3;
        //TODO: Получаем инфу о сбере
//        restTemplate.exchange()
        log.info("Old value: " + previousStockValue);
        log.info("New value: " + currentStockValue);
        log.info("Is raise: " + true);
    }
}
