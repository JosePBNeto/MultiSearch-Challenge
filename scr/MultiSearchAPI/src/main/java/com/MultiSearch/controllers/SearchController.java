package com.MultiSearch.controllers;

import com.MultiSearch.models.Equipment;
import com.MultiSearch.models.PurchaseOrder;
import com.MultiSearch.models.SalesOrder;
import com.MultiSearch.models.Workforce;
import com.MultiSearch.services.DataService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SearchController {
    private final DataService dataService;

    public SearchController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/search")
    public SearchResult search(@RequestParam String query) {
        List<Equipment> equipments = filter(dataService.getEquipments(), query);
        List<PurchaseOrder> purchaseOrders = filter(dataService.getPurchaseOrders(), query);
        List<SalesOrder> salesOrders = filter(dataService.getSalesOrders(), query);
        List<Workforce> workforce = filter(dataService.getWorkforce(), query);

        return new SearchResult(equipments, purchaseOrders, salesOrders, workforce);
    }

    private <T> List<T> filter(List<T> items, String query) {
        if (items == null) return List.of();

        return items.stream()
                .filter(item -> item.toString().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Data
    public static class SearchResult {
        private List<Equipment> equipments;
        private List<PurchaseOrder> purchaseOrders;
        private List<SalesOrder> salesOrders;
        private List<Workforce> workforce;

        public SearchResult(List<Equipment> equipments, List<PurchaseOrder> purchaseOrders,
                            List<SalesOrder> salesOrders, List<Workforce> workforce) {
            this.equipments = equipments;
            this.purchaseOrders = purchaseOrders;
            this.salesOrders = salesOrders;
            this.workforce = workforce;
        }


    }
}
