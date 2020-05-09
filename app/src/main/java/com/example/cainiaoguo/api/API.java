package com.example.cainiaoguo.api;

import com.example.cainiaoguo.domain.HistoryOrders;
import com.example.cainiaoguo.domain.MailResultInfo;
import com.example.cainiaoguo.domain.Order;
import com.example.cainiaoguo.domain.ResultInfo;
import com.example.cainiaoguo.domain.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface API {

    @POST("/Group8_server/userLoginServlet")
    Call<User> userLogin(@Query("username")String username,@Query("passwd")String passwd);

    @POST("/Group8_server/userRegistServlet")
    Call<ResultInfo> userRegist(@Query("username")String username,@Query("passwd")String passwd,
                                @Query("address")String address,@Query("gender")String gender,
                                @Query("age")String age,@Query("identify")String identify,
                                @Query("user_phone")String user_phone);

    @POST("/Group8_server/findHistoricalByUidServlet")
    Call<HistoryOrders> getHistoryOrders(@Query("uid")String uid);

    @POST("/Group8_server/findOrderByIdServlet")
    Call<Order> getOrder(@Query("order_id")String order_id);

    @POST("/Group8_server/saveUserInfoServlet")
    Call<User> updateMyInfo(@Query("uid")String uid,@Query("username")String username,
                                  @Query("address")String address,@Query("gender")String gender,
                                  @Query("age")int age,@Query("identify")String identify);

    @POST("/Group8_server/mailingByUidServlet")
    Call<ResultInfo> mailThings(@Query("uid")String uid, @Query("sender_address")String sender_address,
                                  @Query("sender_name")String sender_name, @Query("sender_phone")String sender_phone,
                                  @Query("receiver_address")String receiver_address, @Query("receiver_name")String receiver_name,
                                  @Query("receiver_phone")String receiver_phone, @Query("weight")int weight, @Query("type")String type);


}
