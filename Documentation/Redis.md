
> yp  https://www.youtube.com/watch\?v\=A0Nlz-L9ezo\&list\=PLS1QulWo1RIYZZxQdap7Sd0ARKFI-XVsd\&index\=4


##### 753:C 02 Apr 12:20:05.460 # oO0OoO0OoO0Oo Redis is starting oO0OoO0OoO0Oo
##### 753:C 02 Apr 12:20:05.461 # Redis version=4.0.9, bits=64, commit=00000000, modified=0, pid=753, just started
##### 753:C 02 Apr 12:20:05.461 # Warning: no config file specified, using the default config. In order to specify a config file use redis-server /path/to/redis.conf
##### 753:M 02 Apr 12:20:05.463 * Increased maximum number of open files to 10032 (it was originally set to 256).

					_._                                                  
			_.-``__ ''-._                                             
		_.-``    `.  `_.  ''-._           Redis 4.0.9 (00000000/0) 64 bit
	.-`` .-```.  ```\/    _.,_ ''-._                                   
	(    '      ,       .-`  | `,    )     Running in standalone mode
	|`-._`-...-` __...-.``-._|'` _.-'|     Port: 6379
	|    `-._   `._    /     _.-'    |     PID: 753
	`-._    `-._  `-./  _.-'    _.-'                                   
	|`-._`-._    `-.__.-'    _.-'_.-'|                                  
	|    `-._`-._        _.-'_.-'    |           http://redis.io        
	`-._    `-._`-.__.-'_.-'    _.-'                                   
	|`-._`-._    `-.__.-'    _.-'_.-'|                                  
	|    `-._`-._        _.-'_.-'    |                                  
	`-._    `-._`-.__.-'_.-'    _.-'                                   
		`-._    `-.__.-'    _.-'                                       
			`-._        _.-'                                           
				`-.__.-'                                        



#### Open Server

> redis-server

> Port: 6379

#### Check Ip Address

> redis-cli

#### Check Ping

	127.0.0.1:6379> ping
	PONG

#### Set Key and value

	127.0.0.1:6379> set name maximum
	OK

#### Get Key-value
	127.0.0.1:6379> get name
	"maximum"
	127.0.0.1:6379> save
	OK
	127.0.0.1:6379> 

#### Delete Key

	127.0.0.1:6379> del name1
	(integer) 1
	127.0.0.1:6379> keys *
	1) "name"
	127.0.0.1:6379>


#### Delete all Key

	127.0.0.1:6379> keys *
	1) "name3"
	2) "name"
	3) "name2"
	127.0.0.1:6379> FLUSHALL
	OK
	127.0.0.1:6379> keys *
	(empty list or set)
	127.0.0.1:6379> 


#### setex -> set the value expiry of the key

	127.0.0.1:6379> SETEX name2 20 khan
	OK
	127.0.0.1:6379> get name2
	"khan"


#### ttl time to live

	127.0.0.1:6379> ttl name2
	(integer) 2


#### SETNX protect to override data
	127.0.0.1:6379> SETNX name2 khan
	(integer) 1
	127.0.0.1:6379> keys *
	1) "name"
	2) "name2"
	127.0.0.1:6379> get name2
	"khan"
	127.0.0.1:6379> SETNX name2 cm
	(integer) 0
	127.0.0.1:6379> get name2
	"khan"
	127.0.0.1:6379>

#### check the length of key

	127.0.0.1:6379> STRLEN name2
	(integer) 4
	127.0.0.1:6379> get name2
	"khan"
	127.0.0.1:6379>

#### if we want to set multiple value in same command

	127.0.0.1:6379> MSET num1 20 num2 100 num3 200 num3 102
	OK
	127.0.0.1:6379> keys *
	1) "name"
	2) "num3"
	3) "num2"
	4) "num1"
	5) "name2"
	127.0.0.1:6379> get num3
	"102"
	127.0.0.1:6379>

#### Set values for milliseconds

	127.0.0.1:6379> PSETEX num4 10000 ca
	OK
	127.0.0.1:6379> KEYS *
	1) "name"
	2) "num3"
	3) "num2"
	4) "num1"
	5) "name2"
	6) "num4"
	127.0.0.1:6379> KEYS *
	1) "name"
	2) "num3"
	3) "num2"
	4) "num1"
	5) "name2"
	127.0.0.1:6379>

#### incriment decriment

	127.0.0.1:6379> DECR num1
	(integer) 19
	127.0.0.1:6379> get num1
	"19"
	127.0.0.1:6379> INCR num1
	(integer) 20
	127.0.0.1:6379>

#### incriment decriment value by flag

	127.0.0.1:6379> get num1
	"20"
	127.0.0.1:6379> INCRBY num1 7
	(integer) 27
	127.0.0.1:6379> get num1
	"27"
	127.0.0.1:6379> DECRBY num1 3
	(integer) 24
	127.0.0.1:6379> get num1
	"24"
	127.0.0.1:6379>