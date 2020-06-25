import cn.ysf.ydma.RunUserBoot;
import cn.ysf.ydma.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author YiShunFeng
 * @version 1.0
 * @description PACKAGE_NAME
 * @data 2020/4/23
 */
//@RunWith(SpringJUnit4ClassRunner.class)以前的老版本
@RunWith(SpringRunner.class) //他可以加载配置文件,创建Spring容器,进行对象注入
@SpringBootTest(classes ={RunUserBoot.class} )
public class TestUserController {
    @Autowired
    private UserController userController;
    @Test
    public void  test1() throws Exception {
        //使用controller创建一个MockMvc
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        //使用mockMvc对象发送请求,获取返回结果
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/register")
                .param("name","admin")
                .param("password","admin");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        //打印返回结果
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }
    /*@Test
    public void  test2(){
        System.out.println("test2.............");
    }
    @Test
    public void  test3(){
        //比较预期的值
        String expected = "132";
        Assert.assertEquals(expected,"abc");
        System.out.println("test3.............");
    }*/
    @Test
    public void  test2() throws Exception {
        //使用controller创建一个MockMvc
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        //使用mockMvc对象发送请求,获取返回结果
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/login")
                .param("name","admin")
                .param("password","admin");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        //打印返回结果
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }
    @Test
    public void  test3() throws Exception {
        //使用controller创建一个MockMvc
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        //使用mockMvc对象发送请求,获取返回结果
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/find")
                .param("id","31");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        //打印返回结果
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }
}
