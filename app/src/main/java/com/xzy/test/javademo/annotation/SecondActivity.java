package com.xzy.test.javademo.annotation;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.xzy.test.javademo.annotation.inject.Autowired;
import com.xzy.test.javademo.annotation.inject.InjectUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author xzy
 */
@com.xzy.test.javademo.ann.Lance
public class SecondActivity extends AppCompatActivity {

    int i, j;
    String k;

    @Autowired
    String name;

    @Autowired("attr")
    String attr;

    @Autowired
    int[] array;

    @Autowired
    UserParcelable userParcelable;

    @Autowired
    UserParcelable[] userParcelables;

    @Autowired
    List<UserParcelable> userParcelableList;

    @Autowired("users")
    UserSerializable[] userSerializables;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InjectUtils.injectAutowired(this);
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "SecondActivity{" +
                "name='" + name + '\'' +
                ", attr='" + attr + '\'' +
                ", array=" + Arrays.toString(array) +
                ", userParcelable=" + userParcelable +
                ", userParcelables=" + Arrays.toString(userParcelables) +
                ", userParcelableList=" + userParcelableList +
                ", userSerializables=" + Arrays.toString(userSerializables) +
                '}';
    }
}
