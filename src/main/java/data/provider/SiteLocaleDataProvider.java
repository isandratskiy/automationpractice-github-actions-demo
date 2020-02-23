package data.provider;

import org.aeonbits.owner.ConfigFactory;

public class SiteLocaleDataProvider {
    private static final SiteLocalData VALUE = ConfigFactory.create(SiteLocalData.class);

    public static String getOrderHistoryTitle() {
        return VALUE.getOrderHistoryTitle();
    }

    public static String getCreditSlipsTitle() {
        return VALUE.getCreditSlipsTitle();
    }

    public static String getMyAddressTitle() {
        return VALUE.getMyAddressTitle();
    }

    public static String getPersonalInfoTitle() {
        return VALUE.getPersonalInfoTitle();
    }
}
