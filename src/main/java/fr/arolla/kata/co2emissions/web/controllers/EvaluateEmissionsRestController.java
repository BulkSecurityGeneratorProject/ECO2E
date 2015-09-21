package fr.arolla.kata.co2emissions.web.controllers;


import com.google.common.collect.ImmutableMap;
import fr.arolla.kata.co2emissions.domain.EmissionResult;
import fr.arolla.kata.co2emissions.domain.QualifiedValue;
import fr.arolla.kata.co2emissions.service.FormulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.Normalizer;

/**
 * Created by Dan on 02/09/2015.
 */

@RestController
public class EvaluateEmissionsRestController {

    @Autowired
    private FormulaService formulaService;

    @RequestMapping("/eval")
    public EmissionResult evaluateCo2e(@RequestParam(value = "totalFuelConsumption", required = false) Double totalFuelConsumption,
                                       @RequestParam(value = "fuelStandardEmission", required = false) Double fuelStandardEmission,
                                       @RequestParam(value = "averageEmissionPerHousehold", required = false) Double averageEmissionPerHousehold,
                                       @RequestParam(value = "householdNumber", required = false) Double householdNumber) {

        System.out.println("totalFuelConsumption " + totalFuelConsumption);
        System.out.println("fuelStandardEmission " + fuelStandardEmission);
        System.out.println("averageEmissionPerHousehold " + averageEmissionPerHousehold);
        System.out.println("householdNumber " + householdNumber);


        final ImmutableMap<String, QualifiedValue> params = new ImmutableMap.Builder<String, QualifiedValue>()
                .put("averageEmissionPerHousehold", new QualifiedValue(averageEmissionPerHousehold, 0.5))
                .put("householdNumber", new QualifiedValue(householdNumber, 100))
                .put("totalFuelConsumption", new QualifiedValue(totalFuelConsumption, 15))
                .put("fuelStandardEmission", new QualifiedValue(fuelStandardEmission, 35)).build();

        EmissionResult emissionResult = formulaService.annualEmission(params);

        return emissionResult;
    }
}
