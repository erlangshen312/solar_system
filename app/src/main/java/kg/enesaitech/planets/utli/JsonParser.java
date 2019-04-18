package kg.enesaitech.planets.utli;

/**
 * Created by e.zhumanasyrov on 23.03.2018.
 */

public interface JsonParser {
    <T> void readValue(String value, T t);
}
