#Deploying a Simple App onto AWS 

Strategy - 

Phase 1
- Manually put IDP app on EC2
- Abililty to access app on EC2 via Route 53 domain
- Add SSL cert
- use s3/ some sort of DB

Phase 2
- See if we can dockerize my app and use ECS
- If we achieve that see if we can do the whole route 53 shiz



1. EC2 - https://www.sumologic.com/insight/what-is-aws-ec2/
   1. ssh -i "IDP_TEST_Keypair.pem" ec2-user@ec2-3-87-221-1.compute-1.amazonaws.com
   2. scp -i "IDP_TEST_Keypair.pem" /Users/michael.dang/code/learning/idp/build/libs/idp-0.0.1-SNAPSHOT.jar ec2-user@ec2-54-236-208-151.compute-1.amazonaws.com:~
   3. i had to sudo yum install java-1.8.0-openjdk on my EC2
   4. https://www.javacodegeeks.com/2019/10/deploy-spring-boot-application-aws-ec2-instance.html
2. Route 53 - Amazon Route 53 is a highly available and scalable Domain Name System (DNS) web service. Route 53 connects user requests to internet applications running on AWS or on-premises.
3. ECS - Amazon ECS is a fully-managed container orchestration service designed to make it easy for AWS users to deploy, manage, and scale popular containerized applications.

8-15-2022
1. https://w3path.com/point-domain-to-aws-ec2-instance/ 
   1. i created an elastic ip
   2. i used the DNS in godaddy to point to the elastic IP
   3. But its super slow.... 
2. Ok i instead changed my namespace to AWS instead of pointing to Elastic IP and it made everyhing super fast




8-20-2022
https://docs.aws.amazon.com/AmazonECS/latest/developerguide/get-set-up-for-amazon-ecs.html
1. created admin IAM user/group

https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-quickstart.html
1. setting up AWS CLI with my secret / accessId
2. aws ecr create-repository --profile idp  --repository-name hello-repository
3. https://stackoverflow.com/questions/71813817/aws-ec2-web-app-goes-down-when-command-prompt-is-closed
   1. lets hope the app is up tomorrow still
   2. java -jar jarfilename.jar &

8-21-2022
1. https://levelup.gitconnected.com/adding-a-custom-domain-and-ssl-to-aws-ec2-a2eca296facd
2. trying to get https to work
3. targetGroup + ALB 
4. Blocker - it seems like my ALB cant hit the EC2 instance


8-21-2022
1. https://levelup.gitconnected.com/adding-a-custom-domain-and-ssl-to-aws-ec2-a2eca296facd
2. i followed this to get ALB + EC2 to work
3. i struggled a lot, but i think its cause my app on the EC2 is not running on 80
   1. i solved that by creating a target group that listens on port 80 and forwards? the traffic to port 8080, where my app is running
   2. in the doc above i think it assumed my app was running on 80
   3. i also removed the Cnames in the DNS, it seems like i didnt need them
   4. i only needed to add the Cert to the ALB