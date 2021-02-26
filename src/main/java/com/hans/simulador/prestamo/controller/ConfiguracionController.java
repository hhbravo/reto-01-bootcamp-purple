package com.hans.simulador.prestamo.controller;

import com.hans.simulador.prestamo.business.ConfigurationService;
import com.hans.simulador.prestamo.entity.ConfiguracionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/configuration")
public class ConfiguracionController {

    @Autowired
     private ConfigurationService configurationService;

    @GetMapping()
    public ConfiguracionResponse config() {
        return configurationService.config();
    }
}
