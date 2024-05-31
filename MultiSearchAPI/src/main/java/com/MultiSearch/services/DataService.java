package com.MultiSearch.services;

import com.MultiSearch.models.Equipment;
import com.MultiSearch.models.PurchaseOrder;
import com.MultiSearch.models.SalesOrder;
import com.MultiSearch.models.Workforce;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class DataService {

    private List<Equipment> equipments;
    private List<PurchaseOrder> purchaseOrders;
    private List<SalesOrder> salesOrders;
    private List<Workforce> workforce;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    private void loadData() {
        try {
            equipments = loadJsonData("data/equipments.json", new TypeReference<>() {});
            purchaseOrders = loadJsonData("data/purchase_orders.json", new TypeReference<>() {});
            salesOrders = loadJsonData("data/sales_orders.json", new TypeReference<>() {});
            workforce = loadJsonData("data/workforce.json", new TypeReference<>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <T> List<T> loadJsonData(String path, TypeReference<List<T>> typeReference) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
        if (inputStream == null) {
            throw new IOException("File not found: " + path);
        }
        try (InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            return objectMapper.readValue(reader, typeReference);
        }}

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public List<SalesOrder> getSalesOrders() {
        return salesOrders;
    }

    public List<Workforce> getWorkforce() {
        return workforce;
    }
}