package com.sunq.constvalue;

import com.intellij.openapi.components.*;
import com.intellij.openapi.project.Project;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.Nullable;

/**
 * Author:sunqian
 * Date:2018/8/8 12:19
 * Description:
 */
@State(name = "px2remForWebStorm",storages = {@Storage("px2remforwebstorm.xml")})
public class ConstValue implements PersistentStateComponent<ConstValue> {

    public String remBaseValue;

    public ConstValue getState() {
        return this;
    }

    public void loadState(ConstValue state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public double getRemBaseValue() {
        return Double.parseDouble(remBaseValue == null ? "100.0" : remBaseValue);
    }

    public void setRemBaseValue(String remBaseValue) {
        this.remBaseValue = remBaseValue;
    }

    @Nullable
    public static ConstValue getInstance(Project project) {
        return ServiceManager.getService(project, ConstValue.class);
    }
}
