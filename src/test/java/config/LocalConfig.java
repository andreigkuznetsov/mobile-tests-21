package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/local.properties"
})
public interface LocalConfig extends Config {
    @Config.Key("localServerUrl")
    String localServerUrl();

    @Config.Key("platformName")
    String platformName();

    @Config.Key("deviceName")
    String deviceName();

    @Config.Key("version")
    String version();

    @Config.Key("appUrl")
    String appURL();
}
