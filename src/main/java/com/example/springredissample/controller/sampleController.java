package com.example.springredissample.controller;

import com.example.springredissample.infrastracture.redis.RedisClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;

@Controller
public class sampleController {

    private RedisClient redisClient;
    public sampleController(RedisClient redisClient) {
        this.redisClient = redisClient;
    }

    @GetMapping("index")
    public String index(){
        return "index";
    }

    /**
     * try like this : http://localhost:8080/redis?key=name&value=yourName.
     */
    @RequestMapping("/redis")
    public String addKey(Model model, String key, String value) {
        System.out.println(key + ", " + value);
        Jedis jedis = redisClient.getResource();
        jedis.set(key,value);
        model.addAttribute("key", jedis.get(key));
        return "index";
    }

}
