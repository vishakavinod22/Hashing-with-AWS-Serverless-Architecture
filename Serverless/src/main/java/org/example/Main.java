package org.example;

import org.example.model.JsonInput;
import org.example.model.JsonOutput;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        Hashing hash = new Hashing();
        JSONObject result = new JSONObject();
        JsonInput jsonInput = new JsonInput(
                "/serverless/end", "sha256", "hello world"
//                "ScriptExecution",
//                "arn:aws:states:us-east-1:730335465905:stateMachine:csci-5409-a3-state-machine"
        );

        result = hash.encryptWithMD5(jsonInput);
        System.out.println(result);

//        result = hash.encryptWithSHA(jsonInput);
//        System.out.println(result);
//        if(result.containsKey("course_uri")){
//            result = hash.encryptWithMD5(jsonInput);
//            System.out.println(result);
//            if(result.containsKey("course_uri")){
//                JsonOutput res = hash.encryptWithBcrypt(jsonInput);
//                System.out.println(res);
//            }
//        }
    }
}