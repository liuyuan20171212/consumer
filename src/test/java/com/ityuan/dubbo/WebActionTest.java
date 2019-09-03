package com.ityuan.dubbo;

import com.ityuan.dubbo.web.TestWebController;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * web层测试类
 *
 * @Author ityuan
 * @Date 2019-07-29 10:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration//开启web应用的配置
public class WebActionTest {

    private MockMvc mockMvc;

    @Before
    public void before() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new TestWebController()).build();
    }
    
}
