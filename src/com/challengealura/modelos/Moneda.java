package com.challengealura.modelos;

import java.util.Map;

public class Moneda {
    String codigoMoneda;
    double montoInicial;
    Map<String, Double> ratiosDeConversion;

    public Moneda(MonedaExchangeRate monedaER) {
        this.codigoMoneda = monedaER.base_code();
        this.ratiosDeConversion = monedaER.conversion_rates();
    }

    public void setMontoInicial(double montoInicial) {
        this.montoInicial = montoInicial;
    }

    public String getCodigoMoneda() {
        return codigoMoneda;
    }
}
