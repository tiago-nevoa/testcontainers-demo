//package com.jetbrains.testcontainersdemo;
//
//import static org.hamcrest.Matchers.is;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertThat;
//
//import com.datastax.oss.driver.api.core.CqlSession;
//import com.datastax.oss.driver.api.core.cql.ResultSet;
//import com.datastax.oss.driver.api.core.cql.Row;
//import org.cassandraunit.CQLDataLoader;
//import org.cassandraunit.dataset.cql.ClassPathCQLDataSet;
//import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//public class NativeEmbeddedCassandraUnitTest {
//
//    private static CqlSession session;
//
//    @BeforeClass
//    public static void setUpBeforeClass() throws Exception {
//        EmbeddedCassandraServerHelper.startEmbeddedCassandra(EmbeddedCassandraServerHelper.CASSANDRA_RNDPORT_YML_FILE);
//        session = EmbeddedCassandraServerHelper.getSession();
//        new CQLDataLoader(session).load(new ClassPathCQLDataSet("audit-logs.cql", "logs"));
//    }
//
//    @AfterClass
//    public static void tearDownAfterClass() throws Exception {
//        if (session != null) {
//            session.close();
//        }
//        //EmbeddedCassandraServerHelper.cleanEmbeddedCassandra();
//    }
//
//    @Test
//    public void givenEmbeddedCassandraInstance_whenStarted_thenQuerySuccess() throws Exception {
//        ResultSet result = session.execute("SELECT * FROM logs");
//        assertNotNull(result);
//    }
//
//    @Test
//    public void givenEmbeddedCassandraLog_whenOrgIdSpaceIdTenant_thenMessageCorrect() throws Exception {
//        ResultSet result = session.execute("SELECT * FROM logs WHERE org_id ='org_id'"
//                                           + "AND space_id ='space_id'"
//                                           + "AND tenant = 'tenant'");
//
//        Row row = result.iterator().next();
//
//        assertThat(row.getString("message_uuid"), is("message_uuid"));
//        assertThat(row.getString("time"), is("time"));
//        assertThat(row.getString("app_or_service_id"), is("app_or_service_id"));
//        assertThat(row.getString("als_service_id"), is("als_service_id"));
//        assertThat(row.getString("user"), is("user"));
//        assertThat(row.getString("category"), is("category"));
//        assertThat(row.getString("format_version"), is("format_version"));
//        assertThat(row.getString("message"), is("message"));
//    }
//
//    @Test
//    public void givenEmbeddedCassandraLog1_whenOrgIdSpaceIdTenant_thenMessageCorrect() throws Exception {
//        ResultSet result = session.execute("SELECT * FROM logs WHERE org_id ='d308fba0-0bc8-463c-ac6c-9ed12281655d'"
//                                           + "AND space_id ='0343aa4d-85cc-4605-8f32-89f9db86c6cf'"
//                                           + "AND tenant = 'cf-eu20-staging-auditlog-viewer'");
//
//        Row row = result.iterator().next();
//
//        assertThat(row.getString("message_uuid"), is("d1a30729-79b1-4413-a096-c7fcf12beafa"));
//        assertThat(row.getString("time"), is("2023-07-08T07:53:22.955Z"));
//        assertThat(row.getString("app_or_service_id"), is("af7811db-ba47-4d35-a4da-122a865cca8c"));
//        assertThat(row.getString("als_service_id"), is("f9ea189f-6041-4e18-bb37-acc127bf0111"));
//        assertThat(row.getString("user"), is("sb-91991aa4-b2d6-410a-92d5-fac0cb591538!b6|auditlog-management!b6"));
//        assertThat(row.getString("category"), is("audit.data-access"));
//        assertThat(row.getString("format_version"), is(""));
//        assertThat(row.getString("message"), is("{\\\"uuid\\\":\\\"d1a30729-79b1-4413-a096-c7fcf12beafa\\\",\\\"user\\\":\\\"sb-91991aa4-b2d6-410a-92d5-fac0cb591538!b6|auditlog-management!b6\\\",\\\"time\\\":\\\"2023-07-08T07:53:22.955891584Z\\\",\\\"object\\\":{\\\"type\\\":\\\"data read event\\\",\\\"id\\\":{\\\"tenant_id\\\":\\\"cf-eu20-staging-auditlog-viewer\\\"}},\\\"data_subject\\\":{\\\"type\\\":\\\"account\\\",\\\"role\\\":\\\"account\\\",\\\"id\\\":{\\\"id\\\":\\\"sb-91991aa4-b2d6-410a-92d5-fac0cb591538!b6|auditlog-management!b6\\\"}},\\\"data_subjects\\\":[],\\\"attributes\\\":[{\\\"name\\\":\\\"data read event\\\",\\\"successful\\\":true}],\\\"attachments\\\":[],\\\"id\\\":\\\"bcf429fe-4b85-444c-a1a6-87c298fa6e7c\\\",\\\"category\\\":\\\"audit.data-access\\\",\\\"tenant\\\":\\\"cf-eu20-staging-auditlog-viewer\\\",\\\"customDetails\\\":{}}"));
//    }
//
//    @Test
//    public void givenEmbeddedCassandraLog2_whenOrgIdSpaceIdTenant_thenMessageCorrect() throws Exception {
//        ResultSet result = session.execute("SELECT * FROM logs WHERE org_id ='92f1da92-e5b3-4cc5-8c90-964165af11c8'"
//                                           + "AND space_id ='92f1da92-e5b3-4cc5-8c90-964165af11c8'"
//                                           + "AND tenant = 'cf-eu20-staging-auditlog-viewer'");
//
//        Row row = result.iterator().next();
//
//        assertThat(row.getString("message_uuid"), is("862996fd-51c9-412a-adaf-cd18aed54369"));
//        assertThat(row.getString("time"), is("2023-07-26T07:56:25.868Z"));
//        assertThat(row.getString("app_or_service_id"), is("92f1da92-e5b3-4cc5-8c90-964165af11c8"));
//        assertThat(row.getString("als_service_id"), is("f9ea189f-6041-4e18-bb37-acc127bf0111"));
//        assertThat(row.getString("user"), is("sb-91991aa4-b2d6-410a-92d5-fac0cb591538!b6|auditlog-management!b6"));
//        assertThat(row.getString("category"), is("audit.data-access"));
//        assertThat(row.getString("format_version"), is(""));
//        assertThat(row.getString("message"), is("{\\\"uuid\\\":\\\"862996fd-51c9-412a-adaf-cd18aed54369\\\",\\\"user\\\":\\\"sb-91991aa4-b2d6-410a-92d5-fac0cb591538!b6|auditlog-management!b6\\\",\\\"time\\\":\\\"2023-07-26T07:56:25.868443623Z\\\",\\\"object\\\":{\\\"type\\\":\\\"data read event\\\",\\\"id\\\":{\\\"tenant_id\\\":\\\"cf-eu20-staging-auditlog-viewer\\\"}},\\\"data_subject\\\":{\\\"type\\\":\\\"account\\\",\\\"role\\\":\\\"account\\\",\\\"id\\\":{\\\"id\\\":\\\"sb-91991aa4-b2d6-410a-92d5-fac0cb591538!b6|auditlog-management!b6\\\"}},\\\"data_subjects\\\":[],\\\"attributes\\\":[{\\\"name\\\":\\\"data read event\\\",\\\"successful\\\":true}],\\\"attachments\\\":[],\\\"id\\\":\\\"8a366337-6605-4ce3-bec9-940d4c5bef28\\\",\\\"category\\\":\\\"audit.data-access\\\",\\\"tenant\\\":\\\"cf-eu20-staging-auditlog-viewer\\\",\\\"customDetails\\\":{}}"));
//    }
//
//    @Test
//    public void givenEmbeddedCassandraLog3_whenOrgIdSpaceIdTenant_thenMessageCorrect() throws Exception {
//        ResultSet result = session.execute("SELECT * FROM logs WHERE org_id ='92f1da92-e5b3-4cc5-8c90-964165af11c8'"
//                                           + "AND space_id ='92f1da92-e5b3-4cc5-8c90-964165af11c8'"
//                                           + "AND tenant = 'cf-eu20-staging-auditlog-viewer'");
//
//        Row row = result.iterator().next();
//
//        assertThat(row.getString("message_uuid"), is("83e6cef2-c39f-4a82-a11e-2a5fa29fbe78"));
//        assertThat(row.getString("time"), is("2023-07-26T07:56:25.506Z"));
//        assertThat(row.getString("app_or_service_id"), is("92f1da92-e5b3-4cc5-8c90-964165af11c8"));
//        assertThat(row.getString("als_service_id"), is("f9ea189f-6041-4e18-bb37-acc127bf0111"));
//        assertThat(row.getString("user"), is("sb-91991aa4-b2d6-410a-92d5-fac0cb591538!b6|auditlog-management!b6"));
//        assertThat(row.getString("category"), is("audit.security-events"));
//        assertThat(row.getString("format_version"), is(""));
//        assertThat(row.getString("message"), is("{\\\"uuid\\\":\\\"83e6cef2-c39f-4a82-a11e-2a5fa29fbe78\\\",\\\"user\\\":\\\"sb-91991aa4-b2d6-410a-92d5-fac0cb591538!b6|auditlog-management!b6\\\",\\\"time\\\":\\\"2023-07-26T07:56:25.506203899Z\\\",\\\"ip\\\":\\\"20.56.74.112\\\",\\\"data\\\":\\\"successful login event\\\",\\\"attributes\\\":[],\\\"id\\\":\\\"f0475dcd-cddc-4d55-b3bd-e57c9bfb47a1\\\",\\\"category\\\":\\\"audit.security-events\\\",\\\"tenant\\\":\\\"cf-eu20-staging-auditlog-viewer\\\",\\\"customDetails\\\":{}}"));
//    }
//
//}