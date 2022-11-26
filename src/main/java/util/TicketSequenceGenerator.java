package util;

import java.util.concurrent.atomic.AtomicInteger;

public class TicketSequenceGenerator {

    private final AtomicInteger value = new AtomicInteger(1);

    public Integer getNext() {
        return value.getAndIncrement();
    }
}