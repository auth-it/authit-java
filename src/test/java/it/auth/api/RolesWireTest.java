package it.auth.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.auth.api.core.ObjectMappers;
import it.auth.api.types.GetRolesRequest;
import it.auth.api.types.GetUsersByRoleRequest;
import it.auth.api.types.RoleRepresentation;
import it.auth.api.types.UserRepresentation;
import java.util.List;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RolesWireTest {
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
    public void testGetRoles() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "[{\"id\":\"id\",\"name\":\"name\",\"description\":\"description\",\"composite\":true,\"composites\":{\"realm\":[\"realm\"],\"client\":{\"key\":[\"value\"]}},\"clientRole\":true,\"containerId\":\"containerId\",\"attributes\":{\"key\":[\"value\"]}}]"));
        List<RoleRepresentation> response = client.roles()
                .getRoles(GetRolesRequest.builder()
                        .briefRepresentation(true)
                        .first(1)
                        .max(1)
                        .search("search")
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
                + "    \"name\": \"name\",\n"
                + "    \"description\": \"description\",\n"
                + "    \"composite\": true,\n"
                + "    \"composites\": {\n"
                + "      \"realm\": [\n"
                + "        \"realm\"\n"
                + "      ],\n"
                + "      \"client\": {\n"
                + "        \"key\": [\n"
                + "          \"value\"\n"
                + "        ]\n"
                + "      }\n"
                + "    },\n"
                + "    \"clientRole\": true,\n"
                + "    \"containerId\": \"containerId\",\n"
                + "    \"attributes\": {\n"
                + "      \"key\": [\n"
                + "        \"value\"\n"
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
    public void testCreateRole() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.roles().createRole(RoleRepresentation.builder().build());
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
    public void testGetRole() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"id\":\"id\",\"name\":\"name\",\"description\":\"description\",\"composite\":true,\"composites\":{\"realm\":[\"realm\"],\"client\":{\"key\":[\"value\"]}},\"clientRole\":true,\"containerId\":\"containerId\",\"attributes\":{\"key\":[\"value\"]}}"));
        RoleRepresentation response = client.roles().getRole("role-name");
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"id\": \"id\",\n"
                + "  \"name\": \"name\",\n"
                + "  \"description\": \"description\",\n"
                + "  \"composite\": true,\n"
                + "  \"composites\": {\n"
                + "    \"realm\": [\n"
                + "      \"realm\"\n"
                + "    ],\n"
                + "    \"client\": {\n"
                + "      \"key\": [\n"
                + "        \"value\"\n"
                + "      ]\n"
                + "    }\n"
                + "  },\n"
                + "  \"clientRole\": true,\n"
                + "  \"containerId\": \"containerId\",\n"
                + "  \"attributes\": {\n"
                + "    \"key\": [\n"
                + "      \"value\"\n"
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
    public void testUpdateRole() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.roles().updateRole("role-name", RoleRepresentation.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PUT", request.getMethod());
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
    public void testDeleteRole() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.roles().deleteRole("role-name");
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("DELETE", request.getMethod());
    }

    @Test
    public void testGetUsersByRole() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "[{\"organizations\":[\"organizations\"],\"id\":\"id\",\"username\":\"username\",\"firstName\":\"firstName\",\"lastName\":\"lastName\",\"email\":\"email\",\"emailVerified\":true,\"attributes\":{\"key\":[\"value\"]},\"userProfileMetadata\":{\"attributes\":[{}],\"groups\":[{}]},\"enabled\":true,\"self\":\"self\",\"origin\":\"origin\",\"createdTimestamp\":1000000,\"totp\":true,\"federationLink\":\"federationLink\",\"serviceAccountClientId\":\"serviceAccountClientId\",\"credentials\":[{}],\"disableableCredentialTypes\":[\"disableableCredentialTypes\"],\"requiredActions\":[\"requiredActions\"],\"federatedIdentities\":[{}],\"realmRoles\":[\"realmRoles\"],\"clientRoles\":{\"key\":[\"value\"]},\"clientConsents\":[{}],\"notBefore\":1,\"groups\":[\"groups\"],\"access\":{\"key\":true}}]"));
        List<UserRepresentation> response = client.roles()
                .getUsersByRole(
                        "role-name",
                        GetUsersByRoleRequest.builder()
                                .briefRepresentation(true)
                                .first(1)
                                .max(1)
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
                + "    \"organizations\": [\n"
                + "      \"organizations\"\n"
                + "    ],\n"
                + "    \"id\": \"id\",\n"
                + "    \"username\": \"username\",\n"
                + "    \"firstName\": \"firstName\",\n"
                + "    \"lastName\": \"lastName\",\n"
                + "    \"email\": \"email\",\n"
                + "    \"emailVerified\": true,\n"
                + "    \"attributes\": {\n"
                + "      \"key\": [\n"
                + "        \"value\"\n"
                + "      ]\n"
                + "    },\n"
                + "    \"userProfileMetadata\": {\n"
                + "      \"attributes\": [\n"
                + "        {}\n"
                + "      ],\n"
                + "      \"groups\": [\n"
                + "        {}\n"
                + "      ]\n"
                + "    },\n"
                + "    \"enabled\": true,\n"
                + "    \"self\": \"self\",\n"
                + "    \"origin\": \"origin\",\n"
                + "    \"createdTimestamp\": 1000000,\n"
                + "    \"totp\": true,\n"
                + "    \"federationLink\": \"federationLink\",\n"
                + "    \"serviceAccountClientId\": \"serviceAccountClientId\",\n"
                + "    \"credentials\": [\n"
                + "      {}\n"
                + "    ],\n"
                + "    \"disableableCredentialTypes\": [\n"
                + "      \"disableableCredentialTypes\"\n"
                + "    ],\n"
                + "    \"requiredActions\": [\n"
                + "      \"requiredActions\"\n"
                + "    ],\n"
                + "    \"federatedIdentities\": [\n"
                + "      {}\n"
                + "    ],\n"
                + "    \"realmRoles\": [\n"
                + "      \"realmRoles\"\n"
                + "    ],\n"
                + "    \"clientRoles\": {\n"
                + "      \"key\": [\n"
                + "        \"value\"\n"
                + "      ]\n"
                + "    },\n"
                + "    \"clientConsents\": [\n"
                + "      {}\n"
                + "    ],\n"
                + "    \"notBefore\": 1,\n"
                + "    \"groups\": [\n"
                + "      \"groups\"\n"
                + "    ],\n"
                + "    \"access\": {\n"
                + "      \"key\": true\n"
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
