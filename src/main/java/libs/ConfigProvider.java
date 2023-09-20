package libs;

import org.aeonbits.owner.ConfigFactory;

public class ConfigProvider {//клас, який створює об'єкти класів ConfigProperties
    //створюємо об'єкт класу ConfigProperties з парами ключів і значень
    public static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
}
