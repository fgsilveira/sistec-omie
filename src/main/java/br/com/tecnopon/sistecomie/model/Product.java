package br.com.tecnopon.sistecomie.model;

import java.util.ArrayList;

public class Product {

    private Long id;
    private Brand brand;
    private String model;
    private String serialNumber;
    private String propertyTag;
    private Acessory acessories = new Acessory();
}
