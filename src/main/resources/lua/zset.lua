--- 键
local key = KEYS[1]
--- 值
local value = KEYS[2]
--- 时间
local time = KEYS[3]
--- 开始时间
local starttime = KEYS[4]
--- 结束时间
local endtime = KEYS[5]

redis.call("zadd", key, tonumber(time), value)
local num = redis.call("zcount", key, tonumber(starttime), tonumber(endtime))
return tonumber(num)