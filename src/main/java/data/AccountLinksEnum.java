package data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static data.provider.SiteLocaleDataProvider.*;

@Getter
@AllArgsConstructor
public enum AccountLinksEnum {
    ORDER_HISTORY(getOrderHistoryTitle()),
    MY_CREDITS_SLIPS(getCreditSlipsTitle()),
    MY_ADDRESSES(getMyAddressTitle()),
    MY_PERSONAL_INFO(getPersonalInfoTitle());

    private String title;
}
