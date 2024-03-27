/*
 * Copyright 2014 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License, version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package io.netty.handler.codec.mqtt;

/**
 * Mqtt 质量等级定义
 */
public enum MqttQoS {
    /**
     * 最多一次传递。这意味着消息可能会在传输过程中丢失，但绝不会被重复传递。
     */
    AT_MOST_ONCE(0),
    /**
     * 至少一次传递。确保消息至少会被传递一次，但可能会发生重复传递。
     */
    AT_LEAST_ONCE(1),
    /**
     * 恰好一次传递。最高的 QoS 等级，确保消息在传输过程中既不会丢失也不会重复。
     */
    EXACTLY_ONCE(2), FAILURE(0x80);

    private final int value;

    MqttQoS(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static MqttQoS valueOf(int value) {
        switch (value) {
            case 0:
                return AT_MOST_ONCE;
            case 1:
                return AT_LEAST_ONCE;
            case 2:
                return EXACTLY_ONCE;
            case 0x80:
                return FAILURE;
            default:
                throw new IllegalArgumentException("invalid QoS: " + value);
        }
    }
}
