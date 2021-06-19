Steps:

1. To start redis 
        
        Start : docker run --name redis -p 6379:6379 -d redis
        Bash Mode: docker exec -it redis bash
        CLI: redis-cli
        Verify: PING
        Monitor: redis-cli monitor
                 redis-cli -h localhost -p 6379 monitor

2. Insert data:
        
    ```
    MULTI
    HMSET product:10200 name ZXYW desc “Description for ZXYW” price 300
    ZADD product_list 10200 product:10200
    ZADD product_price 300 product:10200
    EXEC
    ```
   
    ```
    xadd users * language 2 count 30 xadd users * language 4 count 43
   ```
   
    More details:
   https://redislabs.com/blog/get-sql-like-experience-redis/