package com;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
public class Data{
    private String name;

        public String getAppid() {
            return appid;
        }

    @XmlElement(name = "appid")
    public void setAppid(String appid) {
            this.appid = appid;
        }

    private String appid;

        public String getName() {
            return name;
        }

    @XmlElement(name = "name")
    public void setName(String name) {
            this.name = name;
        }
    }