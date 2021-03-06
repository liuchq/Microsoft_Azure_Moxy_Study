import com.liuchq.Moxy.constant.MyConstants;
import com.liuchq.Moxy.dao.CourseMapper;
import com.liuchq.Moxy.utils.EncryptUtils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: Microsoft_Azure_Moxy_Study
 * @description: uuid
 * @author: liuchq
 * @create: 2021-05-17
 **/
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestDoSomeThing {

    @Autowired
    private CourseMapper courseMapper;


    //public static final Logger logger = LogManager.getLogger("TestDoSomeThing");

    @Test
    public void Data(){
        HashMap<String, String> map = new HashMap<>();
        map.put("courseID","12345");
        map.put("message", MyConstants.STUDY_FINISHED);
        map.put("needSeconds","200");
        map.put("userAccount","test");
        courseMapper.updateByUserAndCourseNumber(map);
    }


    @Test
    public void testLog(){
//        logger.info("log info");
//        logger.error("log error");
//        logger.debug("log debug");
//        logger.warn("log warn");
    }


    @Test
    public void forPassword() throws Exception {
        String psw = "test";

        String key = "1234567887654321";

        //AES加密
        String s = EncryptUtils.aesEncrypt(psw,key);
        System.out.println("加密后："+s);

        //AES解密
        String s1 = EncryptUtils.aesDecrypt(s,key);
        System.out.println("解密后:"+s1);

    }


    /**
     * 输出字符串长度
     */
    @Test
    public void length(){
        System.out.println("09641742E3114198B8CC6592F8D1CCD2".length());
    }

    /**
     * 生成UUID
     */
    @Test
    public void getUUID(){
        for (int i = 0; i < 5; i++) {
            System.out.println(java.util.UUID.randomUUID().toString().replace("-","").toUpperCase());
        }
    }


    /**
     * 创建持久层
     */
    @Test
    public void createMapper(){
        try {
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            File configFile = new File("mybatisGenerator.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
