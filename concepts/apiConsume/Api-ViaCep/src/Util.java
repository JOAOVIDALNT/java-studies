import java.io.BufferedReader;
import java.io.IOException;

public class Util {
    public static String jsonToStringConvert(BufferedReader br) throws IOException {
        String response, jsonToString = "";
        while ((response = br.readLine()) != null) {
            jsonToString += response;
        }
        return jsonToString;
    }
}
