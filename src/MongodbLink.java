import java.net.UnknownHostException;
import java.util.*;

import javax.swing.JOptionPane;

import com.mongodb.*;


public class MongodbLink {
    static MongoClient client;
    static DB db;
    static DBCollection collection;
    
    public MongodbLink(){
    	
    }
    
    //获取密码，以字符串形式返回
	@SuppressWarnings("unchecked")
	public String getPassword(String username){
    	String password = null;
    	try {
			client = new MongoClient("127.0.0.1",27017);
		} catch (UnknownHostException e) {
			Object[] options = { "OK"};
			JOptionPane.showOptionDialog(null, "服务器连接失败！", "警告", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, null); 
		}
    	
    	if(client!=null){
        	db = client.getDB("chatsystem");
			DBCollection collection = db.getCollection("user");
			BasicDBObject fi = new BasicDBObject();
			fi.put("username",username);
			Map<String,String> co = new HashMap<String,String>();
			co = collection.findOne(fi).toMap();
			password = co.get("password");
    	}
		return password;
    }
    
    
    
    public void setUserInfo(String username,String password){
    	try {
			client = new MongoClient("127.0.0.1",27017);

		} catch (UnknownHostException e) {
			Object[] options = { "OK"};
			JOptionPane.showOptionDialog(null, "服务器连接失败！", "警告", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, null); 
		}
        
        if(client!=null){
        	db = client.getDB("chatsystem");
			DBCollection collection = db.getCollection("user");
			BasicDBObject document = new BasicDBObject();
			document.put("username",username);
			document.put("password", password);
			collection.insert(document);
        }
    }
    
    
    //验证用户名是否存在
    public boolean verifyUserExistOrNot(String username){
    	int count = 0;
    	try {
			client = new MongoClient("127.0.0.1",27017);
//			System.out.println("连接成功。。。");
		} catch (UnknownHostException e) {
			Object[] options = { "OK"};
			JOptionPane.showOptionDialog(null, "服务器连接失败！", "警告", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, null); 
		}
        if(client!=null){
        	db = client.getDB("chatsystem");
			DBCollection collection = db.getCollection("user");
			BasicDBObject document = new BasicDBObject();
			document.put("username", username);
			DBCursor dbc = collection.find(document);
			count = dbc.count();
        }
		return count==0;
       	
    }
    
    
    //用户匹配查询,即查找用户
    public DBObject searchUser(String username){
    	DBObject result = null;
    	try {
			client = new MongoClient("127.0.0.1",27017);
		} catch (UnknownHostException e) {
			Object[] options = { "OK"};
			JOptionPane.showOptionDialog(null, "服务器连接失败！", "警告", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, null); 
		}
        if(client!=null){
        	db = client.getDB("chatsystem");
			DBCollection collection = db.getCollection("user");
			BasicDBObject document = new BasicDBObject();
			document.put("username", username);
			result = collection.findOne(document);
        }
    	
		return result;
    	
    }
    
    
    //查询好友数目
    @SuppressWarnings("unchecked")
	public int friendsnumber(String username){
    	BasicDBObject document = new BasicDBObject();
    	String result = null;
    	try {
			client = new MongoClient("127.0.0.1",27017);
		} catch (UnknownHostException e) {
			Object[] options = { "OK"};
			JOptionPane.showOptionDialog(null, "服务器连接失败！", "警告", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, null); 
		}
    	if(client!=null){
        	db = client.getDB("chatsystem");
			DBCollection collection = db.getCollection("user");
			document.put("username", username);
			Map<String,String> co = new HashMap<String,String>();
			co = collection.findOne(document).toMap();
			result = co.get("friendnumber");
			
    	}
		return Integer.parseInt(result);
    }
    
    
    //获取好友列表
    public String [] getFriendList(String username){
    	BasicDBObject document = new BasicDBObject();
    	DBCursor dbc = null;
    	try {
			client = new MongoClient("127.0.0.1",27017);
		} catch (UnknownHostException e) {
			Object[] options = { "OK"};
			JOptionPane.showOptionDialog(null, "服务器连接失败！", "警告", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, null); 
		}
    	if(client!=null){
        	db = client.getDB("chatsystem");
			DBCollection collection = db.getCollection("user");
			document.put("username", username);
			dbc = collection.find(document);
			
			for(int i=0;i<dbc.count();i++){
				
				
			}
				
    	}
    	
		return null;
    	
    }
}
