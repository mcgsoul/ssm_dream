import com.feilonkji.www.entity.User;
import com.feilonkji.www.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * @title: TestTransaction
 * @Description:
 * @Author zr
 * @Date:2020/9/25 11:03
 * @Version 1.8
 */
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:applicationContext-redis.xml","classpath:spring-mvc.xml"})
public class TestTransaction extends AbstractJUnit4SpringContextTests {

    @Autowired
    UserService userService;
    @Test
    public void test_1(){
        User user =new User();
        user.setNickName("勺勺");
        user.setEmail("2409046585@qq.com");
      //  userService.regist(user);
        userService.findByEmail(user.getEmail());
    }

}
