package info.rexs.model.jaxb;

import org.junit.Test;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class LocaleAdapterTest {

    public static final LocaleAdapter ADAPTER = new LocaleAdapter();

    @Test
    public void marshal_givenValidLocale_returnsLanguageCode() {
        assertThat(ADAPTER.marshal(Locale.ENGLISH)).isEqualTo("en");
        assertThat(ADAPTER.marshal(Locale.GERMAN)).isEqualTo("de");
    }

    @Test
    public void marshal_givenNullLocale_returnsNull() {
        assertThat(ADAPTER.marshal(null)).isNull();
    }

    @Test
    public void unmarshal_givenValidLanguageCode_returnsLocale() {
        assertThat(ADAPTER.unmarshal("en")).isEqualTo(Locale.ENGLISH);
        assertThat(ADAPTER.unmarshal("de")).isEqualTo(Locale.GERMAN);
    }

    @Test
    public void unmarshal_givenValidLanguageAndCountryCode_returnsLocale() {
        assertThat(ADAPTER.unmarshal("en_US")).isEqualTo(Locale.ENGLISH);
        assertThat(ADAPTER.unmarshal("de_DE")).isEqualTo(Locale.GERMAN);
    }

    @Test
    public void unmarshal_givenEmptyString_returnsNull() {
        assertThat(ADAPTER.unmarshal("")).isNull();
    }

    @Test
    public void unmarshal_givenInvalidLanguageCode_returnsNull() {
        assertThat(ADAPTER.unmarshal("invalid")).isNull();
        assertThat(ADAPTER.unmarshal("invalid_locale")).isNull();
    }
}