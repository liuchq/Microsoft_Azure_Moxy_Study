import com.liuchq.moxy.bean.Course;
import com.liuchq.moxy.constant.MyConstants;
import com.liuchq.moxy.dao.CourseMapper;
import com.liuchq.moxy.utils.EncryptUtils;

import com.liuchq.moxy.utils.MyUtils;
import com.liuchq.wx.bean.WxToken;
import com.liuchq.wx.dao.WxTokenMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private WxTokenMapper wxTokenMapper;


    //public static final Logger logger = LogManager.getLogger("TestDoSomeThing");

    @Test
    @Transactional
    public void insertToken(){
        // 存入数据库并且返回
        WxToken data = new WxToken();
        data.setId(MyUtils.getUUid());
        data.setToken("60_pvpGw1eFkT7rWhk1NOB-7jbquuK3juEOfCga9UmK82RNZyFT-V_OyNE_dYpb1xN0MMj1_7zoyQMIPMcVLMD9smYYD8zxJJX95hXGpeaXgAa9UAblVCg8MacOLeOa9lV0Rxii3C6WrnxFe6JkZDPjAFAVZL");
        data.setCreateDate(new Date());
        int i = wxTokenMapper.insert(data);
        System.out.println(i);
    }


    @Test
    @Transactional
    @Commit
    public void Data(){
        HashMap<String, String> map = new HashMap<>();
        map.put("courseID","22222");
        map.put("message", MyConstants.STUDY_FINISHED);
        map.put("needSeconds","111");
        map.put("userAccount","test");
        courseMapper.updateByUserAndCourseNumber(map);

//        Course course = new Course();
//        course.setCourseId("222");
//        course.setCourseNumber("111");
//        course.setCourseSectionNumber("111");
//        course.setCourseCreatetime(new Date());
//        course.setCourseOwner("111");
//        course.setCourseNeedSeconds("111");
//        course.setCourseVersion("111");
//        courseMapper.insert(course);
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
