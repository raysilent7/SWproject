package com.swproject.swproject.swapi;

import com.google.gson.JsonObject;

public class GetRequestRepository {

    private API api = new API();

    public JsonObject getAll(String path, String searchquery) {
        JsonObject jsonObject = null;
        try {
            jsonObject = api.getBuilder(path, searchquery);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
