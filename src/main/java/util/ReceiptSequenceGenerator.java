package util;

import java.util.concurrent.atomic.AtomicInteger;

public class ReceiptSequenceGenerator {

    private final AtomicInteger value = new AtomicInteger(1);

    public Integer getNext() {
        return value.getAndIncrement();
    }
}