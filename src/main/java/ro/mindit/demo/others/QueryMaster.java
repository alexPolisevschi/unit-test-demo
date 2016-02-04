package ro.mindit.demo.others;

import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mindit User on 02/04/16.
 */
public class QueryMaster {

    public String prepareQuery(String sql, Properties prop) {
        ArrayList atHolder = new ArrayList();
        atHolder = find("@.+?@", sql);

        String str = "";
        if (atHolder.size() == 0) {
            return sql;
        }
        for (int i = 0; i < atHolder.size(); i++) {
            str = (String) atHolder.get(i);
            if (str.indexOf("(") > 0) {
                str = str.replaceAll("\\(", "\\\\(");
                str = str.replaceAll("\\)", "\\\\)");

                str = str.replaceAll("\\[", "\\\\[");
                str = str.replaceAll("\\]", "\\\\]");
            }

            Pattern pattern = null;
            Matcher matcher = null;
            pattern = Pattern.compile("" + str, Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(sql);

            if (matcher.find()) {
                Pattern subPat = Pattern.compile(
                        "(#\\w*#)",
                        Pattern.CASE_INSENSITIVE);
                Matcher subMat = subPat.matcher(str);
                boolean hasValue = false;

                if (subMat.find()) {
                    String key = subMat.group();
                    key = key.substring(1, key.length() - 1);

                    String val = "";
                    hasValue = false;
                    String tempStr = "";

                    if (prop.containsKey(key)) {
                        val = prop.getProperty(key);

                        if ((val != null) &&
                                !val.equalsIgnoreCase("") &&
                                !val.equalsIgnoreCase("All") &&
                                !val.equalsIgnoreCase("'All'") &&
                                !val.equalsIgnoreCase("null")) {
                            val = val.trim();
                            if (str.indexOf(" like ") > 0 || str.indexOf(" LIKE ") > 0 || str.indexOf(" Like ") > 0) {
                                if (val.contains("*")) {
                                    val = val.replace('*', '%');
                                    val = "'" + val + "'";
                                } else if (key.equals("promotionnumber") || key.equals("proposalnumber")) {
                                    // Fix for issue #18137 (Added else if condition - if promotion number provided in manage promotion search then only call this)
                                    val = "'" + val + "'";
                                    // logger.info("val 2>>>>>>>>>>"+val);
                                } else {
                                    val = "'%" + val + "%'";
                                    //logger.info("val 3>>>>>>>>>>"+val);
                                }
                            } else {
                                val = "'" + val + "'";
                            }

                            val = val.replaceAll(",", "','");

                            try {
                                tempStr = subMat.replaceAll(val);
                                tempStr = tempStr.substring(1, tempStr.length() - 1);
                                sql = matcher.replaceFirst(tempStr);
                                hasValue = true;
                            } catch (Exception e) {
                                hasValue = false;

                            }
                        }
                    }

                    sql = matcher.replaceFirst(tempStr);
                }
            }
        }
        return sql;
    }



    private ArrayList find(String patternStr, CharSequence input) {
        ArrayList matches = new ArrayList();

        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            matches.add(matcher.group());
        }

        return matches;
    }
}
