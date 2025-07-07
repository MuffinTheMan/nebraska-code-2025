package org.refactoring.example1.before;

import java.util.SequencedCollection;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Order {
    private long orderNumber;
    private SequencedCollection<LineItem> lineItems;
}
