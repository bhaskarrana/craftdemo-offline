/* CMD to execute
 pig -p inputPath=users_products -p outputPath=a1 -p edgeName=HAS_PRODUCT -p sourceNode=user -p sinkNode=product -useHCatalog e.pig
*/
DEFINE CREATEEDGE com.craftdemo.utils.CreateEdge ('$edgeName','$sourceNode','$sinkNode');

loadData = LOAD '$inputPath' USING org.apache.hive.hcatalog.pig.HCatLoader();
--- $0 is customerId and $1 is userId
processData = FOREACH loadData
                      GENERATE CREATEEDGE($0,$1);
processData = FILTER processData by $0 is NOT NULL;
STORE processData INTO '$outputPath' ;

