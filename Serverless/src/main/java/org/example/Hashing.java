package org.example;

import org.example.encryption.Bycrypt;
import org.example.encryption.Md5;
import org.example.encryption.Sha256;
import org.example.model.InputStringJson;
import org.example.model.JsonInput;
import org.example.model.JsonOutput;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hashing {

    JSONParser parser = new JSONParser();
    JSONObject json = new JSONObject();

    public JSONObject encryptWithSHA(JsonInput jsonInput) throws ParseException {
//        String input = jsonInput.getInput();

//        InputStringJson inputStringValues = extractInputStringValues(input);
        JsonOutput jsonOutput = new JsonOutput();

        // check if call is for sha256 or not
        if(!Objects.equals(jsonInput.getAction(), "sha256")){
            // if not sha256, then returns empty json output
            json.put("course_uri", jsonInput.getCourse_uri());
            json.put("action", jsonInput.getAction());
            json.put("value", jsonInput.getValue());
            return json;
        }

        // setting values in json output
        jsonOutput.setAction(jsonInput.getAction());
        jsonOutput.setArn("arn:aws:lambda:us-east-1:730335465905:function:SHA-256-Hashing");
        jsonOutput.setValue(jsonInput.getValue());

        // perform sha256 hashing
        Sha256 sha256 = new Sha256();
        String result = sha256.sha256Algorithm(jsonInput.getValue());
        jsonOutput.setResult(result);

        sendJsonToEndpoint((JSONObject) parser.parse(jsonOutput.toString()));
        return (JSONObject) parser.parse(jsonOutput.toString());
    }

    public JSONObject encryptWithMD5(JsonInput jsonInput) throws ParseException {
//        String input = jsonInput.getInput();

//        InputStringJson inputStringValues = extractInputStringValues(input);
        JsonOutput jsonOutput = new JsonOutput();

        // check if call is for sha256 or not
        if(!Objects.equals(jsonInput.getAction(), "md5")){
            // if not sha256, then returns empty json output
            json.put("course_uri", jsonInput.getCourse_uri());
            json.put("action", jsonInput.getAction());
            json.put("value", jsonInput.getValue());
            return json;
        }

        // setting values in json output
        jsonOutput.setAction(jsonInput.getAction());
        jsonOutput.setArn("arn:aws:lambda:us-east-1:730335465905:function:MD5-Hashing");
        jsonOutput.setValue(jsonInput.getValue());

        // perform md5 hashing
        Md5 md5 = new Md5();
        String result = md5.md5Algorithm(jsonOutput.getValue());
        jsonOutput.setResult(result);

        sendJsonToEndpoint((JSONObject) parser.parse(jsonOutput.toString()));
        return (JSONObject) parser.parse(jsonOutput.toString());
    }

    public JsonOutput encryptWithBcrypt(JsonInput jsonInput) throws ParseException {
//        String input = jsonInput.getInput();

//        InputStringJson inputStringValues = extractInputStringValues(input);
        JsonOutput jsonOutput = new JsonOutput();

        // setting values in json output
        jsonOutput.setAction(jsonInput.getAction());
        jsonOutput.setArn("arn:aws:lambda:us-east-1:730335465905:function:Bycrypt-Hashing");
        jsonOutput.setValue(jsonInput.getValue());

        // perform bcrypt hashing
        Bycrypt bCrypt = new Bycrypt();
        String result = bCrypt.bcryptAlgorithm(jsonInput.getValue());
        jsonOutput.setResult(result);

        sendJsonToEndpoint((JSONObject) parser.parse(jsonOutput.toString()));
        return jsonOutput;
    }

    private void sendJsonToEndpoint(JSONObject jsonObject) {
        try {
            System.out.println("calling api method");
            // Specify the endpoint URL
            URL url = new URL("http://129.173.67.234:8080/serverless/end");

            // Open a connection to the endpoint
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Write the JSONObject to the connection's output stream
            try (OutputStream outputStream = connection.getOutputStream()) {
                byte[] input = jsonObject.toString().getBytes("utf-8");
                outputStream.write(input, 0, input.length);
            }

            // Check the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Close the connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}