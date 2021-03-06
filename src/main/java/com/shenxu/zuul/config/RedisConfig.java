package com.shenxu.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author ly
 * @date 2020/8/12 16:53
 */

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new StringRedisSerializer());
        return template;
    }

    public class RedisObjectSerializer implements RedisSerializer<Object> {

        private Converter<Object, byte[]> serializer = new SerializingConverter();
        private Converter<byte[], Object> deserializer = new DeserializingConverter();
        final byte[] EMPTY_ARRAY = new byte[0];

        @Override
        public Object deserialize(byte[] bytes) {
            if (isEmpty(bytes)) {
                return null;
            }
            try {
                return deserializer.convert(bytes);
            } catch (Exception ex) {
                throw new SerializationException("Cannot deserialize", ex);
            }
        }

        @Override
        public byte[] serialize(Object object) {
            if (object == null) {
                return EMPTY_ARRAY;
            }
            try {
                return serializer.convert(object);
            } catch (Exception ex) {
                return EMPTY_ARRAY;
            }
        }

        private boolean isEmpty(byte[] data) {
            return (data == null || data.length == 0);
        }
    }
}
