package com.ljheee.thrift.serviceImpl;

import com.ljheee.thrift.service.QueryService;
import org.apache.thrift.TException;

/**
 * Created by lijianhua04 on 2018/7/27.
 */
public class QueryServiceImpl implements QueryService.Iface {

    @Override
    public String query(String query) throws TException {
        return "Hello,"+query;
    }
}
