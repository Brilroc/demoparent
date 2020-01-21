package dhcc.com.cn.service;

import dhcc.com.cn.entity.Table;
import dhcc.com.cn.util.CreateExcel;
import dhcc.com.cn.util.PdmParser;

/**
 * Created by wangpenghui on 2019/11/19
 */
public class PdmServiceImpl implements PdmService {

    @Override
    public void pdm2Excel(String pdmPath, String excelPath) {
        PdmParser pp = new PdmParser();
        Table[] tab = pp.parsePdm(pdmPath);
        pp.printTable(tab);
        CreateExcel ep = new CreateExcel();
        ep.createExcel(tab, excelPath);
    }

}
