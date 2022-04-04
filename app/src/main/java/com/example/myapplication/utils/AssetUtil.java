package com.example.myapplication.utils;

import android.content.res.AssetManager;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

public class AssetUtil {
    private static AssetManager mAssetManager;


    public static void setAssetManager(AssetManager assetManager) {
        mAssetManager = assetManager;
    }

    public static Optional<InputStream> getAssetInputStream(String path) {
        if (mAssetManager == null) {
            return Optional.empty();
        }
        String assetPath = "xml" + File.separator + "face.xml";
        InputStream inputStream = null;
        try {
            inputStream = mAssetManager.open(assetPath);
        } catch (IOException e) {
            Log.d("AssetUtil", e.getMessage());
        }
        return Optional.ofNullable(inputStream);
    }

}
