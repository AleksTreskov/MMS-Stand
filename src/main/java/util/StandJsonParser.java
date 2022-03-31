package util;

import com.google.gson.Gson;
import dto.ItemDTO;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;


import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton

public class StandJsonParser {
    private final Gson gson = new Gson();
    public List<ItemDTO> parse(String json) {
        Type productListType = new TypeToken<ArrayList<ItemDTO>>() {}.getType();
        List<ItemDTO> items;

        items = gson.fromJson(json, productListType);
        return items;
    }
}
