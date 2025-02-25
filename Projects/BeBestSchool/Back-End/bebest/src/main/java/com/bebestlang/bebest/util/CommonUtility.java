package com.bebestlang.bebest.util;

import java.util.Map;

public class CommonUtility {

    public static Map<String, String> buildTranslationMap(String english, String polish) {
        return Map.of("EN", english, "PL", polish);
    }
}
