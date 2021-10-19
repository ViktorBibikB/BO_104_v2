package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utils.Managers.PropertiesManager;

public class SpecBuilder {
    protected static final String API_HOSTNAME = PropertiesManager.getProperty("cabinet.api.host");
    protected static final String API_KEY = PropertiesManager.getProperty("api.key");

    private RequestSpecBuilder baseSpecBuild;

    private SpecBuilder() {
        baseSpecBuild = new RequestSpecBuilder()
                .setBaseUri(API_HOSTNAME + "/billing/api/");
    }

    public static Builder newBuilder() {

        return new SpecBuilder().new Builder();
    }

    public static Builder newBuilder(RequestSpecification requestSpecification) {
        return new SpecBuilder().new Builder(requestSpecification);
    }

    public class Builder {

        private Builder() {}

        private Builder(RequestSpecification existingSpec) {

            baseSpecBuild.addRequestSpecification(existingSpec);
        }

        public Builder addApiKey() {
            baseSpecBuild.addHeader("X-Application-Key", API_KEY);
            return this;
        }

        public Builder addMethodName(String methodName) {
            baseSpecBuild.addHeader("X-Http-Method", methodName);
            return this;
        }

        public Builder addSessionId(String sessionId) {
            baseSpecBuild.addHeader("X-Session-Id", sessionId);
            return this;
        }

        public RequestSpecification build() {

            return baseSpecBuild.build();
        }

    }
}
