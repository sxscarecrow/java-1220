package com.shenxu.zuul.util;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author ly
 * @date 2020/8/12 17:03
 */

@Component
@Log4j2
public class RedisCacheComponent {

    @Autowired(required = false)
    private StringRedisTemplate redisTemplate;
    private String keyPreRule = null;

    private HashOperations<String, String, String> ops;

    public RedisCacheComponent() {
    }

    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.ops = this.redisTemplate.opsForHash();
    }

    public boolean isShareCache() {
        return true;
    }

    public boolean del(String... keys) {
        if (keys != null && keys.length != 0) {
            boolean ret = true;
            String[] arr$ = keys;
            int len$ = keys.length;
            for (int i$ = 0; i$ < len$; ++i$) {
                String key = arr$[i$];
                if (!this.isValidKey(key)) {
                    ret = false;
                    break;
                }
                if (StringUtils.isBlank(key)) {
                    continue;
                }
                this.redisTemplate.delete(key);
            }

            return ret;
        } else {
            return true;
        }
    }

    public Set<String> getKeys(String pattern) {
        return this.redisTemplate.keys(pattern);
    }

    public boolean isExists(String key) {
        boolean isExists = false;
        return !this.isValidKey(key) ? isExists : this.redisTemplate.hasKey(key);
    }

    public boolean set(String key, Object value) {
        if (!this.isValidKey(key)) {
            return false;
        } else {
            if (value instanceof String) {
                this.redisTemplate.opsForValue().set(key, value.toString());
            } else {
                String objectJson = JsonUtils.toJsonString(value);
                this.redisTemplate.opsForValue().set(key, objectJson);
            }

            return true;
        }
    }

    public boolean setnx(String key, Object value) {
        if (!this.isValidKey(key)) {
            return false;
        } else {
            String objectJson = JsonUtils.toJsonString(value);
            return this.redisTemplate.opsForValue().setIfAbsent(key, objectJson);
        }
    }

    public boolean set(String key, Object value, int secs) {
        if (!this.isValidKey(key)) {
            return false;
        } else {
            if (value instanceof String) {
                this.redisTemplate.opsForValue().set(key, value.toString(), (long) secs, TimeUnit.SECONDS);
            } else {
                String objectJson = JsonUtils.toJsonString(value);
                this.redisTemplate.opsForValue().set(key, objectJson, (long) secs, TimeUnit.SECONDS);
            }
            return true;
        }
    }

    public boolean setBit(String key, long offset, boolean value) {
        return this.redisTemplate.opsForValue().setBit(key, offset, value);
    }

    public boolean getBit(String key, long offset) {
        return this.redisTemplate.opsForValue().getBit(key, offset);
    }


    public boolean mset(Map<String, Object> map) {
        if (map != null && !map.isEmpty()) {
            Map<String, String> mapTmp = new HashMap<>();
            Iterator i$ = map.entrySet().iterator();

            while (i$.hasNext()) {
                Map.Entry<String, Object> mm = (Map.Entry) i$.next();
                String key = (String) mm.getKey();
                if (this.isValidKey(key)) {
                    String objectJson = JsonUtils.toJsonString(mm.getValue());
                    mapTmp.put(key, objectJson);
                }
            }

            if (mapTmp != null && !mapTmp.isEmpty()) {
                this.redisTemplate.opsForValue().multiSet(mapTmp);
                mapTmp.clear();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Long getLong(String key) {
        Long value = 0L;
        String str = this.get(key);
        if (StringUtils.isNumeric(str)) {
            value = Long.parseLong(str);
        }
        return value;
    }

    public <T> T get(String key, Class<T> clazz) {
        if (!this.isValidKey(key)) {
            return null;
        } else {
            String value = this.redisTemplate.opsForValue().get(key);
            return this.convertObjs(value, clazz);
        }
    }

    public String get(String key) {
        return this.redisTemplate.opsForValue().get(key);
    }

    public boolean exists(String key) {
        return this.redisTemplate.hasKey(key);
    }

    public String getSet(String key, String value) {
        return this.redisTemplate.opsForValue().getAndSet(key, value);
    }

    public Long decrBy(String key, long value) {
        return this.redisTemplate.opsForValue().increment(key, -value);
    }

    public Long decr(String key) {
        return this.redisTemplate.opsForValue().increment(key, -1L);
    }

    public Long incrBy(String key, long value) {
        return this.redisTemplate.opsForValue().increment(key, value);
    }

    public Double incrByFloat(String key, double value) {
        return this.redisTemplate.opsForValue().increment(key, value);
    }

    public Long incr(String key) {
        return this.redisTemplate.opsForValue().increment(key, 1L);
    }

    public Long incrForToday(String key) {
        Long ret = this.redisTemplate.opsForValue().increment(key, 1L);
        if (ret != null && ret == 1L) {
            Date time = DateTime.now().plusDays(1).withTimeAtStartOfDay().toDate();
            this.redisTemplate.expireAt(key, time);
        }

        return ret;
    }

    public Long append(String key, String value) {
        return this.redisTemplate.opsForValue().append(key, value).longValue();
    }

    public String substr(String key, int start, int end) {
        return this.redisTemplate.opsForValue().get(key).substring(start, end);
    }

    public boolean hset(String key, String field, Object value) {
        HashOperations<String, String, String> ops = this.redisTemplate.opsForHash();
        String objectJson = this.convertObjs(value);
        ops.put(key, field, objectJson);
        return true;
    }

    public <T> T hget(String key, String field) {
        return (T) this.redisTemplate.opsForHash().get(key, field);
    }

    public <T> T hget(String key, String field, Class<T> clazz) {
        if (ops == null) {
            this.ops = this.redisTemplate.opsForHash();
        }
        return this.convertObjs(ops.get(key, field), clazz);
    }

    public boolean hsetnx(String key, String field, Object value) {
        return this.redisTemplate.opsForHash().putIfAbsent(key, field, this.convertObjs(value));
    }

    public boolean hmset(String key, Map<String, Object> hash) {
        Map<String, String> map = new HashMap();
        Iterator i$ = hash.entrySet().iterator();

        while (i$.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry) i$.next();
            map.put(entry.getKey(), this.convertObjs(entry.getValue()));
        }

        this.redisTemplate.opsForHash().putAll(key, map);
        return true;
    }

    public List<String> hmget(String key, String... fields) {
        Collection<String> hashKeys = Arrays.asList(fields);
        HashOperations<String, String, String> ops = this.redisTemplate.opsForHash();
        return ops.multiGet(key, hashKeys);
    }

    public <T> List<T> hmget(String key, Class<T> clazz, String... fields) {
        List<String> list = this.hmget(key, fields);
        if (list != null && !list.isEmpty()) {
            List<T> retList = new ArrayList();
            Iterator i$ = list.iterator();

            while (i$.hasNext()) {
                String value = (String) i$.next();
                retList.add(this.convertObjs(value, clazz));
            }

            return retList;
        } else {
            return new ArrayList();
        }
    }

    public Long hincrBy(String key, String field, long value) {
        return this.redisTemplate.opsForHash().increment(key, field, value);
    }

    public Double hincrByDouble(String key, String field, double value) {
        return this.redisTemplate.opsForHash().increment(key, field, value);
    }

    public Long hincrByForTime(String key, String field, long value, long timeout) {
        boolean hasKey = this.redisTemplate.opsForHash().hasKey(key, field);
        Long ret = this.redisTemplate.opsForHash().increment(key, field, value);
        if (!hasKey) {
            this.redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
        }
        return ret;
    }

    public boolean hexists(String key, String field) {
        return this.redisTemplate.opsForHash().hasKey(key, field);
    }

    public void hdel(String key, String... field) {
        HashOperations<String, String, Object> ops = this.redisTemplate.opsForHash();
        ops.delete(key, field);
    }

    public Long hlen(String key) {
        return this.redisTemplate.opsForHash().size(key);
    }

    public Long llen(String key) {
        return this.redisTemplate.opsForList().size(key);
    }

    public Set<String> hkeys(String key) {
        HashOperations<String, String, String> ops = this.redisTemplate.opsForHash();
        return ops.keys(key);
    }

    public List<String> hvals(String key) {
        HashOperations<String, String, String> ops = this.redisTemplate.opsForHash();
        return ops.values(key);
    }

    public Map<String, String> hgetAll(String key) {
        HashOperations<String, String, String> ops = this.redisTemplate.opsForHash();
        return ops.entries(key);
    }

    public <T> Map<String, T> hgetAll(String key, Class<T> clazz) {
        HashOperations<String, String, String> ops = this.redisTemplate.opsForHash();
        Map<String, String> map = ops.entries(key);
        Map<String, T> retMap = new HashMap();
        Iterator i$ = map.entrySet().iterator();

        while (i$.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry) i$.next();
            retMap.put(entry.getKey(), this.convertObjs((String) entry.getValue(), clazz));
        }
        return retMap;
    }

    private boolean isValidKey(String key) {
        if (StringUtils.isEmpty(this.keyPreRule)) {
            return true;
        } else {
            boolean result = key.startsWith(this.keyPreRule);
            log.error("[Jedis]invalid key:" + key);
            return result;
        }
    }

    public String getKeyPreRule() {
        return this.keyPreRule;
    }

    public void setKeyPreRule(String keyPreRule) {
        this.keyPreRule = keyPreRule;
    }

    public Long sadd(String key, Object... values) {
        if (values != null && values.length != 0) {
            String[] strs = new String[values.length];

            for (int i = 0; i < values.length; ++i) {
                Object value = values[i];
                if (value != null) {
                    strs[i] = this.convertObjs(value);
                }
            }
            return this.redisTemplate.opsForSet().add(key, strs);
        } else {
            return 0L;
        }
    }

    public Long srem(String key, Object... values) {
        if (values != null && values.length != 0) {
            Object[] strs = new Object[values.length];

            for (int i = 0; i < values.length; ++i) {
                Object value = values[i];
                if (value != null) {
                    strs[i] = this.convertObjs(value);
                }
            }

            return this.redisTemplate.opsForSet().remove(key, strs);
        } else {
            return 0L;
        }
    }

    public String spop(String key) {
        return this.redisTemplate.opsForSet().pop(key);
    }

    public <T> T spop(String key, Class<T> clazz) {
        String value = this.spop(key);
        return this.convertObjs(value, clazz);
    }

    public Set<String> smembers(String key) {
        return this.redisTemplate.opsForSet().members(key);
    }

    public boolean sismembers(String key, Object members) {
        return this.redisTemplate.opsForSet().isMember(key, members);
    }

    public <T> Set<T> smembers(String key, Class<T> clazz) {
        Set<String> set = this.redisTemplate.opsForSet().members(key);
        Set<T> ret = new HashSet();
        Iterator i$ = set.iterator();

        while (i$.hasNext()) {
            String value = (String) i$.next();
            ret.add(this.convertObjs(value, clazz));
        }
        return ret;
    }

    public List<String> srandmember(String key, Long count) {
        List<String> ret = new ArrayList();
        if (count != null && count != 0L) {
            if (count < 0L) {
                ret.addAll(this.redisTemplate.opsForSet().randomMembers(key, Math.abs(count)));
            } else {
                ret.addAll(this.redisTemplate.opsForSet().distinctRandomMembers(key, count));
            }

            return ret;
        } else {
            ret.add(this.redisTemplate.opsForSet().randomMember(key));
            return ret;
        }
    }

    public <T> List<T> srandmember(String key, Long count, Class<T> clazz) {
        List<T> ret = new ArrayList();
        if (count != null && count != 0L) {
            Iterator i$;
            String value;
            if (count < 0L) {
                List<String> set = this.redisTemplate.opsForSet().randomMembers(key, Math.abs(count));
                i$ = set.iterator();

                while (i$.hasNext()) {
                    value = (String) i$.next();
                    ret.add(this.convertObjs(value, clazz));
                }
            } else {
                Set<String> set = this.redisTemplate.opsForSet().distinctRandomMembers(key, count);
                i$ = set.iterator();

                while (i$.hasNext()) {
                    value = (String) i$.next();
                    ret.add(this.convertObjs(value, clazz));
                }
            }

            return ret;
        } else {
            String value = (String) this.redisTemplate.opsForSet().randomMember(key);
            ret.add(this.convertObjs(value, clazz));
            return ret;
        }
    }

    public Long lpush(String key, Object... values) {
        if (values != null && values.length != 0) {
            return !this.isValidKey(key) ? 0L : this.redisTemplate.opsForList().leftPushAll(key, this.convertObjs(values));
        } else {
            return 0L;
        }
    }

    public Long lpushForTime(String key, long timeout, Object... values) {
        Long ret = this.lpush(key, values);
        if (ret != null && ret == (long) values.length) {
            this.redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
        }

        return ret;
    }

    public List<String> lrange(String key) {
        return this.redisTemplate.opsForList().range(key, 0L, -1L);
    }

    public <T> List<T> lrange(String key, Class<T> clazz) {
        return lrange(key, 0L, -1L, clazz);
    }

    public <T> List<T> lrange(String key, long offset, long count, Class<T> clazz) {
        List<String> list = this.redisTemplate.opsForList().range(key, offset, count);
        List<T> ret = new ArrayList();
        Iterator i$ = list.iterator();

        while (i$.hasNext()) {
            String value = (String) i$.next();
            ret.add(this.convertObjs(value, clazz));
        }
        return ret;
    }

    public void ltrim(String key, long start, long end) {
        this.redisTemplate.opsForList().trim(key, start, end);
    }

    public long lrem(String key, long count, Object value) {
        return !this.isValidKey(key) ? 0L : this.redisTemplate.opsForList().remove(key, count, value);
    }

    public Long incrForTime(String key, long timeout) {
        Long ret = this.redisTemplate.opsForValue().increment(key, 1L);
        if (ret != null && ret == 1L) {
            this.redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
        }

        return ret;
    }

    public boolean set(String key, Object value, long timeout) {
        if (!this.isValidKey(key)) {
            return false;
        } else {
            if (value instanceof String) {
                this.redisTemplate.opsForValue().set(key, value.toString());
            } else {
                String objectJson = JsonUtils.toJsonString(value);
                this.redisTemplate.opsForValue().set(key, objectJson);
            }

            this.redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
            return true;
        }
    }

    public boolean expire(String key, long timeout) {
        return this.redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    public boolean expireAt(String key, Date time) {
        return time != null ? this.redisTemplate.expireAt(key, time) : false;
    }

    @Transactional
    public Long incrForTimeWithDelay(String key, long timeout) {
        Long ret = this.redisTemplate.opsForValue().increment(key, 1L);
        this.redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
        return ret;
    }

    @Transactional
    public Long saddForTimeWithDelay(String key, long timeout, Object... values) {
        Long ret = this.sadd(key, values);
        this.redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
        return ret;
    }

    public Long rpush(String key, Object... values) {
        return values != null && values.length != 0 ? this.redisTemplate.opsForList().rightPushAll(key, this.convertObjs(values)) : 0L;
    }

    public <T> T lpop(String key, Class<T> clazz) {
        String value = this.redisTemplate.opsForList().leftPop(key);
        return this.convertObjs(value, clazz);
    }

    public <T> T rpop(String key, Class<T> clazz) {
        String value = this.redisTemplate.opsForList().rightPop(key);
        return this.convertObjs(value, clazz);
    }

    public <T> T blpop(String key, long timeout, Class<T> clazz) {
        String value = this.redisTemplate.opsForList().leftPop(key, timeout, TimeUnit.SECONDS);
        return this.convertObjs(value, clazz);
    }

    public <T> T brpop(String key, long timeout, Class<T> clazz) {
        String value = this.redisTemplate.opsForList().rightPop(key, timeout, TimeUnit.SECONDS);
        return this.convertObjs(value, clazz);
    }

    public boolean zadd(String key, long score, Object value) {
        return this.redisTemplate.opsForZSet().add(key, this.convertObjs(value), new Long(score).doubleValue());
    }

    public boolean zadd(String key, double score, Object value) {
        return this.redisTemplate.opsForZSet().add(key, this.convertObjs(value), score);
    }

    public Double zincrBy(String key, Object value, double score) {
        return this.redisTemplate.opsForZSet().incrementScore(key, this.convertObjs(value), score);
    }

    public Long zcard(String key) {
        return this.redisTemplate.opsForZSet().zCard(key);
    }

    public Set<String> zrange(String key, long start, long end) {
        return this.redisTemplate.opsForZSet().range(key, start, end);
    }

    public Map<String, Double> zrangeWithScore(String key, long start, long end) {
        Map<String, Double> ret = new HashMap<>();
        Set<ZSetOperations.TypedTuple<String>> zset = this.redisTemplate.opsForZSet().rangeWithScores(key, start, end);
        for (ZSetOperations.TypedTuple<String> type : zset) {
            ret.put(type.getValue(), type.getScore());
        }
        return ret;
    }

    public Set<String> zrangeAll(String key) {
        return this.redisTemplate.opsForZSet().range(key, 0L, -1L);
    }

    /**
     * 获取ZSET中指定INDEX条数的分数
     *
     * @param key
     * @param index
     * @return
     */
    public Double zScoreWith(String key, long index) {
        ZSetOperations operations = this.redisTemplate.opsForZSet();
        Set<String> set = this.redisTemplate.opsForZSet().reverseRange(key, index, index);
        if (set.isEmpty()) {
            return null;
        }
        String value = new ArrayList<>(set).get(0);
        return operations.score(key, value);
    }

    public <T> List<T> zrange(String key, long start, long end, Class<T> clazz) {
        List<T> ret = new ArrayList();
        Set<String> values = this.redisTemplate.opsForZSet().range(key, start, end);

        if (values != null && values.size() > 0) {
            Iterator i$ = values.iterator();

            while (i$.hasNext()) {
                String value = (String) i$.next();
                ret.add(this.convertObjs(value, clazz));
            }
        }

        return ret;
    }

    public List<String> zrevrange(String key, long start, long end) {
        return new ArrayList(this.redisTemplate.opsForZSet().reverseRange(key, start, end));
    }

    public <T> List<T> zrevrange(String key, long start, long end, Class<T> clazz) {
        List<T> ret = new ArrayList();
        Set<String> values = this.redisTemplate.opsForZSet().reverseRange(key, start, end);
        if (values != null && values.size() > 0) {
            Iterator i$ = values.iterator();

            while (i$.hasNext()) {
                String value = (String) i$.next();
                ret.add(this.convertObjs(value, clazz));
            }
        }

        return ret;
    }

    public long zrem(String key, Object... values) {
        return this.redisTemplate.opsForZSet().remove(key, values);
    }

    public Set<String> zrangebyscore(String key, double min, double max) {
        return this.redisTemplate.opsForZSet().rangeByScore(key, min, max);
    }

    public Set<String> zrangebyscore(String key, double min, double max, long offset, long count) {
        return this.redisTemplate.opsForZSet().rangeByScore(key, min, max, offset, count);
    }

    public Set<String> zrevrangebyscore(String key, double min, double max, long offset, long count) {
        return this.redisTemplate.opsForZSet().reverseRangeByScore(key, min, max, offset, count);
    }

//    public Set<String> zrevrangebyscoreWithScore(String key, double min, double max, long offset, long count) {
//        Set<ZSetOperations.TypedTuple<String>> this.redisTemplate.opsForZSet().reverseRangeByScoreWithScores(key, min, max, offset, count);
//    }

    public Set<?> zrangebyscoreWithScores(String key, double min, double max) {
        return this.redisTemplate.opsForZSet().rangeByScoreWithScores(key, min, max);
    }

    public Set<?> zrangebyscoreWithScores(String key, double min, double max, long offset, long count) {
        return this.redisTemplate.opsForZSet().rangeByScoreWithScores(key, min, max, offset, count);
    }

    public void subscribe(String channel, MessageListener listener) {
        if (listener != null) {
            if (!StringUtils.isEmpty(channel)) {
                byte[] rawChannel = this.redisTemplate.getStringSerializer().serialize(channel);
//                this.redisTemplate.getConnectionFactory().getConnection().subscribe(listener, new byte[][]{rawChannel});
            }
        }
    }

    public void publish(String channel, Serializable message) {
        if (!StringUtils.isEmpty(channel)) {
            if (message != null) {
                this.redisTemplate.convertAndSend(channel, message);
            }
        }
    }

    private String convertObjs(Object value) {
        if (value == null) {
            return "";
        } else {
            return value.getClass() != String.class && value.getClass() != Integer.class && value.getClass() != Integer.TYPE && value.getClass() != Long.class && value.getClass() != Long.TYPE && value.getClass() != Double.class && value.getClass() != Double.TYPE && value.getClass() != Float.class && value.getClass() != Float.TYPE ? JsonUtils.toJsonString(value) : value.toString();
        }
    }

    private String[] convertObjs(Object... values) {
        String[] strs = new String[values.length];

        for (int i = 0; i < values.length; ++i) {
            Object value = values[i];
            if (value != null) {
                if (value.getClass() != String.class && value.getClass() != Integer.class && value.getClass() != Integer.TYPE && value.getClass() != Long.class && value.getClass() != Long.TYPE && value.getClass() != Double.class && value.getClass() != Double.TYPE && value.getClass() != Float.class && value.getClass() != Float.TYPE) {
                    strs[i] = JsonUtils.toJsonString(values[i]);
                } else {
                    strs[i] = value.toString();
                }
            }
        }

        return strs;
    }

    private <T> T convertObjs(String value, Class<T> clazz) {
        if (clazz == String.class) {
            return (T) value;
        } else if (clazz != Integer.class && clazz != Integer.TYPE) {
            if (clazz != Long.class && clazz != Long.TYPE) {
                if (clazz != Double.class && clazz != Double.TYPE) {
                    if (clazz != Float.class && clazz != Float.TYPE) {
                        return JsonUtils.fromJson(value, clazz);
                    } else {
                        return StringUtils.isEmpty(value) ? null : (T) new Float(value);
                    }
                } else {
                    return StringUtils.isEmpty(value) ? null : (T) new Double(value);
                }
            } else {
                return StringUtils.isEmpty(value) ? null : (T) new Long(value);
            }
        } else {
            return StringUtils.isEmpty(value) ? null : (T) new Integer(value);
        }
    }

    public void geoAdd(String key, String lat, String lng, String name) {
        GeoOperations<String, String> geoOperations = this.redisTemplate.opsForGeo();
        Point point = new Point(Double.parseDouble(lat), Double.parseDouble(lng));
        geoOperations.geoAdd(key, point, name);
    }

    public List<GeoResult<RedisGeoCommands.GeoLocation<String>>> geoRadius(String key, String lat, String lng, double distance) {
        GeoOperations<String, String> geoOperations = this.redisTemplate.opsForGeo();
        Point point = new Point(Double.parseDouble(lat), Double.parseDouble(lng));
        Distance dist = new Distance(distance, Metrics.KILOMETERS);
        Circle circle = new Circle(point, dist);
        RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs();//按距离升序排列
        args.sortAscending();
        GeoResults<RedisGeoCommands.GeoLocation<String>> result = geoOperations.geoRadius(key, circle, args);
        return result.getContent();
    }

    /**
     * 判断ZSET中是否存在此元素
     *
     * @param key
     * @param value
     * @return 存在返回分数, 不存在返回null
     */
    public Double zexists(String key, Long value) {
        if (StringUtils.isEmpty(key) || value == null) {
            return null;
        }
        try {
            return redisTemplate.opsForZSet().score(key, String.valueOf(value));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 判断SET中是否存在此元素
     *
     * @param key
     * @param value
     * @return 存在返回分数, 不存在返回null
     */
    public boolean sexists(String key, String value) {
        if (StringUtils.isEmpty(key) || value == null) {
            return false;
        }
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            return false;
        }
    }

}
