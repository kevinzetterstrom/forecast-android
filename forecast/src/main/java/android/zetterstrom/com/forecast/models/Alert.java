/*
 * Copyright 2016 Kevin Zetterstrom
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package android.zetterstrom.com.forecast.models;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

/**
 * An alert object represents a severe weather warning issued for the requested location by a
 * governmental authority
 * <p/>
 * Not all fields may contain data. A null field is indicative that it was not present in the response.
 * <p/>
 * <p/>
 * Created by Kevin Zetterstrom  on 2/10/16.
 */
@SuppressWarnings("unused")
public class Alert implements Serializable {

    private static final long serialVersionUID = -4721384892605656941L;

    @Nullable
    @SerializedName(ModelConstants.FIELD_TITLE)
    private String mTitle;

    @Nullable
    @SerializedName(ModelConstants.FIELD_DESCRIPTION)
    private String mDescription;

    @Nullable
    @SerializedName(ModelConstants.FIELD_EXPIRES)
    private Date mExpires;

    @Nullable
    @SerializedName(ModelConstants.FIELD_URI)
    private String mUri;

    @Nullable
    public String getTitle() {
        return mTitle;
    }

    @Nullable
    public String getDescription() {
        return mDescription;
    }

    @Nullable
    public Date getExpires() {
        return mExpires;
    }

    @Nullable
    public String getUri() {
        return mUri;
    }
}
