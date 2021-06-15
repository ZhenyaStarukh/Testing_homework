package additional;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
    private final Properties properties;

    public PropertiesUtils() {
        InputStream is = getClass().getClassLoader()
                .getResourceAsStream("config.properties");
        this.properties = new Properties();
        try {
            this.properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String propertyName) {
        return this.properties.getProperty(propertyName);
    }
}
