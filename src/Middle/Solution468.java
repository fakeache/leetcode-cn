package Middle;

import java.util.regex.Pattern;

public class Solution468 {
    public String validIPAddress(String IP) {
        String ipv4Ele = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        String ipv6Ele = "([0-9a-fA-F]{1,4})";
        Pattern patternIpv4 = Pattern.compile("^(" + ipv4Ele + "\\.){3}" + ipv4Ele + "$");
        Pattern patternIpv6 = Pattern.compile("^(" + ipv6Ele + "\\:){7}" + ipv6Ele + "$");
        if (patternIpv4.matcher(IP).matches()) {
            return "IPv4";
        } else if (patternIpv6.matcher(IP).matches()) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }
}
