package com.ljheee.thrift;

import com.ljheee.thrift.service.QueryService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by lijianhua04 on 2018/7/27.
 */
public class Client {

    public static final int SERVER_PORT = 9999;
    public static final String SERVER_IP = "localhost";
    public static final int TIMEOUT = 30000;


    public static void main(String[] args) {

        TTransport transport = null;
        try {
            transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            // TProtocol protocol = new TCompactProtocol(transport);
            // TProtocol protocol = new TJSONProtocol(transport);
            QueryService.Client client = new QueryService.Client(protocol);
            transport.open();
            String result = client.query("ljh");
            System.out.println("Thrify client result =: " + result);
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
    }
}
