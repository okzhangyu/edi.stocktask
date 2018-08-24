package org.edi.stocktask.util;

import java.util.List;

public class ListUtil {
    private static final String Empty = "";
    public static String getValues(List<String> values){
        if(values == null || values.size() == 0)
            return Empty;
        StringBuilder sb = new StringBuilder();
        for (String item:
             values) {
            if(sb.length() != 0){
                sb.append(',');
            }
            sb.append('\'').append(item).append('\'');
        }
        return sb.toString();
    }
}
