package com;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by zhaolizhen on 18-5-31.
 */
public class Test1 {
    public static void main(String args[]) throws DocumentException, IOException {
//        testXml();
        System.out.println(Model.A.name());

    }

    public enum Model{
        A,B
    }



    public static void testXml1() throws DocumentException {
        String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<!DOCTYPE test [<!ELEMENT test ANY >" +
                "<!ENTITY xxe SYSTEM \"/home/mi/test\" >]>" +
                "<root>" +
                "<name>&xxe;</name>" +
                "</root>";

        String xmlStr1="<xml><appid><![CDATA[wx2cf9fbb8560f8a5e]]></appid><bank_type><![CDATA[CFT]]></bank_type><cash_fee><![CDATA[3000]]></cash_fee><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[N]]></is_subscribe><mch_id><![CDATA[1502621391]]></mch_id><nonce_str><![CDATA[T0IOcc27IrkQPqslBMyNwFQivQfLdKau]]></nonce_str><openid><![CDATA[o1i9vwR6JYyhnjleUFLs1dNd74uw]]></openid><out_trade_no><![CDATA[20153078122092585756]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[5364A137C72DEC40D59FAEFF7B6AC650]]></sign><time_end><![CDATA[20180705170036]]></time_end><total_fee>3000</total_fee><trade_type><![CDATA[APP]]></trade_type><transaction_id><![CDATA[4200000146201807055666227263]]></transaction_id></xml>";

        Document document = parseText(xmlStr);
        Element test = document.getRootElement();
        Iterator<Element> iterator = document.getRootElement().elementIterator();
        Map<String,String> paramMap=new HashMap<String,String>();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            if (Strings.isNullOrEmpty(element.getText())) {
                continue;
            }
            paramMap.put(element.getName(), element.getText());
        }

        System.out.println(paramMap);
    }

    public static void testXml(){
        String xmlStr = "<xml>" +
                "<name>123</name>" +
                "<appid>dddd</appid>" +
                "</xml>";

        String xmlStr1="<xml><appid><![CDATA[wx2cf9fbb8560f8a5e]]></appid><bank_type><![CDATA[CFT]]></bank_type><cash_fee><![CDATA[3000]]></cash_fee><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[N]]></is_subscribe><mch_id><![CDATA[1502621391]]></mch_id><nonce_str><![CDATA[T0IOcc27IrkQPqslBMyNwFQivQfLdKau]]></nonce_str><openid><![CDATA[o1i9vwR6JYyhnjleUFLs1dNd74uw]]></openid><out_trade_no><![CDATA[20153078122092585756]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[5364A137C72DEC40D59FAEFF7B6AC650]]></sign><time_end><![CDATA[20180705170036]]></time_end><total_fee>3000</total_fee><trade_type><![CDATA[APP]]></trade_type><transaction_id><![CDATA[4200000146201807055666227263]]></transaction_id></xml>";

        Data data=xml2Object(Data.class, xmlStr);

        System.out.println(JSONObject.toJSON(data));
    }
    public static <T> T xml2Object(Class T, String xmlString) {
        try {
            JAXBContext e = JAXBContext.newInstance(new Class[]{T});
            Unmarshaller unmarshaller = e.createUnmarshaller();
            ByteArrayInputStream is = new ByteArrayInputStream(xmlString.getBytes("UTF-8"));
            return (T) unmarshaller.unmarshal(is);
        } catch (Exception var5) {
            return null;
        }
    }

    public static Document parseText(String text) throws DocumentException {
        Document result = null;

        SAXReader reader = new SAXReader();
        String FEATURE = "http://apache.org/xml/features/disallow-doctype-decl";
        try {
            reader.setFeature(FEATURE,true);
        } catch (SAXException e) {
            e.printStackTrace();
        }
        String encoding = getEncoding(text);

        InputSource source = new InputSource(new StringReader(text));
        source.setEncoding(encoding);

        result = reader.read(source);

        // if the XML parser doesn't provide a way to retrieve the encoding,
        // specify it manually
        if (result.getXMLEncoding() == null) {
            result.setXMLEncoding(encoding);
        }

        return result;
    }

    private static String getEncoding(String text) {
        String result = null;

        String xml = text.trim();

        if (xml.startsWith("<?xml")) {
            int end = xml.indexOf("?>");
            String sub = xml.substring(0, end);
            StringTokenizer tokens = new StringTokenizer(sub, " =\"\'");

            while (tokens.hasMoreTokens()) {
                String token = tokens.nextToken();

                if ("encoding".equals(token)) {
                    if (tokens.hasMoreTokens()) {
                        result = tokens.nextToken();
                    }

                    break;
                }
            }
        }

        return result;
    }
}
