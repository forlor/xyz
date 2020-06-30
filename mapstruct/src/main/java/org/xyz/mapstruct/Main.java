package org.xyz.mapstruct;

import org.springframework.expression.spel.ast.Identifier;

import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Main
 * @Description TODO
 * @Author xyz
 * @Date 2020/6/9 20:57
 * @Version 1.0
 **/
public class Main {
    static String str = "{\n" +
            "    \"id\": \"zPvH5NbKbJNCugMF4kWN0g\",\n" +
            "    \"network\": {\n" +
            "        \"bytes_sent_sec\": \"0\",\n" +
            "        \"bytes_recv_sec\": \"0\",\n" +
            "        \"connection_attempts_sec\": \"0\",\n" +
            "        \"total_bytes_sent\": \"0\",\n" +
            "        \"total_bytes_recv\": \"0\",\n" +
            "        \"total_connection_attempts\": \"0\",\n" +
            "        \"current_connections\": \"0\"\n" +
            "    },\n" +
            "    \"requests\": {\n" +
            "        \"active\": \"0\",\n" +
            "        \"per_sec\": \"0\",\n" +
            "        \"total\": \"0\"\n" +
            "    },\n" +
            "    \"memory\": {\n" +
            "        \"handles\": \"0\",\n" +
            "        \"private_bytes\": \"0\",\n" +
            "        \"private_working_set\": \"0\",\n" +
            "        \"system_in_use\": \"6284009472\",\n" +
            "        \"installed\": \"8412450816\"\n" +
            "    },\n" +
            "    \"cpu\": {\n" +
            "        \"threads\": \"0\",\n" +
            "        \"processes\": \"0\",\n" +
            "        \"percent_usage\": \"0\",\n" +
            "        \"system_percent_usage\": \"100\"\n" +
            "    },\n" +
            "    \"disk\": {\n" +
            "        \"io_write_operations_sec\": \"0\",\n" +
            "        \"io_read_operations_sec\": \"0\",\n" +
            "        \"page_faults_sec\": \"0\"\n" +
            "    },\n" +
            "    \"cache\": {\n" +
            "        \"file_cache_count\": \"0\",\n" +
            "        \"file_cache_memory_usage\": \"0\",\n" +
            "        \"file_cache_hits\": \"0\",\n" +
            "        \"file_cache_misses\": \"0\",\n" +
            "        \"total_files_cached\": \"0\",\n" +
            "        \"output_cache_count\": \"0\",\n" +
            "        \"output_cache_memory_usage\": \"0\",\n" +
            "        \"output_cache_hits\": \"0\",\n" +
            "        \"output_cache_misses\": \"0\",\n" +
            "        \"uri_cache_count\": \"0\",\n" +
            "        \"uri_cache_hits\": \"0\",\n" +
            "        \"uri_cache_misses\": \"0\",\n" +
            "        \"total_uris_cached\": \"0\"\n" +
            "    },\n" +
            "    \"_links\": {\n" +
            "        \"self\": {\n" +
            "            \"href\": \"/api/webserver/monitoring/zPvH5NbKbJNCugMF4kWN0g\"\n" +
            "        }\n" +
            "    }\n" +
            "}";

    public static void main(String[] args) {

        System.out.println(StandardCharsets.UTF_8.toString());

    }

    private static Pattern linePattern = Pattern.compile("_(\\w)");

    /**
     * 下划线转驼峰
     */
    public static String lineToHump(String str) {
        if (str == null) {
            return null;
        }
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer(str.length());
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return null;
    }

    private static Identifier apply(String name) {
        if (name == null) {
            return null;
        }
        name = name.toLowerCase();
        StringBuilder builder = new StringBuilder(name.length());
        String[] s = name.split("_");
        builder.append(s[0]);
        for (int i = 1; i < s.length; i++) {
            char c = (char) ((s[i].charAt(0)) - 32);
            builder.append(c);
            builder.append(s[i].substring(1));
        }
        System.out.println(builder);
        return null;
    }

    private static boolean isUnderscoreRequired(char before, char current, char after) {
        return Character.isLowerCase(before) && Character.isUpperCase(current) && Character.isLowerCase(after);
    }


}
