import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        Map<String, Integer> map = new TreeMap<>();

        Files.readAllLines(Paths.get("simple_text.txt")).forEach(n -> {
            String pom = getOnlyStrings(n);
            String[] tab = pom.split(" ");
            for (String s : tab) {
                if (map.containsKey(s))
                    map.replace(s, map.get(s) + 1);
                else
                    map.put(s, 1);
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static String getOnlyStrings(String s) {
        Pattern pattern = Pattern.compile("[^a-z A-Z 0-9]");
        Matcher matcher = pattern.matcher(s);
        String result = matcher.replaceAll(" ");
        return result.toUpperCase();
    }
}