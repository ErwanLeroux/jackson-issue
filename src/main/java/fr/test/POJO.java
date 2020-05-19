package fr.test;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;

public class POJO {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "Europe/Paris")
    private OffsetDateTime offsetDateTimeWithTimeZone;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private OffsetDateTime offsetDateTimeWithoutTimeZone;

    public OffsetDateTime getOffsetDateTimeWithTimeZone() {
        return offsetDateTimeWithTimeZone;
    }

    public void setOffsetDateTimeWithTimeZone(OffsetDateTime offsetDateTimeWithTimeZone) {
        this.offsetDateTimeWithTimeZone = offsetDateTimeWithTimeZone;
    }

    public OffsetDateTime getOffsetDateTimeWithoutTimeZone() {
        return offsetDateTimeWithoutTimeZone;
    }

    public void setOffsetDateTimeWithoutTimeZone(OffsetDateTime offsetDateTimeWithoutTimeZone) {
        this.offsetDateTimeWithoutTimeZone = offsetDateTimeWithoutTimeZone;
    }
}
