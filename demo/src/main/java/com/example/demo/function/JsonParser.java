package com.example.demo.function;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @description:
 * @author: jim.han
 * @date: Created in 2019-08-27 20:35
 */
public class JsonParser {

    private static final String originJson="{\n" +
            "\t\"code\": 1000,\n" +
            "\t\"msg\": \"成功\",\n" +
            "    \"success\":true,\n" +
            "\t\"data\": {\n" +
            "        \"hroData\":[\n" +
            "            [\n" +
            "                {\n" +
            "                    \"fieldName\":\"身份证号\",\n" +
            "                    \"fieldValue\":\"12345\",\n" +
            "                    \"type\":1\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fieldName\":\"个人缴纳\",\n" +
            "                    \"fieldValue\":\"30\",\n" +
            "                    \"type\":2,\n" +
            "                    \"result\":{\n" +
            "                        \"type\":1,\n" +
            "                        \"value\":\"40\"\n" +
            "                    }\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fieldName\":\"企业缴纳\",\n" +
            "                    \"fieldValue\":\"100\",\n" +
            "                    \"type\":2,\n" +
            "                    \"result\":{\n" +
            "                        \"type\":1,\n" +
            "                        \"value\":\"120\"\n" +
            "                    }\n" +
            "                }\n" +
            "            ]\n" +
            "       ]\n" +
            "    }\n" +
            "}";

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            Object o = mapper.readValue(originJson, Object.class);
            System.out.println("输出值：" + o.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
