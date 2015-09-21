package fr.arolla.kata.co2emissions.service;

import com.google.common.collect.ImmutableMap;
import fr.arolla.kata.co2emissions.domain.*;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Dan on 02/09/2015.
 */

@Service
public class FormulaService {

    public EmissionResult annualEmission(ImmutableMap<String, QualifiedValue> parameters) {
        final Product totalConsumptionFormula = new Product("totalFuelConsumption", "fuelStandardEmission");
        final Product averageFormula = new Product("averageEmissionPerHousehold", "householdNumber");
        final Formula formula = new CompositeFormula(totalConsumptionFormula, averageFormula);
        return formula.evaluate(parameters);
    }

    private final static ImmutableMap<String, QualifiedValue> toParams(ImmutableMap<String, Double> parameters) {
        final ImmutableMap.Builder<String, QualifiedValue> builder = new ImmutableMap.Builder<String, QualifiedValue>();
        for (Map.Entry<String, Double> e : parameters.entrySet()) {
            builder.put(e.getKey(), new QualifiedValue(e.getValue(), 0));
        }
        return builder.build();
    }
}
