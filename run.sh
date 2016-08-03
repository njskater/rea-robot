set -e

export M2_HOME=/Users/jzhang/tools/apache-maven-3.3.3
export PATH=$M2_HOME/bin:$PATH
mvn clean install
mvn exec:java -Dexec.mainClass="demo.jerry.rea.robot.Main"
