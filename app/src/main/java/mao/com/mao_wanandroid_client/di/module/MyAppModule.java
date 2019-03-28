package mao.com.mao_wanandroid_client.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mao.com.mao_wanandroid_client.application.MyApplication;
import mao.com.mao_wanandroid_client.core.db.DbHelperImpl;
import mao.com.mao_wanandroid_client.core.http.DataClient;
import mao.com.mao_wanandroid_client.core.http.helper.IHttpHelperImpl;
import mao.com.mao_wanandroid_client.core.http.tools.NetworkUtils;
import mao.com.mao_wanandroid_client.core.sp.SharedPreferenceHelperImpl;

/**
 * @author maoqitian
 * @Description 注入Application Module
 * @Time 2019/3/21 0021 20:51
 */
@Module
public class MyAppModule {

    private MyApplication application;

    public MyAppModule(MyApplication myApplication){
        this.application = myApplication;
    }

    @Provides
    @Singleton
    public MyApplication providerApplication(){
        return application;
    }
    @Provides
    @Singleton
    public DataClient providerDataClient(IHttpHelperImpl iHttpHelper,
                                         SharedPreferenceHelperImpl sharedPreferenceHelper,
                                         DbHelperImpl dbHelper){
        return new DataClient(iHttpHelper,sharedPreferenceHelper,dbHelper);
    }

    @Provides
    @Singleton
    public IHttpHelperImpl providerIHttpHelperImpl(IHttpHelperImpl iHttpHelper){
        return iHttpHelper;
    }

    @Provides
    @Singleton
    public DbHelperImpl providerDbHelper(DbHelperImpl dbHelper){
        return dbHelper;
    }

    @Provides
    @Singleton
    public SharedPreferenceHelperImpl providerSharedPreferenceHelper(SharedPreferenceHelperImpl sharedPreferenceHelper){
        return sharedPreferenceHelper;
    }


    @Provides
    @Singleton
    public NetworkUtils providerNetworkUtils(){
        return new NetworkUtils();
    }

}