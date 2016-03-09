/**
 * 宝龙电商
 * com.plocc.framework.dao.impl
 * BaseDaoImpl.java
 *
 * 2013-7-12-下午6:03
 * 2013宝龙公司-版权所有
 *
 */
package com.plocc.framework.dao.impl;

import com.plocc.framework.page.Paginator;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.util.Assert;

import java.util.List;

/**
 * BaseDaoImpl
 *
 * @author Zhanggj
 * @version 1.0.0
 * @date 2013-7-12-下午6:03
 * @email zhanggj-hws@powerlong.com
 * @description Base Dao 基础 数据库操作类，扩展 分页方法 .....
 */
public abstract class BaseDaoImpl {

    private SqlMapClientTemplate sqlMapClient;

    public void setSqlMapClient(SqlMapClientTemplate sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public SqlMapClientTemplate getSqlMapClient() {
        return sqlMapClient;
    }

    public abstract String getNamespace();

    /**
     * 通用分页函数
     *
     * @param countNameSpace
     * @param pageNameSpace
     * @param paginator
     * @return
     */
    public Paginator paginateObject(String countNameSpace, String pageNameSpace, Paginator paginator) {
        //Assert.isTrue(null != paginator.getParams(), "入参不能为空，pager.getParams()==NULL");
        Integer count = Integer.valueOf(sqlMapClient.queryForObject(getNamespace() + "." + countNameSpace, paginator).toString());
        List result = sqlMapClient.queryForList(getNamespace() + "." + pageNameSpace, paginator);
        paginator.setItems(count);
        paginator.setResults(result);
        return paginator;
    }
}
