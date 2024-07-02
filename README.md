# Screenshotbot example with Paparazzi

[![Screenshots](https://screenshotbot.io/badge?org=5fd16bcf4f4b3822fd0000e1&channel=paparazzi-example%3Asample&branch=main)](https://screenshotbot.io/active-run?org=5fd16bcf4f4b3822fd0000e1&channel=paparazzi-example%3Asample&branch=main)

This repository is an example of how to integration
[Paparazzi](https://github.com/cashapp/paparazzi)
with [Screenshotbot](https://screenshotbot.io).

See `.circleci/config.yml` to see the steps required for
configuration.


Roughly, you can use Paparazzi as-is: but instead of running Paparazzi
in `verify` mode, we always run in in `record` mode, and keep the
screenshots in your `.gitignore`.
