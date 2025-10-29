package it.auth.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.auth.api.core.ObjectMappers;
import it.auth.api.types.CountUsersRequest;
import it.auth.api.types.GetAdminRealmsRealmExtAdminUsersRequest;
import it.auth.api.types.GetUserRequest;
import it.auth.api.types.MagicLinkRequest;
import it.auth.api.types.OrganizationRepresentation;
import it.auth.api.types.SendActionEmailRequest;
import it.auth.api.types.SendVerifyEmailRequest;
import it.auth.api.types.UserRepresentation;
import it.auth.api.types.UserSessionRepresentation;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsersWireTest {
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
    public void testCreateUser() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.users().createUser(UserRepresentation.builder().build());
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
    public void testCountUsers() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("1"));
        Integer response = client.users()
                .countUsers(CountUsersRequest.builder()
                        .email("email")
                        .emailVerified(true)
                        .enabled(true)
                        .firstName("firstName")
                        .lastName("lastName")
                        .q("q")
                        .search("search")
                        .username("username")
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
    public void testGetUser() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"organizations\":[\"organizations\"],\"id\":\"id\",\"username\":\"username\",\"firstName\":\"firstName\",\"lastName\":\"lastName\",\"email\":\"email\",\"emailVerified\":true,\"attributes\":{\"key\":[\"value\"]},\"userProfileMetadata\":{\"attributes\":[{}],\"groups\":[{}]},\"enabled\":true,\"self\":\"self\",\"origin\":\"origin\",\"createdTimestamp\":1000000,\"totp\":true,\"federationLink\":\"federationLink\",\"serviceAccountClientId\":\"serviceAccountClientId\",\"credentials\":[{\"id\":\"id\",\"type\":\"type\",\"userLabel\":\"userLabel\",\"createdDate\":1000000,\"secretData\":\"secretData\",\"credentialData\":\"credentialData\",\"priority\":1,\"value\":\"value\",\"temporary\":true,\"config\":{\"key\":[\"value\"]},\"federationLink\":\"federationLink\"}],\"disableableCredentialTypes\":[\"disableableCredentialTypes\"],\"requiredActions\":[\"requiredActions\"],\"federatedIdentities\":[{\"identityProvider\":\"identityProvider\",\"userId\":\"userId\",\"userName\":\"userName\"}],\"realmRoles\":[\"realmRoles\"],\"clientRoles\":{\"key\":[\"value\"]},\"clientConsents\":[{\"clientId\":\"clientId\",\"grantedClientScopes\":[\"grantedClientScopes\"],\"createdDate\":1000000,\"lastUpdatedDate\":1000000}],\"notBefore\":1,\"groups\":[\"groups\"],\"access\":{\"key\":true}}"));
        UserRepresentation response = client.users()
                .getUser(
                        "user-id",
                        GetUserRequest.builder().userProfileMetadata(true).build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"organizations\": [\n"
                + "    \"organizations\"\n"
                + "  ],\n"
                + "  \"id\": \"id\",\n"
                + "  \"username\": \"username\",\n"
                + "  \"firstName\": \"firstName\",\n"
                + "  \"lastName\": \"lastName\",\n"
                + "  \"email\": \"email\",\n"
                + "  \"emailVerified\": true,\n"
                + "  \"attributes\": {\n"
                + "    \"key\": [\n"
                + "      \"value\"\n"
                + "    ]\n"
                + "  },\n"
                + "  \"userProfileMetadata\": {\n"
                + "    \"attributes\": [\n"
                + "      {}\n"
                + "    ],\n"
                + "    \"groups\": [\n"
                + "      {}\n"
                + "    ]\n"
                + "  },\n"
                + "  \"enabled\": true,\n"
                + "  \"self\": \"self\",\n"
                + "  \"origin\": \"origin\",\n"
                + "  \"createdTimestamp\": 1000000,\n"
                + "  \"totp\": true,\n"
                + "  \"federationLink\": \"federationLink\",\n"
                + "  \"serviceAccountClientId\": \"serviceAccountClientId\",\n"
                + "  \"credentials\": [\n"
                + "    {\n"
                + "      \"id\": \"id\",\n"
                + "      \"type\": \"type\",\n"
                + "      \"userLabel\": \"userLabel\",\n"
                + "      \"createdDate\": 1000000,\n"
                + "      \"secretData\": \"secretData\",\n"
                + "      \"credentialData\": \"credentialData\",\n"
                + "      \"priority\": 1,\n"
                + "      \"value\": \"value\",\n"
                + "      \"temporary\": true,\n"
                + "      \"config\": {\n"
                + "        \"key\": [\n"
                + "          \"value\"\n"
                + "        ]\n"
                + "      },\n"
                + "      \"federationLink\": \"federationLink\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"disableableCredentialTypes\": [\n"
                + "    \"disableableCredentialTypes\"\n"
                + "  ],\n"
                + "  \"requiredActions\": [\n"
                + "    \"requiredActions\"\n"
                + "  ],\n"
                + "  \"federatedIdentities\": [\n"
                + "    {\n"
                + "      \"identityProvider\": \"identityProvider\",\n"
                + "      \"userId\": \"userId\",\n"
                + "      \"userName\": \"userName\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"realmRoles\": [\n"
                + "    \"realmRoles\"\n"
                + "  ],\n"
                + "  \"clientRoles\": {\n"
                + "    \"key\": [\n"
                + "      \"value\"\n"
                + "    ]\n"
                + "  },\n"
                + "  \"clientConsents\": [\n"
                + "    {\n"
                + "      \"clientId\": \"clientId\",\n"
                + "      \"grantedClientScopes\": [\n"
                + "        \"grantedClientScopes\"\n"
                + "      ],\n"
                + "      \"createdDate\": 1000000,\n"
                + "      \"lastUpdatedDate\": 1000000\n"
                + "    }\n"
                + "  ],\n"
                + "  \"notBefore\": 1,\n"
                + "  \"groups\": [\n"
                + "    \"groups\"\n"
                + "  ],\n"
                + "  \"access\": {\n"
                + "    \"key\": true\n"
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
    public void testUpdateUser() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.users().updateUser("user-id", UserRepresentation.builder().build());
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
    public void testDeleteUser() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.users().deleteUser("user-id");
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("DELETE", request.getMethod());
    }

    @Test
    public void testSendActionEmail() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.users()
                .sendActionEmail(
                        "user-id",
                        SendActionEmailRequest.builder()
                                .body(Arrays.asList("string"))
                                .clientId("client_id")
                                .lifespan(1)
                                .redirectUri("redirect_uri")
                                .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PUT", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "[\n" + "  \"string\"\n" + "]";
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
    public void testImpersonateUser() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{\"key\":\"value\"}"));
        Map<String, Object> response = client.users().impersonateUser("user-id");
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = "" + "{\n" + "  \"key\": \"value\"\n" + "}";
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
    public void testRemoveUserSessions() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.users().removeUserSessions("user-id");
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
    }

    @Test
    public void testSendVerifyEmail() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.users()
                .sendVerifyEmail(
                        "user-id",
                        SendVerifyEmailRequest.builder()
                                .clientId("client_id")
                                .lifespan(1)
                                .redirectUri("redirect_uri")
                                .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PUT", request.getMethod());
    }

    @Test
    public void testGetUserSessions() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "[{\"id\":\"id\",\"username\":\"username\",\"userId\":\"userId\",\"ipAddress\":\"ipAddress\",\"start\":1000000,\"lastAccess\":1000000,\"rememberMe\":true,\"clients\":{\"key\":\"value\"},\"transientUser\":true}]"));
        List<UserSessionRepresentation> response = client.users().getUserSessions("user-id");
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
                + "    \"username\": \"username\",\n"
                + "    \"userId\": \"userId\",\n"
                + "    \"ipAddress\": \"ipAddress\",\n"
                + "    \"start\": 1000000,\n"
                + "    \"lastAccess\": 1000000,\n"
                + "    \"rememberMe\": true,\n"
                + "    \"clients\": {\n"
                + "      \"key\": \"value\"\n"
                + "    },\n"
                + "    \"transientUser\": true\n"
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
    public void testGetUserOrganizations() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "[{\"id\":\"id\",\"name\":\"name\",\"displayName\":\"displayName\",\"url\":\"url\",\"realm\":\"realm\",\"domains\":[\"domains\"],\"attributes\":{\"key\":[\"value\"]}}]"));
        List<OrganizationRepresentation> response = client.users().getUserOrganizations("userId");
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
                + "    \"displayName\": \"displayName\",\n"
                + "    \"url\": \"url\",\n"
                + "    \"realm\": \"realm\",\n"
                + "    \"domains\": [\n"
                + "      \"domains\"\n"
                + "    ],\n"
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
    public void testCreateMagicLink() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.users()
                .createMagicLink(MagicLinkRequest.builder()
                        .email("email")
                        .clientId("client_id")
                        .redirectUri("redirect_uri")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"email\": \"email\",\n"
                + "  \"client_id\": \"client_id\",\n"
                + "  \"redirect_uri\": \"redirect_uri\"\n"
                + "}";
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
    public void testGetUsers() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "[{\"organizations\":[\"organizations\"],\"id\":\"id\",\"username\":\"username\",\"firstName\":\"firstName\",\"lastName\":\"lastName\",\"email\":\"email\",\"emailVerified\":true,\"attributes\":{\"key\":[\"value\"]},\"userProfileMetadata\":{\"attributes\":[{}],\"groups\":[{}]},\"enabled\":true,\"self\":\"self\",\"origin\":\"origin\",\"createdTimestamp\":1000000,\"totp\":true,\"federationLink\":\"federationLink\",\"serviceAccountClientId\":\"serviceAccountClientId\",\"credentials\":[{}],\"disableableCredentialTypes\":[\"disableableCredentialTypes\"],\"requiredActions\":[\"requiredActions\"],\"federatedIdentities\":[{}],\"realmRoles\":[\"realmRoles\"],\"clientRoles\":{\"key\":[\"value\"]},\"clientConsents\":[{}],\"notBefore\":1,\"groups\":[\"groups\"],\"access\":{\"key\":true}}]"));
        List<UserRepresentation> response = client.users()
                .getUsers(GetAdminRealmsRealmExtAdminUsersRequest.builder()
                        .briefRepresentation(true)
                        .email("email")
                        .emailVerified(true)
                        .enabled(true)
                        .exact(true)
                        .first(1)
                        .firstName("firstName")
                        .idpAlias("idpAlias")
                        .idpUserId("idpUserId")
                        .lastName("lastName")
                        .max(1)
                        .q("q")
                        .search("search")
                        .username("username")
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
