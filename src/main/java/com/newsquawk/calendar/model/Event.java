package com.newsquawk.calendar.model;

import com.newsquawk.calendar.model.api.Timestampable;
import com.newsquawk.calendar.model.listener.TimestampableListener;

import javax.persistence.*;
import java.time.Instant;

/*
@NamedQueries({
        @NamedQuery(
                name = "Event.findByID",
                query = "SELECT e FROM calendar_events e WHERE e.id = :id"
        )
})
*/

@Entity
@EntityListeners({TimestampableListener.class})
@Table(name = "calendar_events")
public class Event { // implements Timestampable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint")
    private Long id;

    @Column(columnDefinition = "text", nullable = true)
    private String title;

    @Column(columnDefinition = "varchar(32)", nullable = false)
    private String previous;

    @Column(columnDefinition = "varchar(32)", nullable = false)
    private String actual;

    @Column(columnDefinition = "varchar(32)", nullable = false)
    private String low;

    @Column(columnDefinition = "varchar(32)", nullable = false)
    private String high;

    @Column(columnDefinition = "varchar(32)", name = "all_day", nullable = false)
    private String allDay;

    @Column(columnDefinition = "boolean default false", nullable = false)
    private String disabled;

    @Column(name = "occurs_at", columnDefinition = "timestamp with time zone", nullable = false) // Default now
    private Instant occursAt;

    @Column(name = "updated_at", columnDefinition = "timestamp with time zone default now()", nullable = false)
    private Instant updatedAt;

    @Column(name = "remotely_updated_at", columnDefinition = "timestamp with time zone default now()", nullable = false)
    private Instant remotelyUpdatedAt;

    @Column(columnDefinition = "varchar(64)", name = "remote_identity", nullable = false)
    private String remoteIdentity;

    // TODO:  Category ID
    // private Category category;


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getAllDay() {
        return allDay;
    }

    public void setAllDay(String allDay) {
        this.allDay = allDay;
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }

    public Instant getOccursAt() {
        return occursAt;
    }

    public void setOccursAt(Instant occursAt) {
        this.occursAt = occursAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Instant getRemotelyUpdatedAt() {
        return remotelyUpdatedAt;
    }

    public void setRemotelyUpdatedAt(Instant remotelyUpdatedAt) {
        this.remotelyUpdatedAt = remotelyUpdatedAt;
    }

    public String getRemoteIdentity() {
        return remoteIdentity;
    }

    public void setRemoteIdentity(String remoteIdentity) {
        this.remoteIdentity = remoteIdentity;
    }

    /*
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
     */
}