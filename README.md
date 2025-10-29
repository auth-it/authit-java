# Phasetwo Java Library

[![fern shield](https://img.shields.io/badge/%F0%9F%8C%BF-Built%20with%20Fern-brightgreen)](https://buildwithfern.com?utm_source=github&utm_medium=github&utm_campaign=readme&utm_source=https%3A%2F%2Fgithub.com%2Fauth-it%2Fauthit-java)
[![Maven Central](https://img.shields.io/maven-central/v/it.auth/authit-java)](https://central.sonatype.com/artifact/it.auth/authit-java)

The Phasetwo Java library provides convenient access to the Phasetwo APIs from Java.

## Installation

### Gradle

Add the dependency in your `build.gradle` file:

```groovy
dependencies {
  implementation 'it.auth:authit-java'
}
```

### Maven

Add the dependency in your `pom.xml` file:

```xml
<dependency>
  <groupId>it.auth</groupId>
  <artifactId>authit-java</artifactId>
  <version>0.0.17</version>
</dependency>
```

## Reference

A full reference for this library is available [here](https://github.com/auth-it/authit-java/blob/HEAD/./reference.md).

## Usage

Instantiate and use the client with the following:

```java
package com.example.usage;

import it.auth.api.AuthItClient;
import it.auth.api.types.AuditEventRepresentation;

public class Example {
    public static void main(String[] args) {
        AuthItClient client = AuthItClient
            .builder()
            .clientId("<clientId>")
            .clientSecret("<clientSecret>")
            .realm("YOUR_REALM")
            .build();

        client.events().createEvent(
            AuditEventRepresentation
                .builder()
                .build()
        );
    }
}
```

## Environments

This SDK allows you to configure different environments for API requests.

```java
import it.auth.api.AuthItClient;
import it.auth.api.core.Environment;

AuthItClient client = AuthItClient
    .builder()
    .environment(Environment.Default)
    .build();
```

## Base Url

You can set a custom base URL when constructing the client.

```java
import it.auth.api.AuthItClient;

AuthItClient client = AuthItClient
    .builder()
    .url("https://example.com")
    .build();
```

## Exception Handling

When the API returns a non-success status code (4xx or 5xx response), an API exception will be thrown.

```java
import it.auth.api.core.AuthItApiException;

try{
    client.events().createEvent(...);
} catch (AuthItApiException e){
    // Do something with the API exception...
}
```

## Advanced

### Custom Client

This SDK is built to work with any instance of `OkHttpClient`. By default, if no client is provided, the SDK will construct one.
However, you can pass your own client like so:

```java
import it.auth.api.AuthItClient;
import okhttp3.OkHttpClient;

OkHttpClient customClient = ...;

AuthItClient client = AuthItClient
    .builder()
    .httpClient(customClient)
    .build();
```

### Retries

The SDK is instrumented with automatic retries with exponential backoff. A request will be retried as long
as the request is deemed retryable and the number of retry attempts has not grown larger than the configured
retry limit (default: 2). Before defaulting to exponential backoff, the SDK will first attempt to respect
the `Retry-After` header (as either in seconds or as an HTTP date), and then the `X-RateLimit-Reset` header
(as a Unix timestamp in epoch seconds); failing both of those, it will fall back to exponential backoff.

A request is deemed retryable when any of the following HTTP status codes is returned:

- [408](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/408) (Timeout)
- [429](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/429) (Too Many Requests)
- [5XX](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/500) (Internal Server Errors)

Use the `maxRetries` client option to configure this behavior.

```java
import it.auth.api.AuthItClient;

AuthItClient client = AuthItClient
    .builder()
    .maxRetries(1)
    .build();
```

### Timeouts

The SDK defaults to a 60 second timeout. You can configure this with a timeout option at the client or request level.

```java
import it.auth.api.AuthItClient;
import it.auth.api.core.RequestOptions;

// Client level
AuthItClient client = AuthItClient
    .builder()
    .timeout(10)
    .build();

// Request level
client.events().createEvent(
    ...,
    RequestOptions
        .builder()
        .timeout(10)
        .build()
);
```

### Custom Headers

The SDK allows you to add custom headers to requests. You can configure headers at the client level or at the request level.

```java
import it.auth.api.AuthItClient;
import it.auth.api.core.RequestOptions;

// Client level
AuthItClient client = AuthItClient
    .builder()
    .addHeader("X-Custom-Header", "custom-value")
    .addHeader("X-Request-Id", "abc-123")
    .build();
;

// Request level
client.events().createEvent(
    ...,
    RequestOptions
        .builder()
        .addHeader("X-Request-Header", "request-value")
        .build()
);
```

### Access Raw Response Data

The SDK provides access to raw response data, including headers, through the `withRawResponse()` method.
The `withRawResponse()` method returns a raw client that wraps all responses with `body()` and `headers()` methods.
(A normal client's `response` is identical to a raw client's `response.body()`.)

```java
CreateEventHttpResponse response = client.events().withRawResponse().createEvent(...);

System.out.println(response.body());
System.out.println(response.headers().get("X-My-Header"));
```

## Contributing

While we value open-source contributions to this SDK, this library is generated programmatically.
Additions made directly to this library would have to be moved over to our generation code,
otherwise they would be overwritten upon the next generated release. Feel free to open a PR as
a proof of concept, but know that we will not be able to merge it as-is. We suggest opening
an issue first to discuss with us!

On the other hand, contributions to the README are always very welcome!