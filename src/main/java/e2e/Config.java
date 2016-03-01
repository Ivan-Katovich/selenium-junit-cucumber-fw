package e2e;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    public static String author;
    public static String authorLogin;
    public static String authorPassword;
    public static String publish;
    public static String browser;

    public static void InitParams(){

        Properties property = new Properties();
        try {
            try(FileInputStream fis = new FileInputStream("target/classes/config.properties")){
                property.load(fis);

                switch (property.getProperty("environment")) {
                    case "test1":
                        author = "https://author.test1-cms.gb.travelsupermarket.com";
                        publish = "http://www.test1-cms.gb.travelsupermarket.com/";
                        System.out.println("<< Environment >> : test1 \n author: " + author + "\n publish: " + publish);
                        break;
                    case "ci1":
                        author = "http://author.ci1-cms.gb.travelsupermarket.com";
                        publish = "http://www.ci1-cms.gb.travelsupermarket.com/";
                        System.out.println("<< Environment >> : ci1 \n author: " + author + "\n publish: " + publish);
                        break;
                    case "test1ByIp":
                        author = "http://54.229.175.197:8080";
                        publish = "http://54.229.175.197:8081/";
                        System.out.println("<< Environment >> : test1 \n author: " + author + "\n publish: " + publish);
                        break;
                    case "ci1ByIp":
                        author = "http://54.171.205.233:8080";
                        publish = "http://54.171.205.233:8081/";
                        System.out.println("<< Environment >> : ci1 \n author: " + author + "\n publish: " + publish);
                        break;
                    case "localhost":
                        author = "http://localhost:4502";
                        publish = "http://localhost:4503/";
                        System.out.println("<< Environment >> : localhost \n author: " + author + "\n publish: " + publish);
                        break;
                    default:
                        System.out.println("no environments for test");
                        throw new AssertionError("No environments");
                }
                authorLogin = property.getProperty("author.login");
                authorPassword = property.getProperty("author.password");
                browser = property.getProperty("browser");
            }

        } catch (IOException e) {
            System.err.println("config.properties doesn't exist!");
        }
    }
}
