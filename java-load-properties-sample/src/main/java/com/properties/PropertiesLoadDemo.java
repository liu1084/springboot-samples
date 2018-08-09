package com.properties;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoadDemo {
    private static final Logger log = LoggerFactory.getLogger(PropertiesLoadDemo.class);
    public static void main(String[] args) {
        try {
            String filePath = "/config.properties";
            //InputStream config = PropertiesLoadDemo.class.getResourceAsStream(filePath);
            InputStream config = ClassLoader.class.getResourceAsStream(filePath);

            if (config == null) {
                throw new MyException(100, "can not load " + filePath);
            }
            Properties properties = new Properties();
            properties.load(config);
            String name = properties.getProperty("name");
            DateTime dateTime = new DateTime(properties.getProperty("time"));
            log.debug(name);
            log.debug(dateTime.toString());
            System.out.println();
        } catch (MyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
