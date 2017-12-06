package linkdb;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.xml.internal.ws.util.StringUtils;

public class iputils {
	public static Boolean  isIp(String ip) throws Exception {
		Pattern pattern = Pattern.compile("\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b");
		Matcher matcher = pattern.matcher(ip); //以验证127.400.600.2为例
		return matcher.matches();
	}
	public static List<String> getIp() throws Exception  
    {  
		List<String> ipAddresses = new ArrayList<String>();
        Enumeration<NetworkInterface> interfs = NetworkInterface.getNetworkInterfaces();  
        while (interfs.hasMoreElements())  
        {  
            NetworkInterface interf = interfs.nextElement();  
            Enumeration<InetAddress> addres = interf.getInetAddresses();  
            while (addres.hasMoreElements())  
            {  
                InetAddress in = addres.nextElement();  
              /*  if(in.getHostAddress().equalsIgnoreCase("127.0.0.1")) {
                	continue;
                };*/
                if (in instanceof Inet4Address)  
                {  
                    if(isIp(in.getHostAddress())) {
                    	
                    	ipAddresses.add("'"+in.getHostAddress()+"'");
                    }; 
                  
                }  
                else if (in instanceof Inet6Address)  
                {  
                    if(isIp(in.getHostAddress())) {
                    	ipAddresses.add("'"+in.getHostAddress()+"'");
                    };  
                }  
            }  
        }
        return ipAddresses;
    } 
	public static void main(String[] args) throws Exception   {
		iputils.getIp();
	}
}
