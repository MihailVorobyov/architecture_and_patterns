package ru.geekbrains.domain;

import java.util.Map;

public class HttpRequest {

    private String method;
    private String url;
    private Map<String, String> headers;
    private String body;

    private HttpRequest() {
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }
    
    public static Builder createBuilder() {
        return new Builder();
    }

    public static class Builder {
        
        private final HttpRequest httpRequest;
        
        private Builder() {
            this.httpRequest = new HttpRequest();
        }
        
        public Builder withMethod(String method) {
            this.httpRequest.method = method;
            return this;
        }
    
        public Builder withUrl(String url) {
            this.httpRequest.url = url;
            return this;
        }
    
        public Builder withHeaders(Map<String, String> headers) {
            this.httpRequest.headers = headers;
            return this;
        }
    
        public Builder withBody(String body) {
            this.httpRequest.body = body;
            return this;
        }
        
        public HttpRequest build() {
            if (this.httpRequest.method == null
            && this.httpRequest.url == null
            && this.httpRequest.headers == null
            && this.httpRequest.body == null) {
                throw new IllegalStateException("Wrong HttpRequest arameters!");
            }
            return this.httpRequest;
        }
    }
    
    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", headers=" + headers +
                ", body='" + body + '\'' +
                '}';
    }
    
    
}
