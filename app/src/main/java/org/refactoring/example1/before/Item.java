package org.refactoring.example1.before;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Item {
    private long sku;
    private String title;
    private double price;
}
