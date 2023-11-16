package br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.apolices;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
public class ApoliceSeguro {
    private BigDecimal valorFranquia;
    private Boolean protecaoTerceiro;
    private Boolean protecaoCausasNaturais;
    private Boolean protecaoRoubo;
}
