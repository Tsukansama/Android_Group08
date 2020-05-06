package com.example.cainiaoguo.api;

import com.example.cainiaoguo.domain.HistoryOrders;
import com.example.cainiaoguo.domain.ResultInfo;
import com.example.cainiaoguo.domain.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    @GET("/travel/userLoginServlet")
    Call<User> userLogin(@Query("username")String username,@Query("passwd")String passwd);

    @GET("/travel/userRegistServlet")
    Call<ResultInfo> userRegist(@Query("username")String username,@Query("passwd")String passwd,
                                @Query("address")String address,@Query("gender")String gender,
                                @Query("age")String age,@Query("identify")String identify,
                                @Query("user_phone")String user_phone);

    @GET("/travel/findHistoricalByUidServlet")
    Call<HistoryOrders> getHistoryOrders(@Query("uid")String uid);

    Call<ResultInfo> mailThings(@Query("uid")String uid, @Query("sender_address")String sender_address,
                                @Query("sender_name")String sender_name, @Query("sender_phone")String sender_phone);


}
