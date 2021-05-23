package enums;

public enum Services {
    CONSULT("CONSULT", "https://www.epam.com/services/consult-and-design"),
    DESIGN("DESIGN", "https://www.epam.com/services/consult-and-design"),
    ENGINEER("ENGINEER", "https://www.epam.com/services/engineer"),
    OPERATE("OPERATE", "https://www.epam.com/services/operate"),
    OPTIMIZE("OPTIMIZE", "https://www.epam.com/services/optimize");

    private final String serviceName;
    private final String servicePageURL;

    Services (String serviceName, String servicePageURL) {
        this.serviceName = serviceName;
        this.servicePageURL = servicePageURL;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getServicePageURL() {
        return servicePageURL;
    }
}
