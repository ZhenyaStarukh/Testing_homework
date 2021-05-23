package enums;

public enum FormField {
    FIRST_NAME("FirstName"),
    LAST_NAME("LastName"),
    EMAIL("Email@email.com"),
    PHONE("+123456789012");

    private final String value;

    FormField(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
