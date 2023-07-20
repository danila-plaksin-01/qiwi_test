package org.valutes;

import org.json.JSONObject;



public class Main {
    
    public static void main(String[] arg) throws Exception {

        String date = "20/07/2023";
        String code = "USD";
        String url = "http://www.cbr.ru/scripts/XML_daily.asp?date_req=" + date;
        HTTPConnection httpConnection = new HTTPConnection(url);
        JSONObject jsonObject = httpConnection.getJsonObject();
        ValCursJSONParser valCursJSONParser = new ValCursJSONParser(jsonObject, code);
        if (valCursJSONParser.getName() == null) {
            System.out.println("Неверная валюта или дата");
            return;
        }
        System.out.println();
        System.out.println(code + " (" + valCursJSONParser.getName() + "): " + valCursJSONParser.getValue());
    }
}
