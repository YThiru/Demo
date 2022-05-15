package com.project.demo.controller;

import com.project.demo.Util.Constants;
import com.project.demo.exception.DemoException;
import com.project.demo.model.StoreLocationDetails;
import com.project.demo.response.StoreLocationResponse;
import com.project.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path="/api/v1")
public class StoreLocationController {

    private DemoService demoService;
    private static Logger logger = LoggerFactory.getLogger(StoreLocationController.class);

    @Autowired
    StoreLocationController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/getLocationAmount")
    public ResponseEntity<StoreLocationResponse> getLocationAmount(@RequestParam @Validated String locationId) {
        try {
            return successResponse(demoService.getStoresAmountByLocationId(locationId));
        } catch (Exception exception) {
            throw new DemoException(exception.getMessage());
        }
    }

    @PostMapping(value = "/loadLocationAmount", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<StoreLocationResponse> loadLocationAmount(@RequestBody @Valid List<StoreLocationDetails> storeDetails) {
        try {
            demoService.loadLocationAmount(storeDetails);
        } catch (Exception exception) {
            throw new DemoException(exception.getMessage());
        }
        return successResponse(BigDecimal.ZERO);
    }

    private ResponseEntity<StoreLocationResponse> successResponse (BigDecimal amount) {
        logger.info("Operation has been completed successfully!");
        StoreLocationResponse response = StoreLocationResponse.of(Constants.SUCCESS_OUTCOME, amount, null);
        return ResponseEntity.ok(response);
    }

}
