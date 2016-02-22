public class Main {

    public static void main(String[] args) {
        MyClock clock = new MyClock();

        String currentTimeInGermanFormat = clock.getCurrentTime(TimeFormat.GERMAN);
        System.out.println(currentTimeInGermanFormat);

        String currentTimeInAmericanFormat = clock.getCurrentTime(TimeFormat.AMERICAN);
        System.out.println(currentTimeInAmericanFormat);

        String currentTimeInGermanFormatAndDate = clock.getCurrentTime(TimeFormat.GERMAN_WITH_DATE);
        System.out.println(currentTimeInGermanFormatAndDate);

        String currentTimeInAmericanFormatAndDate = clock.getCurrentTime(TimeFormat.AMERICAN_WITH_DATE);
        System.out.println(currentTimeInAmericanFormatAndDate);
    }

}
