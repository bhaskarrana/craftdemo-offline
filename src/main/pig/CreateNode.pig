DEFINE CREATENODE com.craftdemo.utils.CreateNode('$nodeName');
loadData = LOAD '$inputPath' USING org.apache.hive.hcatalog.pig.HCatLoader();
processData = FOREACH loadData
                      GENERATE CREATENODE(*);                    
processData = FILTER processData by $0 is NOT NULL;
STORE processData INTO '$outputPath' ;