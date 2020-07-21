package data.provider;

import org.aeonbits.owner.ConfigFactory;

public final class SiteLocaleDataProvider {
    private static final SiteLocalData VALUE = ConfigFactory.create(SiteLocalData.class);

    private SiteLocaleDataProvider() {
    }

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
