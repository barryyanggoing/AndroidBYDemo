package com.barryyang.barryyangdemo.components;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * @author : BarryYang
 * @date : 2020/7/31 2:38 PM
 * @desc :
 */
@Database(entities = {Order.class}, version = 1, exportSchema = false)
public abstract class AbstractAppDatabase extends RoomDatabase {

    private static final String DB_NAME = "barryyang.db";
    private static AbstractAppDatabase mInstance;

    public static AbstractAppDatabase getInstance(Context context) {
        if (mInstance == null) {
            synchronized (AbstractAppDatabase.class) {
                if (mInstance == null) {
                    mInstance = buildDatabase(context);
                }
            }
        }
        return mInstance;
    }

    private static AbstractAppDatabase buildDatabase(Context context) {
        return Room
                .databaseBuilder(context.getApplicationContext(), AbstractAppDatabase.class, DB_NAME)
                .allowMainThreadQueries()
                // .addMigrations(MigrationManager.getMigration1To2())
                .build();
    }

    public abstract OrderDao getOrderDao();

    public static void destroyInstance() {
        mInstance = null;
    }

}
