package org.refactoring.example1.after;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Item {
    private long sku;
    private String title;
    private double price;
}
