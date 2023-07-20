package org.valutes;

import org.json.JSONArray;
import org.json.JSONObject;

public class ValCursJSONParser {
    private JSONObject jsonObjectRoot;

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    private String name;
    private String value;

    public ValCursJSONParser(JSONObject jsonObject, String code) {

        jsonObjectRoot = jsonObject;
        JSONObject valCurs = jsonObjectRoot.getJSONObject("ValCurs");
        JSONArray valutes = valCurs.getJSONArray("Valute");
        for (int i = 0; i < valutes.length(); i++) {
            JSONObject valute = valutes.getJSONObject(i);
            String charCode = valute.getString("CharCode");
            if (code.equals(charCode)) {
                this.name = valute.getString("Name");

                this.value = valute.getString("Value");
                break;
            }
        }
    }
}
