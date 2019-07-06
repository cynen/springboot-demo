package sms;


import com.cynen.sms.SmsApplication;
import com.cynen.sms.utils.SmsUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SmsApplication.class)
public class TestSms {

    @Autowired
    private SmsUtils smsUtils;

    // 从配置文件直接读取参数
    @Value("${aliyun.sms.template_code}")
    private String template_code;

    @Value("${aliyun.sms.sign_name}")
    private String sign_name;


    @Test
    public void send(){
        String mobile = "18986521556";
        String checkcode = "111222";
        smsUtils.sendSms(mobile,template_code,"{\"code\":\""+checkcode+"\"}",sign_name);
    }


}
