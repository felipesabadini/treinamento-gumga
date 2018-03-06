package br.sabadini.entity;

import java.util.UUID;

public class GeradorID {

    private GeradorID(){}

    public static String gerar() {
        return UUID
            .randomUUID()
            .toString()
            .toUpperCase()
            .replace("-", "");
    }
}
