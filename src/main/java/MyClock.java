import com.google.common.annotations.VisibleForTesting;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyClock {

    public String getCurrentTime(TimeFormat format) {
        switch (format) {
            case GERMAN:
                return getStringFormattedTimeWithPatternAndLocale("HH:mm 'Uhr'", Locale.GERMANY);
            case AMERICAN:
                return getStringFormattedTimeWithPatternAndLocale("hh:mm a", Locale.US);
            case GERMAN_WITH_DATE:
                return getStringFormattedTimeWithPatternAndLocale("HH:mm 'Uhr,' EEEE dd.MM.yyyy", Locale.GERMANY);
            case AMERICAN_WITH_DATE:
                return getStringFormattedTimeWithPatternAndLocale("hh:mm a',' EEEE MM.dd.yyyy", Locale.US);
            default:
                return "";
        }
    }

    @VisibleForTesting
    long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    private String getStringFormattedTimeWithPatternAndLocale(String pattern, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, locale);
        Date currentDate = new Date(currentTimeMillis());
        return simpleDateFormat.format(currentDate);
    }

}
