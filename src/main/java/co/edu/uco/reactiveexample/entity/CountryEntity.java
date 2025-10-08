package co.edu.uco.reactiveexample.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table(name = "Country")
public final class CountryEntity {

    @Id
    private int id;

    @Column(value = "name")
    private String name;

    @Column(value = "dialingCountryCode")
    private String dialingCountryCode;

    @Column(value = "isoCountryCode")
    private String isoCountryCode;

    @Column(value = "enabled")
    private boolean enabled;

    public CountryEntity(int id, String name, String dialingCountryCode, String isoCountryCode, boolean enabled) {
        this.id = id;
        this.name = name;
        this.dialingCountryCode = dialingCountryCode;
        this.isoCountryCode = isoCountryCode;
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = Objects.requireNonNullElse(name, "").trim();
    }

    public String getDialingCountryCode() {
        return dialingCountryCode;
    }

    public void setDialingCountryCode(final String dialingCountryCode) {
        this.dialingCountryCode = Objects.requireNonNullElse(dialingCountryCode, "").trim();
    }

    public String getIsoCountryCode() {
        return isoCountryCode;
    }

    public void setIsoCountryCode(final String isoCountryCode) {
        this.isoCountryCode = Objects.requireNonNullElse(isoCountryCode, "").trim();
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
