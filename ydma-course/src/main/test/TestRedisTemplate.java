import cn.ysf.ydma.RunBoot;
import cn.ysf.ydma.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author YiShunFeng
 * @version 1.0
 * @description PACKAGE_NAME
 * @data 2020/5/11
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RunBoot.class})
public class TestRedisTemplate {
    @Autowired
    private RedisTemplate<Object,Object> redis;
    @Test
    public void test(){
        Course course = new Course();
        redis.opsForValue().set("computers","555");
    }
}
