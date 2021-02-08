package com.newsquawk.calendar.model.listener;

import com.newsquawk.calendar.model.api.Timestampable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.Instant;

public class TimestampableListener {

    @PrePersist
    void onCreate(Object entity) {
        if(entity instanceof Timestampable) {
            Instant timestamp = Instant.now();
            ((Timestampable)entity).setUpdated(timestamp);
        }
    }

    @PreUpdate
    void onUpdate(Object entity) {
        if(entity instanceof Timestampable) {
            Instant timestamp = Instant.now();
            ((Timestampable)entity).setUpdated(timestamp);
        }
    }
}