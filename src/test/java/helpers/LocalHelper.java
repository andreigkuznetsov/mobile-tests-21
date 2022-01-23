package helpers;

import java.net.MalformedURLException;
import java.net.URL;

import static config.ProjectData.localConfig;

public class LocalHelper {
    public static URL getLocalServerUrl() {
        try {
            return new URL(localConfig.localServerUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
