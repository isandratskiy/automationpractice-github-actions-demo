package data.provider;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:locale/${site.locale}/locale_data.properties"})
public interface SiteLocalData extends Config {
    @Key("order.history.title")
    String getOrderHistoryTitle();

    @Key("credit.slips.title")
    String getCreditSlipsTitle();

    @Key("my.address.title")
    String getMyAddressTitle();

    @Key("personal.info.title")
    String getPersonalInfoTitle();
}
