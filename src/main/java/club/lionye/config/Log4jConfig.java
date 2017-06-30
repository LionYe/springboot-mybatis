package club.lionye.config;

import java.io.InputStream;

//import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

//以java配置的方式注入日志   @Configuration 将此文件定义为配置文件
//@Configuration
public class Log4jConfig {

//	@Value("${log4j.path}")
//	public void config (String path){
//        try{
//            //初始化log4j
//            InputStream log4jPath = Log4jConfig.class.getClassLoader().getResourceAsStream(path);
////            System.out.println("初始化Log4j。。。。");
////            System.out.println("path is "+ log4jPath);
//            PropertyConfigurator.configure(log4jPath);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//	}
	
	
}
