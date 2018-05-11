package com.byzoro;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;

/**
 * @author: huanyuguo
 * @date: 2018/5/8 16:53
 **/
public class EsClient {

    TransportClient client = null;
    private static String CLUSTERNAME = "elasticsearch";
    private static String HOST1 = "10.8.1.38";
    private static String HOST2 = "10.8.1.39";
    private static String HOST3 = "10.8.1.41";
    private static int PORT = 9300;

    public EsClient() {
        /**
         * 1:通过 setting对象来指定集群配置信息
         */
        try {
            Settings.builder().put("cluster.name", CLUSTERNAME)
                    .put("client.transport.sniff", true)
                    .build();
            client = new PreBuiltTransportClient(Settings.EMPTY)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName(HOST1), PORT))
                    .addTransportAddress(new TransportAddress(InetAddress.getByName(HOST2), PORT))
                    .addTransportAddress(new TransportAddress(InetAddress.getByName(HOST3), PORT));
        } catch (Exception ex) {
            client.close();
        } finally {

        }
    }
    /**
     * @Describe  TODO: 获得连接
     * @Param null
     * @return null
     * @author huanyuguo
     * @date 2018/5/11 7:40
    **/
    public TransportClient getConnection() {
        if (client == null) {
            synchronized (EsClient.class) {
                if (client == null) {
                    new EsClient();
                }
            }
        }
        return client;
    }


}