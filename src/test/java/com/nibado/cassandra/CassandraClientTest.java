package com.nibado.cassandra;

import org.junit.Test;

public class CassandraClientTest {
    @Test
    public void test() {
        final CassandraClient client = new CassandraClient();
        client.connect("127.0.0.1");
        client.close();
    }
}
