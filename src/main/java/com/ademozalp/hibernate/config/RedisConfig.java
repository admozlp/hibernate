package com.ademozalp.hibernate.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {
    //@Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        return new LettuceConnectionFactory("localhost", 6379);
//    }
//
//    //@Bean
//    public RedisTemplate<String, Object> redisTemplate() {
//        final RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new GenericToStringSerializer<>(Object.class));
//        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
////        redisTemplate.setValueSerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
//
//        redisTemplate.setConnectionFactory(redisConnectionFactory());
//
//        return redisTemplate;
//    }
//
//    //@Bean(value = "cacheManager")
//    public CacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {
//        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
//                .entryTtl(Duration.ofHours(1))
//                .disableCachingNullValues()
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json()));
//
//        redisCacheConfiguration.usePrefix();
//
//        return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(redisConnectionFactory)
//                .cacheDefaults(redisCacheConfiguration).build();
//    }

}
