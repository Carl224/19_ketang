package com.example.t.app.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class MyGrid_Item {
    @Id(autoincrement = true)
    private Long id;
    private String item;
    private boolean falg;
    @Generated(hash = 351181779)
    public MyGrid_Item(Long id, String item, boolean falg) {
        this.id = id;
        this.item = item;
        this.falg = falg;
    }
    @Generated(hash = 1732440872)
    public MyGrid_Item() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getItem() {
        return this.item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public boolean getFalg() {
        return this.falg;
    }
    public void setFalg(boolean falg) {
        this.falg = falg;
    }

}
