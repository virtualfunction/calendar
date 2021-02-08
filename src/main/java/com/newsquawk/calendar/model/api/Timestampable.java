package com.newsquawk.calendar.model.api;

import java.time.Instant;

public interface Timestampable {
    Instant getUpdated();
    void setUpdated(Instant value);
}
