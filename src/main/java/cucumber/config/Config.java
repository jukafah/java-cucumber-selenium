package cucumber.config;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Config {

  public final String workspace;
  public final String url;
  public final Map<String, Object> deviceMap;
  public final String username;

  public Config() {
    this.workspace = System.getProperty("user.dir");
    this.username = System.getProperty("username", "smomcilovic");
    this.url = System.getProperty("seleniumGrid", "http://0.0.0.0:4723/wd/hub");

    String deviceName = System.getProperty("deviceName", "iPhone 6s");
    this.deviceMap = getDevice(deviceName);

    // if native app testing
//    String app =
//        System.getProperty("app", Paths.get(path/to/app);
//    this.deviceMap.put("app", app);

      // for code signing
//    String xcodeOrgId = System.getProperty("xcodeOrgId", "SET_ME");
//    this.deviceMap.put("xcodeOrgId", xcodeOrgId);
//
//    String xcodeSigningIdentity = System.getProperty("xcodeSigningId", "iPhone Developer");
//    this.deviceMap.put("xcodeSigningId", xcodeSigningIdentity);

      // for selenium grid execution
//    Boolean isRemote = Boolean.parseBoolean(System.getProperty("isRemote", "false"));
//    if (isRemote) {
//      int wdaLocalPort = Integer.parseInt(System.getProperty("wdaLocalPort", "8100"));
//      this.deviceMap.put("wdaLocalPort", wdaLocalPort);
//    }
  }

  private HashMap<String, Object> getDevice(String device) {

    Type hashType = new TypeToken<HashMap<String, Object>>() {}.getType();
    Gson gson = new Gson();

    InputStream deviceFile = getClass().getResourceAsStream("/devices/devices.json");
    BufferedReader reader = new BufferedReader(new InputStreamReader(deviceFile));

    JsonParser parser = new JsonParser();

    JsonElement jsonElement = parser.parse(reader).getAsJsonObject().get(device);

    return gson.fromJson(jsonElement, hashType);
  }
}
