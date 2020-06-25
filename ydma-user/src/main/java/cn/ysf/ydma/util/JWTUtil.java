package cn.ysf.ydma.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cn.ysf.ydma.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class JWTUtil {
	
	private static final long EXPIRE_TIME = 15 * 60 * 1000;
//	private static final String TOKEN_SECRET = "dsdsa221";
	
	/**
	 * 生成签名，15分钟过期
	 * @param **username**
	* @param **password**
	* @return
	 */
	public static String sign(User user) {
	    try {
	        // 设置过期时间
	        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
	        // 私钥和加密算法 用用户的密码 生成秘钥
	        Algorithm algorithm = Algorithm.HMAC256(user.getPassword());
	        // 设置头部信息
	        Map<String, Object> header = new HashMap<String, Object>(2);
	        header.put("typ", "JWT");
	        header.put("alg", "HS256");
	        // 返回token字符串
	        return JWT.create()
	                .withHeader(header)
	                .withClaim("aud", user.getName())
	                .withClaim("uid", user.getId())
	                .withExpiresAt(date)
	                .sign(algorithm);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	/**
	 * 检验token是否正确
	 * @param **token**
	* @return
	 */
	public static boolean verify(String token,String secret){
	    try {
	        Algorithm algorithm = Algorithm.HMAC256(secret);
	        JWTVerifier verifier = JWT.require(algorithm).build();
	        DecodedJWT jwt = verifier.verify(token);
	        return true;
	    } catch (Exception e){
	        return false;
	    }
	}
	
}
