package com.hans.simulador.prestamo.controller;

import com.hans.simulador.prestamo.business.PrestamoService;
import com.hans.simulador.prestamo.entity.PrestamoRequest;
import com.hans.simulador.prestamo.entity.PrestamoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/prestamo")
public class PrestamoController {

    Logger logger = LoggerFactory.getLogger(PrestamoController.class);


    @Autowired
    private PrestamoService prestamoService;

    @PostMapping
    public ResponseEntity<PrestamoResponse> prestamo(@Valid @RequestBody PrestamoRequest prestamoRequest) throws Exception {
        PrestamoResponse
             prestamoResponse = prestamoService.monthlyFee(prestamoRequest);


        return new ResponseEntity<>(prestamoResponse, HttpStatus.OK);
    }

}
