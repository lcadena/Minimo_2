package com.example.lizeth.minim_2;

import com.example.lizeth.minim_2.Libro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIService {
    @GET("/Libro/")
    Call<List<Libro>> getList(@Path("name") String name);

    @GET("/Libro/{libroID}")
    Call<List<Libro>> getListId(@Path("libroID") int libroID);

    @GET("/users/{name}")
    Call<Libro> getFollower(@Path("name") String name);

    @GET("/users/{name}/following")
    Call<List<Libro>> getListrepos(@Path("name") String name);
}
