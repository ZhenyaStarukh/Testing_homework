package enums;

import additional.PropertiesUtils;

public enum Language {
    ENGLISH(new PropertiesUtils().getProperty("main.url")),
    CZECH(new PropertiesUtils().getProperty("main.czech.url")),
    POLISH(new PropertiesUtils().getProperty("main.polish.url")),
    UKRAINIAN(new PropertiesUtils().getProperty("main.ukrainian.url")),
    RUSSIAN(new PropertiesUtils().getProperty("main.russian.url")),
    CHINESE(new PropertiesUtils().getProperty("main.chinese.url"));

    private final String siteURL;

    Language (String siteURL){
        this.siteURL = siteURL;
    }

    public String getSiteURL() {
        return siteURL;
    }
}
