package libs;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:./src/main/resources/config.properties")
//путь к файлу с конфигурацией, где хранятся настройки
public interface ConfigProperties extends Config {
    long TIME_FOR_DEFAULT_WAIT();

    String DATA_FILE_PATH();
}
