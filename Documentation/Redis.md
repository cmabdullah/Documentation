
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



username and password abdullah

#### Open Server

> redis-server

> Port: 6379

#### Shutdown Server

> redis-cli shutdown

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

#### Append Two String

	127.0.0.1:6379> set mykey hello
	OK
	127.0.0.1:6379> APPEND mykey " world"
	(integer) 11
	127.0.0.1:6379> get mykey
	"hello world"
	127.0.0.1:6379>

## lectur 7
# Way of set and get hash value
#### Hashes are map with string fields and string values hence there perfect datatype for representation of objects. redis hash can store upto 4b ilion field value paires

#### Set multiple key field value pair using hmset

	127.0.0.1:6379> HMSET stud1 name max age 15 class 8
	OK

#### Get value form key name

	127.0.0.1:6379> HGET stud1 name
	"max"

#### Get all value form key name

	127.0.0.1:6379> HGETALL stud1
	1) "name"
	2) "max"
	3) "age"
	4) "15"
	5) "class"
	6) "8"
	127.0.0.1:6379>


##### HEXISTS field inside this hash type exist or not?

	127.0.0.1:6379> HEXISTS stud1 surname
	(integer) 0
	127.0.0.1:6379>

	127.0.0.1:6379> HEXISTS stud1 name
	(integer) 1
	127.0.0.1:6379>

##### Delete key from hash

	127.0.0.1:6379> HDEL stud1 class
	(integer) 1
	127.0.0.1:6379> HGETALL stud1
	1) "name"
	2) "max"
	3) "age"
	4) "15"
	127.0.0.1:6379>

##### Once again set field value

	127.0.0.1:6379> HMSET stud1 class 10
	OK
	127.0.0.1:6379> HGETALL stud1
	1) "name"
	2) "max"
	3) "age"
	4) "15"
	5) "class"
	6) "10"
	127.0.0.1:6379>

#### HSETNX command is used for setting field value if the field doesnot exist

	127.0.0.1:6379> HSETNX stud1 name mainul
	(integer) 0
	127.0.0.1:6379> HSETNX stud1 surname mr
	(integer) 1
	127.0.0.1:6379>
	127.0.0.1:6379> HGETALL stud1
	1) "name"
	2) "max"
	3) "age"
	4) "15"
	5) "class"
	6) "10"
	7) "surname"
	8) "mr"
	127.0.0.1:6379>

##### view onl field from hash

	127.0.0.1:6379> HKEYS stud1
	1) "name"
	2) "age"
	3) "class"
	4) "surname"
	127.0.0.1:6379>

##### increment field value

	127.0.0.1:6379> HINCRBY stud1 age 3
	(integer) 18
	127.0.0.1:6379> HGETALL stud1
	1) "name"
	2) "max"
	3) "age"
	4) "18"
	5) "class"
	6) "10"
	7) "surname"
	8) "mr"
	127.0.0.1:6379>

##### if we want to know all the values of a particular key

	127.0.0.1:6379> HVALS stud1
	1) "max"
	2) "18"
	3) "10"
	4) "mr"
	127.0.0.1:6379>

#### length of hash

	127.0.0.1:6379> HLEN stud1
	(integer) 4
	127.0.0.1:6379>

#### HMGET will give you the result whatever fields you
 
	127.0.0.1:6379> HMGET stud1 name
	1) "max"
	127.0.0.1:6379>
	127.0.0.1:6379> HMGET stud1 name age
	1) "max"
	2) "18"
	127.0.0.1:6379>


# Redis list lectur 8


Redislist is simply list of string sorted by their insertion order

elements can be inserted from the tom or from bottom

lpush means we want to push into the head

#### redis-cli monitor command will monitor all the command which you are exicuting from cli

#### Push value into list

	127.0.0.1:6379> LPUSH  num 1 2 3 4
	(integer) 4
	127.0.0.1:6379> LRANGE num 0 10
	1) "4"
	2) "3"
	3) "2"
	4) "1"
	127.0.0.1:6379>

##### Push new value on the top 

	127.0.0.1:6379> LPUSH  num 5
	(integer) 5
	127.0.0.1:6379> LRANGE num 0 10
	1) "5"
	2) "4"
	3) "3"
	4) "2"
	5) "1"
	127.0.0.1:6379>

#### lpop command pop value from the top

	127.0.0.1:6379> LPOP num
	"5"
	127.0.0.1:6379> LRANGE num 0 10
	1) "4"
	2) "3"
	3) "2"
	4) "1"
	127.0.0.1:6379>

#### push from the bottom using LRANGE command

	127.0.0.1:6379> RPUSH num 6
	(integer) 5
	127.0.0.1:6379> LRANGE num 0 10
	1) "4"
	2) "3"
	3) "2"
	4) "1"
	5) "6"
	127.0.0.1:6379>

#### rpom will pop from the bottom

	127.0.0.1:6379> RPOP num
	"6"
	127.0.0.1:6379> LRANGE num 0 10
	1) "4"
	2) "3"
	3) "2"
	4) "1"
	127.0.0.1:6379>

#### llen is the length of the list

	127.0.0.1:6379> LLEN num
	(integer) 5
	127.0.0.1:6379> LRANGE num 0 10
	1) "4"
	2) "3"
	3) "2"
	4) "1"
	5) "6"
	127.0.0.1:6379>

##### get value from specific index using lindex

	127.0.0.1:6379> LRANGE num 0 10
	1) "4"
	2) "3"
	3) "2"
	4) "1"
	5) "6"
	127.0.0.1:6379> LINDEX num 4
	"6"
	127.0.0.1:6379>

#### insert value int middle

	127.0.0.1:6379> LSET num  2 8
	OK
	127.0.0.1:6379> LRANGE num 0 10
	1) "4"
	2) "3"
	3) "8"
	4) "1"
	5) "6"
	127.0.0.1:6379>

#### show all the elements in the list 

	127.0.0.1:6379> LRANGE num 0 -1
	1) "4"
	2) "3"
	3) "8"
	4) "1"
	5) "6"
	127.0.0.1:6379>

#### LPUSHX if key exist then this command is successful

	127.0.0.1:6379> LPUSHX num 7
	(integer) 6
	127.0.0.1:6379> LRANGE num 0 -1
	1) "7"
	2) "4"
	3) "3"
	4) "8"
	5) "1"
	6) "6"
	127.0.0.1:6379>
	127.0.0.1:6379> LPUSHX sub 1 2 3 4 5
	(integer) 0
	127.0.0.1:6379>

#### push value before specific value

	127.0.0.1:6379> LINSERT num before 1 251
	(integer) 7
	127.0.0.1:6379> LRANGE num 0 -1
	1) "7"
	2) "4"
	3) "3"
	4) "8"
	5) "251"
	6) "1"
	7) "6"
	127.0.0.1:6379>

#### push value after specific value

	127.0.0.1:6379> LINSERT num after 3 2018
	(integer) 8
	127.0.0.1:6379> LRANGE num 0 -1
	1) "7"
	2) "4"
	3) "3"
	4) "2018"
	5) "8"
	6) "251"
	7) "1"
	8) "6"
	127.0.0.1:6379>

