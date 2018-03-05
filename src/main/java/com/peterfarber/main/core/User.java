package com.peterfarber.main.core;

import java.io.*;
import java.util.UUID;

public class User implements Serializable {

    private static final long serialVersionUID = 6580934576706602645L;

    private final String id;
    private final String name;
    private final String username;
    private String password;

    public User(String name, String username, String password){
        this.name = name;
        this.username = username;
        this.password = password;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void save(){
        try {
            FileOutputStream fileOut = new FileOutputStream("data/users/"+this.id+".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(){
        File file = new File("data/users/"+this.id+".ser");

        if(file.delete())
        {
            System.out.println("File deleted successfully");
        }
        else
        {
            System.out.println("Failed to delete the file");
        }
    }


}
