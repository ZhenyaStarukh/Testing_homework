package enums;

public enum Language {
    ENGLISH("https://www.epam.com"),
    CZECH("https://careers.epam-czech.cz"),
    POLISH("https://careers.epam-poland.pl"),
    UKRAINIAN("https://careers.epam.ua"),
    RUSSIAN("https://www.epam-group.ru"),
    CHINESE("https://careers.epam.cn");

    private final String siteURL;

    Language (String siteURL){
        this.siteURL = siteURL;
    }

    public String getSiteURL() {
        return siteURL;
    }
}
