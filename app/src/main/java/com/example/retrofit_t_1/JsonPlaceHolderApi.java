package com.example.retrofit_t_1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface JsonPlaceHolderApi {


    @GET("v1/tracks/3n3Ppam7vgaVa1iaRUc9Lp")
    @Headers("Authorization: Bearer BQDyC6QP1dHn1k169VE_2Yd877DpuykYp-2Znfz4dgHaSvgDKA9B2Ea-wHfalnH4QQ9kcpSfE1wm-1NTbF6rd-NtMD8JH9UwwV4D_weAa3PhlFJt9xM0R1__ZQ0poFGvq6DZoImQBD0VgqNBMXsJoC9HowzlWS3_xkCZvG8uW8bE0GR1I-BDNdY52Hgk31Xj")
    Call<Track> getATrack();
}
