package izhengmy.springboot.about.response;

import lombok.Builder;

@Builder
public record AboutResponse(String app, String environment) {
}
