import cn.ysf.ydma.RunBoot;
import cn.ysf.ydma.dao.DirectionMapper;
import cn.ysf.ydma.dao.SubjectMapper;
import cn.ysf.ydma.entity.Direction;
import cn.ysf.ydma.entity.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author YiShunFeng
 * @version 1.0
 * @description PACKAGE_NAME
 * @data 2020/5/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RunBoot.class})
public class TestSubjectDaoDirection {
    @Autowired
    private SubjectMapper dao;
    @Autowired
    private DirectionMapper directionDao;
    @Test
    public void test1(){
        Subject subject = dao.selectById(1);
        System.out.println(subject);
    }
    @Test
    public void test2(){
       List<Direction> list = directionDao.selectAll();
        for (Direction d:list) {
            System.out.println(d);

        }
    }

}
