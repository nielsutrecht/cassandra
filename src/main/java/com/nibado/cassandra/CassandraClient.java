package com.nibado.cassandra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;

public class CassandraClient {
    private static final Logger LOG = LoggerFactory.getLogger(CassandraClient.class);
    private Cluster _cluster;

    public void connect(final String node) {
        LOG.info("Connecting to Cassandra cluster on {}", node);
        _cluster = Cluster
            .builder()
            .addContactPoint(node)
            .build();
        final Metadata metadata = _cluster.getMetadata();
        LOG.info("Connected to cluster {}", metadata.getClusterName());
        for (final Host host : metadata.getAllHosts()) {
            LOG.info("Datacenter: {} Host: {} Rack {}", host.getDatacenter(), host.getAddress(), host.getRack());
        }
    }

    public void close() {
        _cluster.close();
    }
}
