//package com.peterfarber.main.core;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.concurrent.TimeUnit;
//
//import static org.junit.Assert.*;
//
//public class DirectoryLoaderTest {
//
//    DirectoryLoader<User> userLoader;
//    ArrayList<User> users;
//
//
//    @Before
//    public void setUp() throws Exception {
//        users = new ArrayList<User>();
//        for(int i = 0; i < 10; i++){
//            User user = new User(i+"000", i+"0000", "password");
//            user.save();
//            users.add(user);
//        }
//
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        for(int i = 0; i < users.size(); i++){
//            users.get(i).delete();
//        }
//    }
//
//    @Test
//    public void load() {
//        try {
//            userLoader = new DirectoryLoader<User>("data/users");
//            userLoader.load();
//        }catch (Exception e){
//
//        }finally {
//            assertTrue(userLoader.getSize() > 0);
//        }
//    }
//
//    @Test
//    public void getSize() {
//        try {
//            userLoader = new DirectoryLoader<User>("data/users");
//            userLoader.load();
//        }catch (Exception e){
//
//        }finally {
//            assertTrue(userLoader.getSize() == 10);
//        }
//    }
//
//    @Test
//    public void getIndex() {
//        try {
//            userLoader = new DirectoryLoader<User>("data/users");
//            userLoader.load();
//        }catch (Exception e){
//
//        }finally {
//            assertNotNull(userLoader.getIndex(2));
//        }
//    }
//
//    @Test
//    public void add() {
//        try {
//            userLoader = new DirectoryLoader<User>("data/users");
//            userLoader.load();
//            User userAdd = new User("Test", "Case", "Pass");
//            userLoader.add(userAdd);
//        }catch (Exception e){
//
//        }finally {
//            assertTrue(userLoader.getIndex(10).getUsername().equals("Case"));
//            assertTrue(userLoader.getSize() == 11);
//        }
//    }
//
//    @Test
//    public void remove() {
//        try {
//            userLoader = new DirectoryLoader<User>("data/users");
//            userLoader.load();
//            userLoader.remove(userLoader.getIndex(5));
//        }catch (Exception e){
//
//        }finally {
//            assertTrue(userLoader.getSize() == 9);
//        }
//    }
//}