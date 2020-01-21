package dhcc.com.cn.service;

import org.junit.Test;


import java.sql.Date;

import static org.junit.Assert.*;

/**
 * Created by wangpenghui on 2019/11/19
 */
public class PdmServiceImplTest {
    @Test
    public void pdm2Excel() throws Exception {
        new PdmServiceImpl().pdm2Excel("C:\\Users\\13477\\Desktop\\华西二院探索系统表结构.pdm", "C:\\Users\\13477\\Desktop\\华西二院.xlsx");
    }

}