namespace java multi

struct EchoRequest {
    1: optional string message
}

struct EchoResponse {
    1: optional string message
}

// public interface for clients
service Echo {
 EchoResponse echo(1: EchoRequest request)
}

// private interface for intra-service communication
service ExtendedEcho {
 EchoResponse echo(1: EchoRequest request)
 EchoResponse somethingElse(1: EchoRequest request)
}
