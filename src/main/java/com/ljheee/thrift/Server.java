package com.ljheee.thrift;

import com.ljheee.thrift.service.QueryService;
import com.ljheee.thrift.serviceImpl.QueryServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;

/**
 * Created by lijianhua04 on 2018/7/27.
 */
public class Server {


    public static final int SERVER_PORT = 9999;
    public static final String SERVER_IP = "localhost";
    public static final int TIMEOUT = 30000;



    public static void main(String[] args) {
        try {
            System.out.println("QueryService TSimpleServer start ....");

            TProcessor tprocessor = new QueryService.Processor<QueryService.Iface>(new QueryServiceImpl());
            // 简单的单线程服务模型，一般用于测试
            TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
            TServer.Args tArgs = new TServer.Args(serverTransport);
            tArgs.processor(tprocessor);
            tArgs.protocolFactory(new TBinaryProtocol.Factory());
            // tArgs.protocolFactory(new TCompactProtocol.Factory());
            // tArgs.protocolFactory(new TJSONProtocol.Factory());
            TServer server = new TSimpleServer(tArgs);
            server.serve();
        } catch (Exception e) {
            System.out.println("Server start error!!!");
            e.printStackTrace();
        }
    }



}
