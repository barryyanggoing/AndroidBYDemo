package com.barryyang.designmode.interceptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MediaPlayerSetting {

    private static MediaPlayerSetting instance;
    private final List<DefaultInterceptor> interceptors;

    public MediaPlayerSetting(Builder builder) {
        interceptors = Collections.unmodifiableList(new ArrayList<>(builder.interceptors));
    }

    public List<DefaultInterceptor> getPrePlayInterceptors() {
        return new ArrayList<>(interceptors);
    }

    public static MediaPlayerSetting getInstance() {
        return instance;
    }

    public static class Builder {

        private final List<DefaultInterceptor> interceptors = new ArrayList<>();

        public Builder addPrePlayInterceptor(DefaultInterceptor interceptor) {
            if (interceptor != null) {
                this.interceptors.add(interceptor);
            }
            return this;
        }

        public MediaPlayerSetting build() {
            instance = new MediaPlayerSetting(this);
            return instance;
        }
    }

}
