package com.spamfilter.spam;

/**
 * Created by ketan on 8/21/2014.
 */
public class EmailAddress {
    private final String label;
    private final String id;

    public EmailAddress(String label, String id) {
        this.label=label;
        this.id=id;
    }

    public String getLabel() {
        return label;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmailAddress that = (EmailAddress) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (label != null ? !label.equals(that.label) : that.label != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = label != null ? label.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
