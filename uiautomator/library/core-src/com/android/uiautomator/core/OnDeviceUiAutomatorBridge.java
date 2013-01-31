/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.uiautomator.core;

import android.app.Service;
import android.app.UiAutomation;
import android.content.Context;
import android.view.Display;
import android.view.ViewConfiguration;
import android.view.WindowManager;

class OnDeviceUiAutomatorBridge extends UiAutomatorBridge {

    private final Context mContext;

    public OnDeviceUiAutomatorBridge(Context context, UiAutomation uiAutomation) {
        super(uiAutomation);
        mContext = context;
    }

    public Display getDefaultDisplay() {
        WindowManager windowManager = (WindowManager)
                mContext.getSystemService(Service.WINDOW_SERVICE);
        return windowManager.getDefaultDisplay();
    }

    public long getSystemLongPressTime() {
        return ViewConfiguration.getLongPressTimeout();
    }
}