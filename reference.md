# Reference
## Events
<details><summary><code>client.events.deleteAdminEvents(realm)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete all admin events in this realm.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.events().deleteAdminEvents("realm");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.events.deleteEvents(realm)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete all events in this realm.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.events().deleteEvents("realm");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.events.createEvent(realm, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create an custom audit log event.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.events().createEvent(
    "realm",
    AuditEventRepresentation
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**id:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**uid:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**time:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**realmId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**realmName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**organizationId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**type:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**representation:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**operationType:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**resourcePath:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**resourceType:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**error:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**authDetails:** `Optional<AuthDetailsRepresentation>` 
    
</dd>
</dl>

<dl>
<dd>

**details:** `Optional<Map<String, Object>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.events.getEvents(realm) -> List&lt;EventRepresentation&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get all events, or filters them based on URL query parameters.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.events().getEvents(
    "realm",
    GetEventsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**client:** `Optional<String>` — App or oauth client name
    
</dd>
</dl>

<dl>
<dd>

**dateFrom:** `Optional<String>` — From date
    
</dd>
</dl>

<dl>
<dd>

**dateTo:** `Optional<String>` — To date
    
</dd>
</dl>

<dl>
<dd>

**first:** `Optional<Integer>` — Paging offset
    
</dd>
</dl>

<dl>
<dd>

**ipAddress:** `Optional<String>` — IP Address
    
</dd>
</dl>

<dl>
<dd>

**max:** `Optional<Integer>` — Maximum results size (defaults to 100)
    
</dd>
</dl>

<dl>
<dd>

**type:** `Optional<String>` — The types of events to return
    
</dd>
</dl>

<dl>
<dd>

**user:** `Optional<String>` — User id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.events.getAdminEvents(realm) -> List&lt;AdminEventRepresentation&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get all admin events, or filters events based on URL query parameters.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.events().getAdminEvents(
    "realm",
    GetAdminEventsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**authClient:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**authIpAddress:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**authRealm:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**authUser:** `Optional<String>` — user id
    
</dd>
</dl>

<dl>
<dd>

**dateFrom:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**dateTo:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**first:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**max:** `Optional<Integer>` — Maximum results size (defaults to 100)
    
</dd>
</dl>

<dl>
<dd>

**operationTypes:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**resourcePath:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**resourceTypes:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Attack Detection
<details><summary><code>client.attackDetection.clearAllLoginFailures(realm)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Clear user login failures for all users. This can release temporarily disabled users.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.attackDetection().clearAllLoginFailures("realm");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.attackDetection.userLockoutStatus(realm, userId) -> Map&lt;String, Object&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get lockout status of a user in brute force detection.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.attackDetection().userLockoutStatus("realm", "userId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.attackDetection.clearUserLoginFailures(realm, userId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Clear any user login failures for the user. This can release a temporarily disabled user.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.attackDetection().clearUserLoginFailures("realm", "userId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Sessions
<details><summary><code>client.sessions.removeAllSessions(realm) -> GlobalRequestResult</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Remove all user sessions for this realm. Any client that has an admin URL will also be told to invalidate any sessions they have. For large numbers of sessions, this can take a long period to execute.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.sessions().removeAllSessions("realm");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.sessions.removeUserSession(realm, session)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Remove a specific user session. Any client that has an admin URL will also be told to invalidate this particular session.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.sessions().removeUserSession(
    "realm",
    "session",
    RemoveUserSessionRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**session:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**isOffline:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Roles
<details><summary><code>client.roles.getRoles(realm) -> List&lt;RoleRepresentation&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get all roles for the given realm or client.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.roles().getRoles(
    "realm",
    GetRolesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**briefRepresentation:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**first:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**max:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**search:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.roles.createRole(realm, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a new role for the realm or client.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.roles().createRole(
    "realm",
    RoleRepresentation
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**request:** `RoleRepresentation` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.roles.getRole(realm, roleName) -> RoleRepresentation</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a role by name.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.roles().getRole("realm", "role-name");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**roleName:** `String` — role's name (not id!)
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.roles.updateRole(realm, roleName, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update a role by name.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.roles().updateRole(
    "realm",
    "role-name",
    RoleRepresentation
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**roleName:** `String` — role's name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**request:** `RoleRepresentation` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.roles.deleteRole(realm, roleName)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete a role by name.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.roles().deleteRole("realm", "role-name");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**roleName:** `String` — role's name (not id!)
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.roles.getUsersByRole(realm, roleName) -> List&lt;UserRepresentation&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get users that have the specified role name assigned.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.roles().getUsersByRole(
    "realm",
    "role-name",
    GetUsersByRoleRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**roleName:** `String` — the role name.
    
</dd>
</dl>

<dl>
<dd>

**briefRepresentation:** `Optional<Boolean>` — Boolean which defines whether brief representations are returned (default: false)
    
</dd>
</dl>

<dl>
<dd>

**first:** `Optional<Integer>` — first result to return. Ignored if negative or {@code null}.
    
</dd>
</dl>

<dl>
<dd>

**max:** `Optional<Integer>` — maximum number of results to return. Ignored if negative or {@code null}.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Users
<details><summary><code>client.users.createUser(realm, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a new user. Username must be unique.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().createUser(
    "realm",
    UserRepresentation
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**request:** `UserRepresentation` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.countUsers(realm) -> Integer</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the number of users that match the given criteria.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().countUsers(
    "realm",
    CountUsersRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**email:** `Optional<String>` — email filter
    
</dd>
</dl>

<dl>
<dd>

**emailVerified:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**enabled:** `Optional<Boolean>` — Boolean representing if user is enabled or not
    
</dd>
</dl>

<dl>
<dd>

**firstName:** `Optional<String>` — first name filter
    
</dd>
</dl>

<dl>
<dd>

**lastName:** `Optional<String>` — last name filter
    
</dd>
</dl>

<dl>
<dd>

**q:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**search:** `Optional<String>` — arbitrary search string for all the fields below. Default search behavior is prefix-based (e.g., foo or foo*). Use *foo* for infix search and "foo" for exact search.
    
</dd>
</dl>

<dl>
<dd>

**username:** `Optional<String>` — username filter
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.getUser(realm, userId) -> UserRepresentation</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get representation of the user using the ID.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().getUser(
    "realm",
    "user-id",
    GetUserRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**userProfileMetadata:** `Optional<Boolean>` — Indicates if the user profile metadata should be added to the response
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.updateUser(realm, userId, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update the user using the ID.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().updateUser(
    "realm",
    "user-id",
    UserRepresentation
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**request:** `UserRepresentation` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.deleteUser(realm, userId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete the user using the ID.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().deleteUser("realm", "user-id");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.sendActionEmail(realm, userId, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Send an email to the user with a link they can click to execute particular actions.An email contains a link the user can click to perform a set of required actions. The redirectUri and clientId parameters are optional. If no redirect is given, then there will be no link back to click after actions have completed. Redirect uri must be a valid uri for the particular clientId.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().sendActionEmail(
    "realm",
    "user-id",
    SendActionEmailRequest
        .builder()
        .body(
            Arrays.asList("string")
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**clientId:** `Optional<String>` — Client id
    
</dd>
</dl>

<dl>
<dd>

**lifespan:** `Optional<Integer>` — Number of seconds after which the generated token expires
    
</dd>
</dl>

<dl>
<dd>

**redirectUri:** `Optional<String>` — Redirect uri
    
</dd>
</dl>

<dl>
<dd>

**request:** `List<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.impersonateUser(realm, userId) -> Map&lt;String, Object&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Impersonate the user. This will terminate any outstanding user sessions for this user, and log in to the account console.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().impersonateUser("realm", "user-id");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.removeUserSessions(realm, userId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Remove all user sessions associated with the user Also send notification to all clients that have an admin URL to invalidate the sessions for the particular user.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().removeUserSessions("realm", "user-id");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.sendVerifyEmail(realm, userId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Send an email-verification email to the user An email contains a link the user can click to verify their email address. The redirectUri, clientId and lifespan parameters are optional. The default for the redirect is the account client. The default for the lifespan is 12 hours
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().sendVerifyEmail(
    "realm",
    "user-id",
    SendVerifyEmailRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**clientId:** `Optional<String>` — Client id
    
</dd>
</dl>

<dl>
<dd>

**lifespan:** `Optional<Integer>` — Number of seconds after which the generated token expires
    
</dd>
</dl>

<dl>
<dd>

**redirectUri:** `Optional<String>` — Redirect uri
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.getUserSessions(realm, userId) -> List&lt;UserSessionRepresentation&gt;</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().getUserSessions("realm", "user-id");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.getUserOrganizations(realm, userId) -> List&lt;OrganizationRepresentation&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get organizations for the given user.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().getUserOrganizations("realm", "userId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` — user id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.createMagicLink(realm, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a magic link to log in a user.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().createMagicLink(
    "realm",
    MagicLinkRequest
        .builder()
        .email("email")
        .clientId("client_id")
        .redirectUri("redirect_uri")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**email:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**clientId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**redirectUri:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**expirationSeconds:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**forceCreate:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**sendEmail:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**updateProfile:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**updatePassword:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**scope:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**nonce:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**codeChallenge:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**codeChallengeMethod:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**rememberMe:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**reusable:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.users.getUsers(realm) -> List&lt;UserRepresentation&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a stream of users, filtered according to query parameters.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.users().getUsers(
    "realm",
    GetAdminRealmsRealmExtAdminUsersRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**briefRepresentation:** `Optional<Boolean>` — Boolean which defines whether brief representations are returned (default: false)
    
</dd>
</dl>

<dl>
<dd>

**email:** `Optional<String>` — A String contained in email, or the complete email, if param "exact" is true
    
</dd>
</dl>

<dl>
<dd>

**emailVerified:** `Optional<Boolean>` — whether the email has been verified
    
</dd>
</dl>

<dl>
<dd>

**enabled:** `Optional<Boolean>` — Boolean representing if user is enabled or not
    
</dd>
</dl>

<dl>
<dd>

**exact:** `Optional<Boolean>` — Boolean which defines whether the params "last", "first", "email" and "username" must match exactly
    
</dd>
</dl>

<dl>
<dd>

**first:** `Optional<Integer>` — Pagination offset
    
</dd>
</dl>

<dl>
<dd>

**firstName:** `Optional<String>` — A String contained in firstName, or the complete firstName, if param "exact" is true
    
</dd>
</dl>

<dl>
<dd>

**idpAlias:** `Optional<String>` — The alias of an Identity Provider linked to the user
    
</dd>
</dl>

<dl>
<dd>

**idpUserId:** `Optional<String>` — The userId at an Identity Provider linked to the user
    
</dd>
</dl>

<dl>
<dd>

**lastName:** `Optional<String>` — A String contained in lastName, or the complete lastName, if param "exact" is true
    
</dd>
</dl>

<dl>
<dd>

**max:** `Optional<Integer>` — Maximum results size (defaults to 100)
    
</dd>
</dl>

<dl>
<dd>

**q:** `Optional<String>` — A query to search for custom attributes, in the format 'key1:value2 key2:value2'
    
</dd>
</dl>

<dl>
<dd>

**search:** `Optional<String>` — A String contained in username, first or last name, or email. Default search behavior is prefix-based (e.g., foo or foo*). Use *foo* for infix search and "foo" for exact search.
    
</dd>
</dl>

<dl>
<dd>

**username:** `Optional<String>` — A String contained in username, or the complete username, if param "exact" is true
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Organizations
<details><summary><code>client.organizations.getOrganizations(realm) -> List&lt;OrganizationRepresentation&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a paginated list of organizations using optional search query parameters.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().getOrganizations(
    "realm",
    GetOrganizationsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**search:** `Optional<String>` — search by name
    
</dd>
</dl>

<dl>
<dd>

**first:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**max:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**q:** `Optional<String>` — search by attributes using the format (space separated) `k1:v1 k2:v2`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.createOrganization(realm, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a new organization from a representation. Must include name.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().createOrganization(
    "realm",
    OrganizationRepresentation
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**request:** `OrganizationRepresentation` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.getOrganizationsCount(realm) -> Integer</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a count of organizations using an optional search query.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().getOrganizationsCount(
    "realm",
    GetOrganizationsCountRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**search:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**q:** `Optional<String>` — search by attributes using the format (space separated) `k1:v1 k2:v2`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.getOrganization(realm, orgId) -> OrganizationRepresentation</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().getOrganization("realm", "orgId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.updateOrganization(realm, orgId, request)</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().updateOrganization(
    "realm",
    "orgId",
    OrganizationRepresentation
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>

<dl>
<dd>

**request:** `OrganizationRepresentation` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.deleteOrganization(realm, orgId)</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().deleteOrganization("realm", "orgId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.createPortalLink(realm, orgId, request) -> PortalLinkRepresentation</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a link for this organizations admin portal. This link encodes an action token on behalf of the organization's default admin user, or the user that is optionally specified in this request. The user specified must be a member of this organization, and have full organization admin roles.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().createPortalLink(
    "realm",
    "orgId",
    CreatePortalLinkRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>

<dl>
<dd>

**userId:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Webhooks
<details><summary><code>client.webhooks.getWebhooks(realm) -> List&lt;WebhookRepresentation&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a list of webhooks for this realm.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().getWebhooks(
    "realm",
    GetWebhooksRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**first:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**max:** `Optional<Integer>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.createWebhook(realm, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a webhook to send events to a URL.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().createWebhook(
    "realm",
    WebhookRepresentation
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**request:** `WebhookRepresentation` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.getWebhooksCount(realm) -> Integer</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a count of webhooks.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().getWebhooksCount("realm");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.getWebhook(realm, webhookId) -> WebhookRepresentation</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get details for a specific webhook.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().getWebhook("realm", "webhookId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**webhookId:** `String` — webhook id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.updateWebhook(realm, webhookId, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update details for a specific webhook.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().updateWebhook(
    "realm",
    "webhookId",
    WebhookRepresentation
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**webhookId:** `String` — webhook id
    
</dd>
</dl>

<dl>
<dd>

**request:** `WebhookRepresentation` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.deleteWebhook(realm, webhookId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete a webhook.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().deleteWebhook("realm", "webhookId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**webhookId:** `String` — webhook id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Auth
<details><summary><code>client.auth.getToken(realm, request) -> GetTokenResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Obtain an OAuth2 access token using client credentials
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.auth().getToken(
    "realm",
    AuthGetTokenRequest
        .builder()
        .clientId("client_id")
        .clientSecret("client_secret")
        .grantType("client_credentials")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**clientId:** `String` — The client ID of the application
    
</dd>
</dl>

<dl>
<dd>

**clientSecret:** `String` — The client secret of the application
    
</dd>
</dl>

<dl>
<dd>

**grantType:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**refreshToken:** `Optional<String>` — The refresh token (required for refresh_token grant type)
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Organizations Memberships
<details><summary><code>client.organizations.memberships.getMemberInfo(realm) -> Map&lt;String, MyOrganizationRepresentation&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a list of all organizations that the user is a member and their roles in those organizations. Similar idea to /userinfo in OIDC.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().memberships().getMemberInfo("realm");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.memberships.getMemberships(realm, orgId) -> List&lt;UserWithOrgsBriefRepresentation&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a paginated list of users who are a member of the specified organization.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().memberships().getMemberships(
    "realm",
    "orgId",
    MembershipsGetMembershipsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>

<dl>
<dd>

**search:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**first:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**max:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**excludeAdminAccounts:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**includeOrgs:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.memberships.countMemberships(realm, orgId) -> Integer</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get total number of members of a given organization.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().memberships().countMemberships(
    "realm",
    "orgId",
    MembershipsCountMembershipsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>

<dl>
<dd>

**excludeAdminAccounts:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.memberships.isMember(realm, orgId, userId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Check if a user is a member of an organization
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().memberships().isMember("realm", "orgId", "userId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` — user id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.memberships.addMember(realm, orgId, userId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Add the specified user to the specified organization as a member.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().memberships().addMember("realm", "orgId", "userId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` — user id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.memberships.removeMember(realm, orgId, userId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Remove the specified user from the specified organization as a member.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().memberships().removeMember("realm", "orgId", "userId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` — user id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Organizations Invitations
<details><summary><code>client.organizations.invitations.getInvitations(realm, orgId) -> List&lt;InvitationRepresentation&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a paginated list of invitations to an organization, using an optional search query for email address.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().invitations().getInvitations(
    "realm",
    "orgId",
    InvitationsGetInvitationsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>

<dl>
<dd>

**search:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**first:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**max:** `Optional<Integer>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.invitations.acceptInvitation(realm, invitationId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Accept invitation for the authenticated user. The token provided must be for the authenticated user rather than an administrator or service account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().invitations().acceptInvitation("realm", "invitationId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**invitationId:** `String` — invitation UUID
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.invitations.rejectInvitation(realm, invitationId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Reject invitation for the authenticated user. The token provided must be for the authenticated user rather than an administrator or service account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().invitations().rejectInvitation("realm", "invitationId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**invitationId:** `String` — invitation UUID
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.invitations.invite(realm, orgId, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create an invitation to an organization.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().invitations().invite(
    "realm",
    "orgId",
    InvitationRequestRepresentation
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>

<dl>
<dd>

**email:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**send:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**inviterId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**redirectUri:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**roles:** `Optional<List<String>>` 
    
</dd>
</dl>

<dl>
<dd>

**attributes:** `Optional<Map<String, List<String>>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.invitations.getInvitationsCount(realm, orgId) -> Integer</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a count of invitations to an organization.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().invitations().getInvitationsCount("realm", "orgId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.invitations.getInvitation(realm, orgId, invitationId) -> InvitationRepresentation</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get an invitation to an organization.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().invitations().getInvitation("realm", "orgId", "invitationId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>

<dl>
<dd>

**invitationId:** `String` — invitation id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.invitations.removeInvitation(realm, orgId, invitationId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Remove a pending invitation to an organization.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().invitations().removeInvitation("realm", "orgId", "invitationId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>

<dl>
<dd>

**invitationId:** `String` — invitation id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.invitations.resendInvitation(realm, orgId, invitationId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Resend the email for an existing organization invitation.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().invitations().resendInvitation("realm", "orgId", "invitationId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>

<dl>
<dd>

**invitationId:** `String` — invitation id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Organizations Domains
<details><summary><code>client.organizations.domains.getDomains(realm, orgId) -> List&lt;OrganizationDomainRepresentation&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get details for all domains owned by an organization.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().domains().getDomains("realm", "orgId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.domains.getDomain(realm, orgId, domainName) -> OrganizationDomainRepresentation</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get details for a domain owned by an organization.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().domains().getDomain("realm", "orgId", "domainName");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>

<dl>
<dd>

**domainName:** `String` — domain name
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.domains.verifyDomain(realm, orgId, domainName)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Initiate a verification check for the domain name owned by this organization.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().domains().verifyDomain("realm", "orgId", "domainName");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>

<dl>
<dd>

**domainName:** `String` — domain name
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Organizations Roles
<details><summary><code>client.organizations.roles.getOrganizationRoles(realm, orgId) -> List&lt;OrganizationRoleRepresentation&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a list of roles for this organization.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().roles().getOrganizationRoles("realm", "orgId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.roles.createOrganizationRole(realm, orgId, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a new role for this organization.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().roles().createOrganizationRole(
    "realm",
    "orgId",
    OrganizationRoleRepresentation
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>

<dl>
<dd>

**request:** `OrganizationRoleRepresentation` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.roles.getRole(realm, orgId, name) -> OrganizationRoleRepresentation</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get role for this organization by name.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().roles().getRole("realm", "orgId", "name");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — organization role name
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.roles.updateRole(realm, orgId, name, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update role for this organization.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().roles().updateRole(
    "realm",
    "orgId",
    "name",
    OrganizationRoleRepresentation
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — organization role name
    
</dd>
</dl>

<dl>
<dd>

**request:** `OrganizationRoleRepresentation` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.roles.deleteRole(realm, orgId, name)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete role for this organization
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().roles().deleteRole("realm", "orgId", "name");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — organization role name
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.roles.getUserOrganizationRoles(realm, orgId, name) -> List&lt;UserRepresentation&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get users with this organization role.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().roles().getUserOrganizationRoles("realm", "orgId", "name");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — organization role name
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.roles.hasOrganizationRole(realm, orgId, name, userId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Check if a user has an organization role.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().roles().hasOrganizationRole("realm", "orgId", "name", "userId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — organization role name
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` — user id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.roles.grantOrganizationRole(realm, orgId, name, userId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Grant the specified user to the specified organization role.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().roles().grantOrganizationRole("realm", "orgId", "name", "userId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — organization role name
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` — user id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.roles.revokeOrganizationRole(realm, orgId, name, userId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Revoke the specified organization role from the specified user.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().roles().revokeOrganizationRole("realm", "orgId", "name", "userId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — organization role name
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` — user id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.organizations.roles.listOrganizationRoles(realm, userId, orgId) -> List&lt;OrganizationRoleRepresentation&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get organization roles for the given user and organization.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.organizations().roles().listOrganizationRoles("realm", "userId", "orgId");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` — user id
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `String` — organization id
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Roles Mappings
<details><summary><code>client.roles.mappings.getRoleMappings(realm, userId) -> List&lt;RoleRepresentation&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get roles that have been mapped to this user.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.roles().mappings().getRoleMappings("realm", "user-id");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.roles.mappings.addRoleMappings(realm, userId, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Add roles to this user.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.roles().mappings().addRoleMappings(
    "realm",
    "user-id",
    Arrays.asList(
        RoleRepresentation
            .builder()
            .build()
    )
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**request:** `List<RoleRepresentation>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.roles.mappings.deleteRoleMappings(realm, userId, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete roles for this user.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.roles().mappings().deleteRoleMappings(
    "realm",
    "user-id",
    Arrays.asList(
        RoleRepresentation
            .builder()
            .build()
    )
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**request:** `List<RoleRepresentation>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.roles.mappings.getAvailableRoles(realm, userId) -> List&lt;RoleRepresentation&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get roles that can be mapped to this user.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.roles().mappings().getAvailableRoles("realm", "user-id");
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**realm:** `String` — realm name (not id!)
    
</dd>
</dl>

<dl>
<dd>

**userId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>
