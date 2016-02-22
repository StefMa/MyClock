import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MyClockTest {

    private MyClock mMyClock;

    private long mTimeMillis = System.currentTimeMillis();

    @Before
    public void setUp() throws Exception {
        mMyClock = new MyClock() {
            long currentTimeMillis() {
                return mTimeMillis;
            }
        };
    }

    @Test
    public void testGetCurrentName_ShouldReturnTimeInGermanFormat() throws Exception {
        String germanTime = mMyClock.getCurrentTime(TimeFormat.GERMAN);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm 'Uhr'", Locale.GERMANY);
        String formattedTime = simpleDateFormat.format(new Date(mTimeMillis));
        assertThat(germanTime, is(equalTo(formattedTime)));
    }

    @Test
    public void testGetCurrentName_ShouldReturnTimeInAmericanFormat() throws Exception {
        String americanTime = mMyClock.getCurrentTime(TimeFormat.AMERICAN);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a", Locale.US);
        String formattedTime = simpleDateFormat.format(new Date(mTimeMillis));
        assertThat(americanTime, is(equalTo(formattedTime)));
    }

    @Test
    public void testGetCurrentName_ShouldReturnTimeInGermanFormatWithDate() throws Exception {
        String americanTime = mMyClock.getCurrentTime(TimeFormat.GERMAN_WITH_DATE);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm 'Uhr,' EEEE dd.MM.yyyy", Locale.GERMANY);
        String formattedTime = simpleDateFormat.format(new Date(mTimeMillis));
        assertThat(americanTime, is(equalTo(formattedTime)));
    }

    @Test
    public void testGetCurrentName_ShouldReturnTimeInAmericanFormatWithDate() throws Exception {
        String americanTime = mMyClock.getCurrentTime(TimeFormat.AMERICAN_WITH_DATE);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a',' EEEE MM.dd.yyyy", Locale.US);
        String formattedTime = simpleDateFormat.format(new Date(mTimeMillis));
        assertThat(americanTime, is(equalTo(formattedTime)));
    }

    @Test
    public void testCurrentTimeMillis_ShouldReturnCurrentTimeMillis() throws Exception {
        long clockTime = mMyClock.currentTimeMillis();

        assertThat(mTimeMillis, is(equalTo(clockTime)));
    }
}
