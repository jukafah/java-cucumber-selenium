package cucumber.config;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.util.HashMap;

public class Config {

    public final String workspace;
    public final String url;
    public final HashMap<String, Object> deviceMap;
    public final String username;

    public Config()
    {
        this.workspace                = System.getProperty("user.dir");
        String deviceName             = System.getProperty("deviceName", "iPhone 6s");
        int wdaLocalPort              = Integer.parseInt(System.getProperty("wdaLocalPort", "8100"));
        Boolean isRemote              = Boolean.parseBoolean(System.getProperty("isRemote", "false"));
        String xcodeOrgId             = System.getProperty("xcodeOrgId", "NEEDS_KEY");
        String xcodeSigningIdentity   = System.getProperty("xcodeSigningId", "iPhone Developer");

//        String app                    = System.getProperty("app", Paths.get("");


        this.username                 = System.getProperty("username", "NEEDS_USER");
        this.url                      = System.getProperty("seleniumGrid", "http://0.0.0.0:4723/wd/hub");

        this.deviceMap                = getDevice(deviceName);
//        this.deviceMap.put("app", app);
        this.deviceMap.put("xcodeOrgId", xcodeOrgId);
        this.deviceMap.put("xcodeSigningId", xcodeSigningIdentity);

        if (isRemote) {
            this.deviceMap.put("wdaLocalPort", wdaLocalPort);
        }
    }

    private HashMap<String, Object> getDevice(String device) {

        Type hashType = new TypeToken<HashMap<String, Object>>(){}.getType();
        Gson gson = new Gson();

        InputStream deviceFile = getClass().getResourceAsStream("/devices/devices.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(deviceFile));

        JsonParser parser = new JsonParser();

        JsonElement jsonElement = parser
                .parse(reader)
                .getAsJsonObject()
                .get(device);

        return gson.fromJson(jsonElement, hashType);
    }
}