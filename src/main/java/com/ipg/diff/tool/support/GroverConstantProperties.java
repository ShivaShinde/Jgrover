package com.ipg.diff.tool.support;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class GroverConstantProperties {

    private static GroverConstantProperties instance;
    private static boolean initialized;

    private Properties properties;

    private GroverConstantProperties(String[] args) throws IOException {
        System.out.println("Initializing AppPropertiesSupport");
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (arg.startsWith("spark-app-property-file-path")) {
                String path = arg.split("=")[1];
                File file = new File(path);
                FileInputStream fileInput = new FileInputStream(file);
                properties = new Properties();
                properties.load(fileInput);
                fileInput.close();
                break;
            }
        }
    }

    public static void init(String[] args) throws IOException {
        if (!initialized) {
            instance = new GroverConstantProperties(args);
            initialized = true;
        }
    }

    public String getString(String property) {
        return properties.getProperty(property);
    }

    public Integer getInt(String property) {
        return Integer.parseInt(properties.getProperty(property));
    }

    public Boolean getBoolean(String property){
        return Boolean.parseBoolean(properties.getProperty(property));
    }

    public Properties getProperties(String namespace) {
        Properties propertiesInNamespace = new Properties();
        Enumeration names = properties.propertyNames();
        while (names.hasMoreElements()) {
            String name = String.valueOf(names.nextElement());
            if (StringUtils.startsWith(name, namespace)) {
                propertiesInNamespace.setProperty(name, properties.getProperty(name));
            }
        }
        return propertiesInNamespace;
    }

    public static GroverConstantProperties getInstance() {
        return instance;
    }
}
