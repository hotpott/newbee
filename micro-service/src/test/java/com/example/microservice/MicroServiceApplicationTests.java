package com.example.microservice;

import com.example.microservice.Controller.HelloController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 引入JUnit4支持，什么事JUnit4自己看
@RunWith(SpringJUnit4ClassRunner.class)
// 指定SpringBoot启动类为 MicroServiceApplication.class
@SpringApplicationConfiguration(classes = MicroServiceApplication.class)
// 开启Web应用的配置，用于模拟ServletContext
@WebAppConfiguration
// 下面那行，不注释掉，不能执行
//@SpringBootTest
class MicroServiceApplicationTests {

    // 模拟调用controller接口
    private MockMvc mvc;

    // 在@Test之前进行预加载的内容，用于初始化对HelloController的模拟
    // 原文用@Before但是报错，@BeforeEach是JUnit5,@before是JUnit4
    @BeforeEach
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
        System.out.println("xxx");
    }

    @Test
    public void hello() throws Exception {
        // perform执行调用
        // accept执行接受的数据类型
        // andExcept判断接口返回的期望值
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(content().string(equalTo("Hello World")));
        // 正确
        // import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
        // 錯誤
        // import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
    }

}
