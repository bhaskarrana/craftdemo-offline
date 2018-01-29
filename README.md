# craftdemo-offline

Biuild
mvn clean package
Workflow deployment

hadoop fs -put   /user/xyz/craftdemo/lib
hadoop fs -put    /user/xyz/craftdemo/subworkflow/


Workflow
$ export OOZIE_URL=http://localhost:9999/oozie/
$ oozie job -run -config job.properties
Coordinator
$ export OOZIE_URL=http://localhost:9999/oozie/
$ oozie job -run -config coordinator.properties

Check Status of a Job

You can check the status of your Job by using the Oozie ID (which is returned at submission time)
$ oozie job -info 0000004-091209145813488-oozie-dani-C



List All Jobs

You can check the status of all your Coordinator Jobs.
$ oozie jobs -jobtype coord
Stop/Kill A Job

$ oozie job -kill <oozie ID>



