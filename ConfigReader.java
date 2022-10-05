package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;

    static {// Her Method'dan Önce Çalışır
        String dosyaYolu="configuration.properties";
        try {
            FileInputStream fis=new FileInputStream(dosyaYolu);
            properties=new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String Key){
              /*
        Test methodundan yolladigimiz String key degerini alip properties classindan
        getProperty() methodunu kullanarak bu key'e ait value'yu bize getirir
             */
        return properties.getProperty(Key);
    }










}
