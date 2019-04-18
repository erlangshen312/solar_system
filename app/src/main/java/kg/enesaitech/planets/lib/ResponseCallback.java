package kg.enesaitech.planets.lib;

import org.json.JSONObject;

/**
 * Created by e.zhumanasyrov on 16.03.2018.
 */

public interface ResponseCallback {
    void onResponse(JSONObject object);
    void onError(String message);
}
