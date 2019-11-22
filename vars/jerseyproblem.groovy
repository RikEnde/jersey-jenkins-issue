import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.client.Invocation
import javax.ws.rs.client.WebTarget

@Grapes(
    [
        @Grab(group = "javax.ws.rs", module = "javax.ws.rs-api", version = "2.0.1"),
        @Grab(group = "org.glassfish.jersey.media", module = "jersey-media-json-jackson", version = "2.25.1"),
        @Grab(group = "org.glassfish.jersey.core", module = "jersey-client", version = "2.25.1"),
        @Grab(group = "com.fasterxml.jackson.datatype", module = "jackson-datatype-jsr310", version = "2.8.4")
    ]
)

void call(Map<String, String> args) {
  Greeting result = get("/hello", Greeting.class)

  println("Result of jersey client call: ${result} ${result.getClass()}")
}

static <T> T get(String path, Class<T> ret) {
  WebTarget webTarget = ClientBuilder.newBuilder()
      .build()
      .target("http://localhost:9999/")
      .path(path);

  Invocation.Builder request = webTarget.request()
  return request.get().readEntity(ret)
}

class Greeting {
  String hello;

  String toString() { "hello:${hello}" }
}

//call()
