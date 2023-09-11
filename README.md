# Screenshotbot example with Paparazzi

[![Screenshots](https://screenshotbot.io/badge?org=5fe2d92a7ceb64d41853c231&channel=paparazzi-example-circleci-test&branch=main)](https://screenshotbot.io/active-run?org=5fe2d92a7ceb64d41853c231&channel=paparazzi-example-circleci-test&branch=main)

This repository is an example of how to integration
[Paparazzi](https://github.com/cashapp/paparazzi)
with [Screenshotbot](https://screenshotbot.io).

See `.circleci/config.yml` to see the steps required for
configuration.


Roughly, you can use Paparazzi as-is: but instead of running Paparazzi
in `verify` mode, we always run in in `record` mode, and keep the
screenshots in your `.gitignore`.
