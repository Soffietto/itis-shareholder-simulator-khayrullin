package ru.kpfu.itis.shareholdersimulator.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.kpfu.itis.shareholdersimulator.controller.constants.Urls;
import ru.kpfu.itis.shareholdersimulator.exception.TinkoffStockException;
import ru.kpfu.itis.shareholdersimulator.service.StocksService;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StocksServiceImpl implements StocksService {

    private static final String AUTHORIZATION_TOKEN = "Bearer ";

    private final RestTemplate restTemplate;

    private Double previousStockValue;
    private Double currentStockValue = 191d;

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

    @Scheduled(fixedDelay = 15 * 1000)
    private void setStockValue() {
        log.info("Updating stock value");

        previousStockValue = currentStockValue;
        currentStockValue += -1 + (1 + 1) * new Random().nextDouble();
//        currentStockValue = getCurrentStockValueFromTinkoff();

        log.info("Old value: " + previousStockValue);
        log.info("New value: " + currentStockValue);
        log.info("Is raise: " + isRaise());
    }

    private Double getCurrentStockValueFromTinkoff() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Authorization", AUTHORIZATION_TOKEN);
        String response = restTemplate.exchange(
                Urls.TINKOFF_STOCK_VALUE,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                String.class
        ).getBody();

        JSONObject jsonObject = new JSONObject(response);
        JSONArray positionArray = jsonObject.getJSONObject("payload").getJSONArray("positions");
        JSONObject position = positionArray.toList().stream()
                .map(jo -> (JSONObject) jo)
                .filter(jo -> jo.get("name").equals("Сбербанк России"))
                .findFirst()
                .orElseThrow(TinkoffStockException::new);
        Double expectedYield = (Double) position.getJSONObject("expectedYield").get("value");
        Double averagePositionPrice = (Double) position.getJSONObject("averagePositionPrice").get("value");
        Double balance = (Double) position.get("balance");
        return (averagePositionPrice * balance - expectedYield) / balance;
    }
}
