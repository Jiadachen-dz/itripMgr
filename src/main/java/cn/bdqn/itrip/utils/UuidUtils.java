package cn.bdqn.itrip.utils;

import java.util.UUID;

/**
 * UUID
 */
public class UuidUtils {
    public static String randomUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "").toUpperCase();
    }
}
