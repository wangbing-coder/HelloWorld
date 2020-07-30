package wb.classloader;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author bing.wang
 * @date 2020/7/28 23:33
 */
public class LoadProperties {

    @Test
    public void loadPropertiesByClassLoader() throws Exception{
        Properties properties = new Properties();
//        FileInputStream fileInputStream = new FileInputStream("src/main/resources/jdbc.properties");
//        properties.load(fileInputStream);

        //使用classLoader加载文件
        ClassLoader classLoader = LoadProperties.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc.properties");
        properties.load(resourceAsStream);

        System.out.println(properties.getProperty("user")+"==="+properties.getProperty("password"));
    }
}
