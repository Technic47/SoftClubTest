package com.softClub.Test.controllers;

import com.softClub.Test.client.gen.GetCursOnDateResponse;
import com.softClub.Test.client.models.generated.ValuteData;
import com.softClub.Test.models.FinOperation;
import com.softClub.Test.models.FinOperationDTO;
import com.softClub.Test.models.FinOperationDTOResponse;
import com.softClub.Test.services.DailyCurrencyClient;
import com.softClub.Test.services.abstracts.CommonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/operations")
public class FinOperationController {
    private final CommonService<FinOperation> service;
    private final DailyCurrencyClient client;

    public FinOperationController(CommonService<FinOperation> service, DailyCurrencyClient client) {
        this.service = service;
        this.client = client;
    }

    @PostMapping()
    public ResponseEntity<FinOperationDTOResponse> save(@RequestBody FinOperationDTO dto) {
        FinOperation saved = service.save(new FinOperation(dto));
        return ResponseEntity.ok(new FinOperationDTOResponse(saved));
    }

//    @PostMapping("/batch")
//    public ResponseEntity<FinOperationDTOResponse[]> saveAll(@RequestBody FinOperationDTO[] dtoBatch) {
//        List<FinOperation> list = new ArrayList<>();
//        for (FinOperationDTO dto : dtoBatch) {
//            list.add(new FinOperation(dto));
//        }
//
//        List<FinOperation> saved = service.saveAll(list);
//
//        FinOperationDTOResponse[] toReturn = new FinOperationDTOResponse[saved.size()];
//
//        for (int i = 0; i < toReturn.length; i++) {
//            toReturn[i] = new FinOperationDTOResponse(saved.get(i));
//        }
//
//        return ResponseEntity.ok(toReturn);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<FinOperationDTOResponse> get(@PathVariable Long id) {
        FinOperation found = service.getById(id);
        return ResponseEntity.ok(new FinOperationDTOResponse(found));
    }

    @GetMapping("/update")
    public ResponseEntity<?> updateCurrencies() {
        GetCursOnDateResponse response = client.getCursOnDate(LocalDateTime.now());
        GetCursOnDateResponse.GetCursOnDateResult result = response.getGetCursOnDateResult();
        Object any = result.getAny();
        ValuteData values = (ValuteData) any;
        System.out.println(any);
        return ResponseEntity.ok("Request is sent.");
    }
}
