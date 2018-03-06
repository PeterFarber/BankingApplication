package com.peterfarber.main.core;

import com.peterfarber.main.core.exceptions.BankException;
import com.peterfarber.main.core.exceptions.EmptyDirectory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class DirectoryLoader<T> {

    private String path;
    private Vector<T> t;

    public DirectoryLoader(String path){
        this.path = path;
        t = new Vector<T>();
    }

    /**
     * Loads all files from the data directory into a Vector of type T.
     * @exception EmptyDirectory if no files exist in directory.
     */
    public void load() throws BankException {
        try{
            //Open the users directory!
            File f = new File(this.path);
            //Generate a list of the file names in that directory.
            ArrayList<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));
            //Make sure there are files to load!
            if (files.isEmpty()) { throw new EmptyDirectory(f); }
            //Go through and load all of them as Users.
            for(int i = 0; i <files.size(); i++){
                try {
                    FileInputStream fileIn = new FileInputStream(files.get(i));
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    t.add((T)in.readObject());
                    in.close();
                    fileIn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
            }
        }catch(Exception e) {
            System.out.println("\n*******Exception*******");
            System.out.println(e.getMessage() + "\n");
        }

    }

    public int getSize(){
        return t.size();
    }

    public T getIndex(int i){
        return t.get(i);
    }

    public void add(T object){
        t.add(object);
    }

    public void remove(T object) { t.removeElement(object); }


}
