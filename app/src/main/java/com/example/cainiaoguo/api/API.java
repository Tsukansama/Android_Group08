package com.example.cainiaoguo.api;

import com.example.cainiaoguo.domain.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    @GET("/travel/userLoginServlet")
    Call<User> userLogin(@Query("username")String username,@Query("passwd")String passwd);

}
