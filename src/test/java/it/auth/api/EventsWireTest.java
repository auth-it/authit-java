package it.auth.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.auth.api.core.ObjectMappers;
import it.auth.api.types.AdminEventRepresentation;
import it.auth.api.types.AuditEventRepresentation;
import it.auth.api.types.EventRepresentation;
import it.auth.api.types.GetAdminEventsRequest;
import it.auth.api.types.GetEventsRequest;
import java.util.List;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EventsWireTest {
    private MockWebServer server;
    private AuthItClient client;
    private ObjectMapper objectMapper = ObjectMappers.JSON_MAPPER;

    @BeforeEach
    public void setup() throws Exception {
        server = new MockWebServer();
        server.start();
        client = AuthItClient.builder()
                .url(server.url("/").toString())
                .token("oauth-test-token")
                .build();
    }

    @AfterEach
    public void teardown() throws Exception {
        server.shutdown();
    }

    @Test
    public void testDeleteAdminEvents() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.events().deleteAdminEvents();
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("DELETE", request.getMethod());
    }

    @Test
    public void testDeleteEvents() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.events().deleteEvents();
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("DELETE", request.getMethod());
    }

    @Test
    public void testCreateEvent() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.events().createEvent(AuditEventRepresentation.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{}";
        JsonNode actualJson = objectMapper.readTree(actualRequestBody);
        JsonNode expectedJson = objectMapper.readTree(expectedRequestBody);
        Assertions.assertEquals(expectedJson, actualJson, "Request body structure does not match expected");
        if (actualJson.has("type") || actualJson.has("_type") || actualJson.has("kind")) {
            String discriminator = null;
            if (actualJson.has("type")) discriminator = actualJson.get("type").asText();
            else if (actualJson.has("_type"))
                discriminator = actualJson.get("_type").asText();
            else if (actualJson.has("kind"))
                discriminator = actualJson.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualJson.isNull()) {
            Assertions.assertTrue(
                    actualJson.isObject() || actualJson.isArray() || actualJson.isValueNode(),
                    "request should be a valid JSON value");
        }

        if (actualJson.isArray()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Array should have valid size");
        }
        if (actualJson.isObject()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Object should have valid field count");
        }
    }

    @Test
    public void testGetEvents() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "[{\"id\":\"id\",\"time\":1000000,\"type\":\"type\",\"realmId\":\"realmId\",\"clientId\":\"clientId\",\"userId\":\"userId\",\"sessionId\":\"sessionId\",\"ipAddress\":\"ipAddress\",\"error\":\"error\",\"details\":{\"key\":\"value\"}}]"));
        List<EventRepresentation> response = client.events()
                .getEvents(GetEventsRequest.builder()
                        .client("client")
                        .dateFrom("dateFrom")
                        .dateTo("dateTo")
                        .first(1)
                        .ipAddress("ipAddress")
                        .max(1)
                        .user("user")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "[\n"
                + "  {\n"
                + "    \"id\": \"id\",\n"
                + "    \"time\": 1000000,\n"
                + "    \"type\": \"type\",\n"
                + "    \"realmId\": \"realmId\",\n"
                + "    \"clientId\": \"clientId\",\n"
                + "    \"userId\": \"userId\",\n"
                + "    \"sessionId\": \"sessionId\",\n"
                + "    \"ipAddress\": \"ipAddress\",\n"
                + "    \"error\": \"error\",\n"
                + "    \"details\": {\n"
                + "      \"key\": \"value\"\n"
                + "    }\n"
                + "  }\n"
                + "]";
        JsonNode actualResponseNode = objectMapper.readTree(actualResponseJson);
        JsonNode expectedResponseNode = objectMapper.readTree(expectedResponseBody);
        Assertions.assertEquals(
                expectedResponseNode, actualResponseNode, "Response body structure does not match expected");
        if (actualResponseNode.has("type") || actualResponseNode.has("_type") || actualResponseNode.has("kind")) {
            String discriminator = null;
            if (actualResponseNode.has("type"))
                discriminator = actualResponseNode.get("type").asText();
            else if (actualResponseNode.has("_type"))
                discriminator = actualResponseNode.get("_type").asText();
            else if (actualResponseNode.has("kind"))
                discriminator = actualResponseNode.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualResponseNode.isNull()) {
            Assertions.assertTrue(
                    actualResponseNode.isObject() || actualResponseNode.isArray() || actualResponseNode.isValueNode(),
                    "response should be a valid JSON value");
        }

        if (actualResponseNode.isArray()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Array should have valid size");
        }
        if (actualResponseNode.isObject()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Object should have valid field count");
        }
    }

    @Test
    public void testGetAdminEvents() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "[{\"id\":\"id\",\"time\":1000000,\"realmId\":\"realmId\",\"authDetails\":{\"realmId\":\"realmId\",\"clientId\":\"clientId\",\"userId\":\"userId\",\"ipAddress\":\"ipAddress\",\"username\":\"username\",\"sessionId\":\"sessionId\"},\"operationType\":\"operationType\",\"resourceType\":\"resourceType\",\"resourcePath\":\"resourcePath\",\"representation\":\"representation\",\"error\":\"error\",\"details\":{\"key\":\"value\"}}]"));
        List<AdminEventRepresentation> response = client.events()
                .getAdminEvents(GetAdminEventsRequest.builder()
                        .authClient("authClient")
                        .authIpAddress("authIpAddress")
                        .authRealm("authRealm")
                        .authUser("authUser")
                        .dateFrom("dateFrom")
                        .dateTo("dateTo")
                        .first(1)
                        .max(1)
                        .resourcePath("resourcePath")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "[\n"
                + "  {\n"
                + "    \"id\": \"id\",\n"
                + "    \"time\": 1000000,\n"
                + "    \"realmId\": \"realmId\",\n"
                + "    \"authDetails\": {\n"
                + "      \"realmId\": \"realmId\",\n"
                + "      \"clientId\": \"clientId\",\n"
                + "      \"userId\": \"userId\",\n"
                + "      \"ipAddress\": \"ipAddress\",\n"
                + "      \"username\": \"username\",\n"
                + "      \"sessionId\": \"sessionId\"\n"
                + "    },\n"
                + "    \"operationType\": \"operationType\",\n"
                + "    \"resourceType\": \"resourceType\",\n"
                + "    \"resourcePath\": \"resourcePath\",\n"
                + "    \"representation\": \"representation\",\n"
                + "    \"error\": \"error\",\n"
                + "    \"details\": {\n"
                + "      \"key\": \"value\"\n"
                + "    }\n"
                + "  }\n"
                + "]";
        JsonNode actualResponseNode = objectMapper.readTree(actualResponseJson);
        JsonNode expectedResponseNode = objectMapper.readTree(expectedResponseBody);
        Assertions.assertEquals(
                expectedResponseNode, actualResponseNode, "Response body structure does not match expected");
        if (actualResponseNode.has("type") || actualResponseNode.has("_type") || actualResponseNode.has("kind")) {
            String discriminator = null;
            if (actualResponseNode.has("type"))
                discriminator = actualResponseNode.get("type").asText();
            else if (actualResponseNode.has("_type"))
                discriminator = actualResponseNode.get("_type").asText();
            else if (actualResponseNode.has("kind"))
                discriminator = actualResponseNode.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualResponseNode.isNull()) {
            Assertions.assertTrue(
                    actualResponseNode.isObject() || actualResponseNode.isArray() || actualResponseNode.isValueNode(),
                    "response should be a valid JSON value");
        }

        if (actualResponseNode.isArray()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Array should have valid size");
        }
        if (actualResponseNode.isObject()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Object should have valid field count");
        }
    }
}
