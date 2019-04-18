package kg.enesaitech.planets.utli;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by e.zhumanasyrov on 23.03.2018.
 */

public class JacksonJsonConverter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private JacksonJsonConverter() {
    }

    public static <T> T readValue(String value, Class<T> t) {
        T t1 = null;
        try {
            t1 = objectMapper.readValue(value, t);
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
        return t1;
    }
}
