package com.newsquawk.calendar.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "calendar_categories")
public class Category {
    public enum Importance {
        MEDIUM, HIGH, LOW
    }

    public enum ListingState {
        UNKNOWN, VISIBLE, INVISIBLE
    }

    public enum Period {
        ADHOC, DAILY, WEEKLY, MONTHLY, YEARLY
    }

    public enum Classification {
        FIGURES, SPEAKERS,AUCTIONS, EARNINGS, EXPIRIES, NOTES
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint")
    private Long id;

    @Column(columnDefinition = "text", nullable = true)
    private String name;

    // Used if we want to override the name the data source uses
    @Column(columnDefinition = "text", name = "display_name", nullable = true)
    private String displayName;

    @Column(columnDefinition = "text", nullable = true)
    private String description;

    // In ISO3166-2, e.g. GB, US, DE
    @Column(columnDefinition = "varchar(2)", nullable = false)
    private String location;

    @Column(columnDefinition = "varchar(8)", nullable = false)
    private String unit = "";

    @Column(columnDefinition = "varchar(16)", nullable = false)
    @Enumerated(EnumType.STRING)
    private Period period = Period.ADHOC;

    @Column(columnDefinition = "varchar(16)", nullable = false)
    @Enumerated(EnumType.STRING)
    private ListingState state = ListingState.UNKNOWN;

    @Column(columnDefinition = "varchar(16)", nullable = false)
    @Enumerated(EnumType.STRING)
    private Classification classification = Classification.FIGURES;

    @Column(columnDefinition = "varchar(16)", nullable = false)
    @Enumerated(EnumType.STRING)
    private Importance importance = Importance.MEDIUM;

    // ISO4217 Alpha, e.g. GBP, EUR, USD
    @Column(columnDefinition = "varchar(3)", nullable = false)
    private String currency = "";

    // Typically RTRS / Refinitive
    @Column(columnDefinition = "varchar(32)", name = "data_origin", nullable = false)
    private String dataOrigin = "";

    // This will be like Fed, ONS, etc etc if used
    @Column(columnDefinition = "varchar(32)", name = "origin", nullable = false)
    private String origin = "";

    @Column(name = "updated_at", columnDefinition = "timestamp with time zone default now()", nullable = false)
    private Instant updatedAt;

    // Used to show negative values as positive sentiment (e.g. unemployment figures)
    @Column(columnDefinition = "boolean", nullable = true)
    private String inverted;

    @Column(columnDefinition = "boolean default true", name = "show_period", nullable = false)
    private String showPeriod;

    // identity: varchar("identity", 16) // UUID from the remote source
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public ListingState getState() {
        return state;
    }

    public void setState(ListingState state) {
        this.state = state;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public Importance getImportance() {
        return importance;
    }

    public void setImportance(Importance importance) {
        this.importance = importance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getInverted() {
        return inverted;
    }

    public void setInverted(String inverted) {
        this.inverted = inverted;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
