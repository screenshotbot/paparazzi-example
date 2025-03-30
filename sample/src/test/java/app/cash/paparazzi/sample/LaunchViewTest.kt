/*
 * Copyright (C) 2019 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package app.cash.paparazzi.sample

import android.widget.LinearLayout
import app.cash.paparazzi.DeviceConfig.Companion.NEXUS_5
import app.cash.paparazzi.DeviceConfig.Companion.PIXEL_3
import com.android.resources.ScreenOrientation.LANDSCAPE
import app.cash.paparazzi.Paparazzi
import org.junit.Rule
import org.junit.Test
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.unit.dp
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.material.Surface
import androidx.compose.foundation.layout.Column
import com.android.ide.common.rendering.api.SessionParams.RenderingMode.SHRINK

class LaunchViewTest {
  @get:Rule
  val paparazzi = Paparazzi(deviceConfig = PIXEL_3, useDeviceResolution = true)

  @Test
  fun pixel3() {
    val launch = paparazzi.inflate<LinearLayout>(R.layout.launch)
    paparazzi.snapshot(launch)
  }

  @Test
  fun pixel3_differentThemes() {
    paparazzi.unsafeUpdateConfig(theme = "android:Theme.Material.Light")
    var launch = paparazzi.inflate<LinearLayout>(R.layout.launch)
    paparazzi.snapshot(view = launch, name = "light")

    paparazzi.unsafeUpdateConfig(theme = "android:Theme.Material.Light.NoActionBar")
    launch = paparazzi.inflate(R.layout.launch)
    paparazzi.snapshot(view = launch, name = "light no_action_bar")
  }

  @Test
  fun nexus5_differentOrientations() {
    paparazzi.unsafeUpdateConfig(deviceConfig = NEXUS_5)
    var launch = paparazzi.inflate<LinearLayout>(R.layout.launch)
    paparazzi.snapshot(launch, "portrait")

    paparazzi.unsafeUpdateConfig(deviceConfig = NEXUS_5.copy(orientation = LANDSCAPE))
    launch = paparazzi.inflate(R.layout.launch)
    paparazzi.snapshot(launch, "landscape")
  }

  @Test
  fun launchComposable() {
      paparazzi.unsafeUpdateConfig(deviceConfig = NEXUS_5.copy(screenHeight = 8000),
                                   renderingMode = SHRINK)
      paparazzi.snapshot {
          MaterialTheme {
              Surface {
                  Column(
                      modifier = Modifier
                          .fillMaxSize()
                          .verticalScroll(rememberScrollState())
                  ) {
                      repeat(100) {
                          Text(text = "Hello $it")
                      }
                  }
              }
          }
      }
  }
}
