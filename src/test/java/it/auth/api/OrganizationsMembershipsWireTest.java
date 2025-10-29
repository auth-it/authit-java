package it.auth.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.auth.api.core.ObjectMappers;
import it.auth.api.organizations.types.MembershipsCountMembershipsRequest;
import it.auth.api.organizations.types.MembershipsGetMembershipsRequest;
import it.auth.api.types.MyOrganizationRepresentation;
import it.auth.api.types.UserWithOrgsBriefRepresentation;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrganizationsMembershipsWireTest {
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
    public void testGetMemberInfo() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"key\":{\"name\":\"name\",\"displayName\":\"displayName\",\"url\":\"url\",\"attributes\":{\"key\":[\"value\"]},\"roles\":[\"roles\"]}}"));
        Map<String, MyOrganizationRepresentation> response =
                client.organizations().memberships().getMemberInfo();
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"key\": {\n"
                + "    \"name\": \"name\",\n"
                + "    \"displayName\": \"displayName\",\n"
                + "    \"url\": \"url\",\n"
                + "    \"attributes\": {\n"
                + "      \"key\": [\n"
                + "        \"value\"\n"
                + "      ]\n"
                + "    },\n"
                + "    \"roles\": [\n"
                + "      \"roles\"\n"
                + "    ]\n"
                + "  }\n"
                + "}";
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
    public void testGetMemberships() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "[{\"createdTimestamp\":1000000,\"email\":\"email\",\"emailVerified\":true,\"enabled\":true,\"firstName\":\"firstName\",\"groups\":[\"groups\"],\"id\":\"id\",\"lastName\":\"lastName\",\"username\":\"username\",\"organizations\":{\"key\":[{}]}}]"));
        List<UserWithOrgsBriefRepresentation> response = client.organizations()
                .memberships()
                .getMemberships(
                        "orgId",
                        MembershipsGetMembershipsRequest.builder()
                                .search("search")
                                .first(1)
                                .max(1)
                                .excludeAdminAccounts(true)
                                .includeOrgs(true)
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
                + "    \"createdTimestamp\": 1000000,\n"
                + "    \"email\": \"email\",\n"
                + "    \"emailVerified\": true,\n"
                + "    \"enabled\": true,\n"
                + "    \"firstName\": \"firstName\",\n"
                + "    \"groups\": [\n"
                + "      \"groups\"\n"
                + "    ],\n"
                + "    \"id\": \"id\",\n"
                + "    \"lastName\": \"lastName\",\n"
                + "    \"username\": \"username\",\n"
                + "    \"organizations\": {\n"
                + "      \"key\": [\n"
                + "        {}\n"
                + "      ]\n"
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
    public void testCountMemberships() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("1"));
        Integer response = client.organizations()
                .memberships()
                .countMemberships(
                        "orgId",
                        MembershipsCountMembershipsRequest.builder()
                                .excludeAdminAccounts(true)
                                .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = "" + "1";
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
    public void testIsMember() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.organizations().memberships().isMember("orgId", "userId");
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());
    }

    @Test
    public void testAddMember() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.organizations().memberships().addMember("orgId", "userId");
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PUT", request.getMethod());
    }

    @Test
    public void testRemoveMember() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.organizations().memberships().removeMember("orgId", "userId");
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("DELETE", request.getMethod());
    }
}
