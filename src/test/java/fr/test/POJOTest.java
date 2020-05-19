package fr.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.TimeZone;

import static org.assertj.core.api.Assertions.assertThat;

class POJOTest {

    private static ObjectMapper mapperWithTimezone;

    @BeforeAll
    public static void setUp() {
        mapperWithTimezone = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .setTimeZone(TimeZone.getTimeZone("Europe/Paris"))
                .enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Test
    public void testOffset2() throws JsonProcessingException {
        final OffsetDateTime firstJune2020AtNoonOffset2 = OffsetDateTime.of(
                LocalDate.of(2020, Month.JUNE, 1),
                LocalTime.of(14, 0, 0, 0),
                ZoneOffset.ofHours(2));

        final POJO pojoOffset2 = new POJO();
        pojoOffset2.setOffsetDateTimeWithoutTimeZone(firstJune2020AtNoonOffset2);
        pojoOffset2.setOffsetDateTimeWithTimeZone(firstJune2020AtNoonOffset2);
        final String strPojoOffSet2 = mapperWithTimezone.writeValueAsString(pojoOffset2);
        assertThat(strPojoOffSet2).contains("\"offsetDateTimeWithTimeZone\" : \"2020-06-01T14:00:00.000+02:00\"");
        assertThat(strPojoOffSet2).contains("\"offsetDateTimeWithoutTimeZone\" : \"2020-06-01T14:00:00.000+02:00\"");
    }

    @Test
    public void testOffsetUTC() throws JsonProcessingException {
        final OffsetDateTime firstJune2020AtNoonOffsetUTC = OffsetDateTime.of(
                LocalDate.of(2020, Month.JUNE, 1),
                LocalTime.NOON,
                ZoneOffset.UTC);

        final POJO pojoOffsetUTC = new POJO();
        pojoOffsetUTC.setOffsetDateTimeWithoutTimeZone(firstJune2020AtNoonOffsetUTC);
        pojoOffsetUTC.setOffsetDateTimeWithTimeZone(firstJune2020AtNoonOffsetUTC);
        final String strPojoOffSetUTC = mapperWithTimezone.writeValueAsString(pojoOffsetUTC);
        assertThat(strPojoOffSetUTC).contains("\"offsetDateTimeWithTimeZone\" : \"2020-06-01T14:00:00.000+02:00\"");
        assertThat(strPojoOffSetUTC).contains("\"offsetDateTimeWithoutTimeZone\" : \"2020-06-01T14:00:00.000+02:00\"");
    }
}