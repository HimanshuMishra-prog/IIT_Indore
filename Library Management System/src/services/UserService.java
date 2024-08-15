package services;

import models.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final String usersFile = "data/users.json";

    public User login(String id, String password) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(usersFile)));
            JSONArray usersArray = new JSONArray(content);
            for (int i = 0; i < usersArray.length(); i++) {
                JSONObject userJson = usersArray.getJSONObject(i);
                if (userJson.getString("id").equals(id) && userJson.getString("password").equals(password)) {
                    String type = userJson.getString("type");
                    if (type.equals("Admin")) {
                        return new Admin(id, password, userJson.getString("name"));
                    } else if (type.equals("Librarian")) {
                        return new Librarian(id, password, userJson.getString("name"));
                    } else if (type.equals("Member")) {
                        return new Member(id, password, userJson.getString("name"), userJson.getBoolean("isSuspended"));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addUser(User user) {
        JSONArray usersArray = new JSONArray();
        try {
            String content = new String(Files.readAllBytes(Paths.get(usersFile)));
            usersArray = new JSONArray(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject userJson = new JSONObject();
        userJson.put("id", user.getId());
        userJson.put("password", user.getPassword());
        userJson.put("name", user.getName());
        if (user instanceof Member) {
            userJson.put("type", "Member");
            userJson.put("isSuspended", ((Member) user).isSuspended());
        } else if (user instanceof Librarian) {
            userJson.put("type", "Librarian");
        } else if (user instanceof Admin) {
            userJson.put("type", "Admin");
        }
        usersArray.put(userJson);
        try {
            Files.write(Paths.get(usersFile), usersArray.toString(4).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeUser(String userId) {
        JSONArray usersArray = new JSONArray();
        try {
            String content = new String(Files.readAllBytes(Paths.get(usersFile)));
            usersArray = new JSONArray(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONArray updatedArray = new JSONArray();
        for (int i = 0; i < usersArray.length(); i++) {
            JSONObject userJson = usersArray.getJSONObject(i);
            if (!userJson.getString("id").equals(userId)) {
                updatedArray.put(userJson);
            }
        }
        try {
            Files.write(Paths.get(usersFile), updatedArray.toString(4).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void suspendMember(String memberId) {
    	JSONArray usersArray = new JSONArray();
    	try {
    		String content = new String(Files.readAllBytes(Paths.get(usersFile)));
    		usersArray = new JSONArray(content);	
    	}catch (IOException e) {
            e.printStackTrace();
        }
    	for(int i = 0 ; i< usersArray.length() ; i++) {
    		JSONObject userJson = usersArray.getJSONObject(i);
    		if(userJson.getString("id").equals(memberId)) {
    			userJson.put("isSuspended", true);
    		}
    	}
    	
    }
}

