fluentlee
=========

rewrite of Fluentlee job scheduler


***from old site***

automation, batch scheduling, testing and reporting tool

System requirements: Java 6 platform (all other libs included in jar) or Java 7

- run simple jobs/commands (no concurrency/parallelism or piped commands) on win, linux, osx, solaris and z/os

- set global values and use them in jobs

- just drop schedule files into schedule folder, job server will take care

- aliases (groups of settings, for different users/groups/connectors) which can be transformed in well formed commandline set (POSIX like options (ie. tar -zxvf foo.tar.gz), GNU like long options (ie. du --human -readable --max-depth=1), Shell options ($property=value), Java like properties (ie. java -Djava.awt.headless=true - Djava.net.useSystemProxies=true Foo), Robot-Framework properties (--variable DB_HOST:dbservername --variable DATABASE_SID:some_SID) and DB url strings (TODO).

aliases primary role is to replace long params on commandline with single parameter

- several suites with up to 200 tests/runs inside of suite (mercurial version got 25 suites with 300 jobs for each suite)

- generated HTML report with detailed info on tests/runs (see report.html after run)

DEV version (update 3 and higher OR mercurial)

- job_server loading more than one schedule file

- http server serving reports, just connect to localhost:18111 by default

- db connectors and SQL jobs (oracle and sqlite, rest buggy)

- settings and security file

- self-healing (delete all folders except JAR itself and all will be re-created after start)

IN PROGRESS (mercurial version)

- sql resultset comparator

- ssh

- checksum of files

- encryption

- job server for accepting remote schedule.xml (switch between local and server)
