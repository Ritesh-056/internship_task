package com.example.internshipproject;

import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


//Network Service generator
public  class ServiceGenerator {

    static String baseURL = "https://jsonplaceholder.typicode.com";



    //generic service static function
    public static  <T> T createRequest(Class<T> classService){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create(
                        new GsonBuilder().excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                                .create()
                ))
                .build();


        //returning service class
       return retrofit.create(classService);
    }

}
