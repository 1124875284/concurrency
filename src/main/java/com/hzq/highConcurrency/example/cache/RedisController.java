package com.hzq.highConcurrency.example.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    private RedisClient redisClient;

    @GetMapping("/cache/set")
    @ResponseBody
    public String set(@RequestParam("k") String key,@RequestParam("v") String value){
        redisClient.setJedisPool(key,value);
        return "success";
    }

    @GetMapping("/cache/get")
    @ResponseBody
    public String get(@RequestParam("k") String key) throws Exception {
        return redisClient.get(key);
    }
}
