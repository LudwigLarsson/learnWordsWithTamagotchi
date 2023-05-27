package com.ludwiglarsson.learnwordswithtamagotchi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ImageApi {
    @GET
    Call<ResponseBody> getImage(@Url String imageUrl);
}
