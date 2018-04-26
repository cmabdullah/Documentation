
### RedisHash

```java

import java.util.HashMap;
import java.util.Map;
import redis.clients.jedis.Jedis;
public class _02RedisHash {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Username", "Abdullah");// seems key is primitive type, java auto-boxing into non primitive type....
        map.put("Password", "Kh4rfjg");
        map.put("email", "a.kyium.khan@gmail.com");
        String ip = "127.0.0.1";
		try {
			Jedis jedis = new Jedis("localhost");
			System.out.println("Connection success...");
			System.out.println(jedis.ping());
			System.out.println("Inject into database : "+jedis.hmset("ip", map));
			
			System.out.println("Print Hash : "+jedis.hgetAll("ip"));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}

```